package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import com.baseketbandit.runeapi.io.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RuneAPI {
    private static final Logger log = LoggerFactory.getLogger(RuneAPI.class);

    public static Map<String, Skill> getStats(String username) {
        try {
            username = URLEncoder.encode(username, StandardCharsets.UTF_8.toString()); // url encode the string
            return new RequestHandler().fetchSkillData(username);
        } catch(UnsupportedEncodingException e) {
            log.error("An error occurred while running the {} class, message: {}", RuneAPI.class, e.getMessage(), e);
            return new HashMap<>();
        }
    }
}
