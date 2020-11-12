package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import com.baseketbandit.runeapi.entity.Skills;
import org.junit.jupiter.api.Test;

import java.util.Map;

class RuneAPITest {

    @Test
    void getStats() {
        Map<String, Skill> stats = RuneAPI.getStats("xwr");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);
    }

    @Test
    void getStatsNotFound() {
        Map<String, Skill> stats = RuneAPI.getStats("abcdefghijklmnopqrstuvwxyz");
        assert(stats.isEmpty());
    }

    @Test
    void getStatsNameSpace() {
        Map<String, Skill> stats = RuneAPI.getStats("Iron Lewiso");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);
    }

    @Test
    void getStatsNameSpecialChars() {
        Map<String, Skill> stats = RuneAPI.getStats("?abc&def!£$%^&*");
        assert(stats.isEmpty());
    }

    @Test
    void getStatsMapped() {
        Map<String, Skill> stats = RuneAPI.getStats("xwr");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);

        Skill cooking = stats.get(Skills.COOKING);
        assert(!cooking.getName().equals(""));
        assert(cooking.getLevel() == 99);
        assert(cooking.getExperience() > 13000000);
        assert(cooking.getRank() > -1);
    }
}