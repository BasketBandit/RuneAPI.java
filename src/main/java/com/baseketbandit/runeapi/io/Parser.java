package com.baseketbandit.runeapi.io;

import com.baseketbandit.runeapi.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Parser {

    /**
     * Breaks down raw data from the API to a list of Skill objects.
     *
     * @param data raw data from the RuneScape API
     * @return List<Skill> list of objects of type Skill
     */
    static List<Skill> parseStats(String data) {
        List<Enum> skillNames = Arrays.asList(Skill.Name.values());
        ArrayList<Skill> skills = new ArrayList<>();
        String[] rawSkill = data.split("\n");
        int i = 0;
        for(String raw: rawSkill) {
            if(i < Skill.Name.values().length) {
                String[] r = raw.split(",");
                skills.add(new Skill(skillNames.get(i).name(), Integer.parseInt(r[0]), Integer.parseInt(r[1]), Integer.parseInt(r[2])));
                i++;
                continue;
            }
            break;
        }
        return skills;
    }
}
