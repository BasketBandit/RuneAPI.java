package com.baseketbandit.runeapi.io;

import com.baseketbandit.runeapi.entity.*;

import java.util.*;

class Parser {

    /**
     * Breaks down raw data from the API to a hash map of Skill objects.
     *
     * @param data raw data from the RuneScape API
     * @return Map<String, Skill> HashMap of objects of type Skill
     */
    static Map<String, Skill> parseStats(String data) {
        List<Enum> names = Arrays.asList(Skills.values());
        Map<String, Skill> skills = new HashMap<>();
        String[] raw = data.split("\n");

        for(int i = 0; i < raw.length; i++) {
            if(i < Skills.values().length) {
                String[] r = raw[i].split(",");
                skills.put(names.get(i).name(), new Skill(names.get(i).name(), Integer.parseInt(r[0]), Integer.parseInt(r[1]), Integer.parseInt(r[2])));
                continue;
            }
            break;
        }

        return skills;
    }
}
