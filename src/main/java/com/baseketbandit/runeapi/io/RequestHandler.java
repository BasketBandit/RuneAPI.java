package com.baseketbandit.runeapi.io;

import com.baseketbandit.runeapi.entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private static final OkHttpClient client = new OkHttpClient();
    private static final String API_BASE = "https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=";

    /**
     * A OkHttp method used to connect to and return a HashMap of data from the server.
     *
     * @param username the username to do the request against
     * @return Map<Type, Skill> Map of objects of type Skill or an `empty` map if no results are found.
     */
    public static Map<Type, Skill> doGetRequest(String username) {
        try {
            Request request = new Request.Builder()
                    .url(API_BASE + username)
                    .build();
            Response response = client.newCall(request).execute();

            if(response.code() != 200) {
                log.error(response.code() + ": No results found for username `" + username.replace("%20", " ") + "`");
                response.close();
                return new HashMap<>();
            }

            if(response.body() == null) {
                response.close();
                return new HashMap<>();
            }

            final String data = response.body().string();
            response.close();

            return Parser.parseStats(data);
        } catch(IOException e) {
            log.error("There was a problem processing that request. [Highscores OSRS]");
            return new HashMap<>();
        }
    }
}
