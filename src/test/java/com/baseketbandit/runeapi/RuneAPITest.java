package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import com.baseketbandit.runeapi.entity.Type;
import org.junit.Test;

import java.util.Map;

public class RuneAPITest {

    @Test
    public void getStats() {
        Map<Type, Skill> stats = RuneAPI.getStats("xwr");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);

        for(Skill skill: stats.values()) {
            System.out.printf("%s: #%,d - %,d - %,dxp \n", skill.getName(), skill.getRank(), skill.getLevel(), skill.getExperience());
        }
    }

    @Test
    public void getStatsNotFound() {
        Map<Type, Skill> stats = RuneAPI.getStats("abcdefghijklmnopqrstuvwxyz");
        assert(stats.isEmpty());
    }

    @Test
    public void getStatsNameSpace() {
        Map<Type, Skill> stats = RuneAPI.getStats("Iron Lewiso");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);

        for(Skill skill: stats.values()) {
            System.out.println(skill.getName() + " - " + skill.getLevel());
        }
    }

    @Test
    public void getStatsMapped() {
        Map<Type, Skill> stats = RuneAPI.getStats("xwr");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);

        Skill cooking = stats.get(Type.COOKING);
        assert(!cooking.getName().equals(""));

        System.out.println(cooking.getLevel());
    }
}