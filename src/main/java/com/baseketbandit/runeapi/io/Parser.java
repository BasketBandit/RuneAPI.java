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
        List<Enum> skillNames = Arrays.asList(Skill.Name.values());
        Map<String, Skill> skills = new HashMap<>();
        String[] rawSkill = data.split("\n");

        int i = 0;
        for(String raw: rawSkill) {
            if(i < Skill.Name.values().length) {
                String[] r = raw.split(",");
                skills.put(skillNames.get(i).name(), new Skill(skillNames.get(i).name(), Integer.parseInt(r[0]), Integer.parseInt(r[1]), Integer.parseInt(r[2])));
                i++;
                continue;
            }
            break;
        }

        return skills;
    }
}
