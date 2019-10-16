package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import com.baseketbandit.runeapi.entity.Type;
import org.junit.jupiter.api.Test;

import java.util.Map;

class RuneAPITest {

    @Test
    void getStats() {
        Map<Type, Skill> stats = RuneAPI.getStats("xwr");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);
    }

    @Test
    void getStatsNotFound() {
        Map<Type, Skill> stats = RuneAPI.getStats("abcdefghijklmnopqrstuvwxyz");
        assert(stats.isEmpty());
    }

    @Test
    void getStatsNameSpace() {
        Map<Type, Skill> stats = RuneAPI.getStats("Iron Lewiso");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);
    }

    @Test
    void getStatsMapped() {
        Map<Type, Skill> stats = RuneAPI.getStats("xwr");
        assert(!stats.isEmpty());
        assert(stats.size() == 24);

        Skill cooking = stats.get(Type.COOKING);
        assert(!cooking.getName().equals(""));
        assert(cooking.getLevel() == 99);
    }
}