package com.baseketbandit.runeapi.io;

import com.baseketbandit.runeapi.entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestHandler {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * A OkHttp method used to connect to and return the string of data from the server.
     *
     * @param username the username to do the request against
     * @return List<Skill> list of objects of type Skill or an `empty` list if no results are found.
     */
    public static List<Skill> doRequest(String username) {
        try {
            Request request = new Request.Builder()
                    .url("https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + username)
                    .build();
            Response response = client.newCall(request).execute();

            if(response.code() != 200) {
                log.error(response.code() + " - No results found for username `" + username.replace("%20", " ") + "`");
                return new ArrayList<>();
            }

            return Parser.parseStats(response.body().string());
        } catch(IOException e) {
            log.error("There was a problem processing that request. [Highscores OSRS]");
            return new ArrayList<>();
        }
    }
}
