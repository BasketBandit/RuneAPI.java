package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import com.baseketbandit.runeapi.io.RequestHandler;

import java.util.Map;

public class RuneAPI {

    public static Map<String, Skill> getStats(String username) {
        return RequestHandler.doRequest(username.replace(" ", "%20"));
    }
}
