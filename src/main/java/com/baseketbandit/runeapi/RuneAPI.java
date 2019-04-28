package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import com.baseketbandit.runeapi.io.RequestHandler;

import java.util.List;

public class RuneAPI {

    public static List<Skill> getStats(String username) {
        return RequestHandler.doRequest(username.replace(" ", "%20"));
    }
}
