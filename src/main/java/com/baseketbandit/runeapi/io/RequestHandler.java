package com.baseketbandit.runeapi.io;

import com.baseketbandit.runeapi.entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestHandler {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private static final OkHttpClient client = new OkHttpClient();
    private static final String API_BASE = "https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=";

    /**
     * Connect to and return a HashMap of data from the RuneScape servers.
     *
     * @param username the username to do the request against
     * @return Map<Type, Skill> Map of objects of type Skill or an `empty` map if no results are found.
     */
    public Map<String, Skill> fetchSkillData(String username) {
        final Request request = new Request.Builder().url(API_BASE + username).build();

        try(Response response = client.newCall(request).execute()){

            if(response.code() == 200 && response.body() != null) {
                return parseStats(response.body().string());
            }

            if(response.code() != 200 || response.body() == null) {
                log.error("{}: No results found for username `{}`", response.code(), username);
            }

        } catch(IOException e) {
            log.error("There was a problem processing that request: {}", e.getCause(), e);
        }

        return new HashMap<>();
    }

    /**
     * Breaks down raw data from the API to a hash map of Skill objects.
     *
     * @param data raw data from the RuneScape API
     * @return Map<String, Skill> Map of objects of type Skill
     */
    private Map<String, Skill> parseStats(String data) {
        List<String> skills = Skills.asList;
        String[] skillData = data.split("\n");
        HashMap<String, Skill> skillMap = new HashMap<>();

        for(int i = 0; i < skills.size(); i++) {
            String[] r = skillData[i].split(",");
            skillMap.put(skills.get(i), new Skill(skills.get(i), Integer.parseInt(r[0]), Integer.parseInt(r[1]), Integer.parseInt(r[2])));
        }

        return skillMap;
    }
}
