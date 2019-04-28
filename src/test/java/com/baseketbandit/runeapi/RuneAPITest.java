package com.baseketbandit.runeapi;

import com.baseketbandit.runeapi.entity.Skill;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RuneAPITest {

    @Test
    public void getStats() {
        List<Skill> stats = RuneAPI.getStats("xwr");
        for(Skill skill: stats) {
            System.out.println(skill.getName() + " - " + skill.getLevel());
        }
    }

    @Test
    public void getStatsNotFound() {
        List<Skill> stats = RuneAPI.getStats("abcdefghijklmnopqrstuvwxyz");
        for(Skill skill: stats) {
            System.out.println(skill.getName() + " - " + skill.getLevel());
        }
    }

    @Test
    public void getStatsNameSpace() {
        List<Skill> stats = RuneAPI.getStats("Iron Lewiso");
        for(Skill skill: stats) {
            System.out.println(skill.getName() + " - " + skill.getLevel());
        }
    }
}