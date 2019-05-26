package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RuneAPITest {

    @Test
    public void getStats() {
        Map<String, Skill> stats = RuneAPI.getStats("xwr");
        for(Skill skill: stats.values()) {
            System.out.println(skill.getName() + " - " + skill.getLevel());
        }
    }

    @Test
    public void getStatsNotFound() {
        Map<String, Skill> stats = RuneAPI.getStats("abcdefghijklmnopqrstuvwxyz");
        for(Skill skill: stats.values()) {
            System.out.println(skill.getName() + " - " + skill.getLevel());
        }
    }

    @Test
    public void getStatsNameSpace() {
        Map<String, Skill> stats = RuneAPI.getStats("Iron Lewiso");
        for(Skill skill: stats.values()) {
            System.out.println(skill.getName() + " - " + skill.getLevel());
        }
    }

    @Test
    public void getStatsMapped() {
        Map<String, Skill> stats = RuneAPI.getStats("xwr");
        Skill cooking = stats.get("Cooking");
        System.out.println(cooking.getLevel());
    }

    @Test
    public void getStatsMappedLowercase() {
        Map<String, Skill> stats = RuneAPI.getStats("xwr");
        Skill cooking = stats.get("Cooking");
        System.out.println(cooking.getLevel());
    }
}