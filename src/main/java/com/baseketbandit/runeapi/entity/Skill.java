package com.baseketbandit.runeapi.entity;

public class Skill {
    private final Type name;
    private final int rank;
    private final int level;
    private final int experience;

    public Skill(Type name, int rank, int level, int experience) {
        this.name = name;
        this.rank = rank;
        this.level = level;
        this.experience = experience;
    }

    public String getName() {
        return name.name;
    }

    public int getRank() {
        return rank;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

}
