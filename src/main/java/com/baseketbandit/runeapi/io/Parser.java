package com.baseketbandit.runeapi.io;

import com.baseketbandit.runeapi.entity.*;

import java.util.*;

class Parser {

    /**
     * Breaks down raw data from the API to a hash map of Skill objects.
     *
     * @param data raw data from the RuneScape API
     * @return Map<Type, Skill> Map of objects of type Skill
     */
    static Map<Type, Skill> parseStats(String data) {
        List<Type> types = Arrays.asList(Type.values());
        EnumMap<Type, Skill> skillMap = new EnumMap<>(Type.class);
        String[] lineSplitData = data.split("\n");

        for(int i = 0; i < lineSplitData.length; i++) {
            if(i < Type.values().length) {
                String[] r = lineSplitData[i].split(",");
                skillMap.put(types.get(i), new Skill(types.get(i), Integer.parseInt(r[0]), Integer.parseInt(r[1]), Integer.parseInt(r[2])));
                continue;
            }
            break;
        }

        return skillMap;
    }
}
