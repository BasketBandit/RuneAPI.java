package com.baseketbandit.runeapi.entity;

public class Skill {

    private final String name;
    private final int rank;
    private final int level;
    private final int experience;

    public Skill(String name, int rank, int level, int experience) {
        this.name = name;
        this.rank = rank;
        this.level = level;
        this.experience = experience;
    }

    public String getName() {
        return name;
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

    public enum Name {
        Overall,
        Attack,
        Defence,
        Strength,
        Hitpoints,
        Ranged,
        Prayer,
        Magic,
        Cooking,
        Woodcutting,
        Fletching,
        Fishing,
        Firemaking,
        Crafting,
        Smithing,
        Mining,
        Herblore,
        Agility,
        Thieving,
        Slayer,
        Farming,
        Runecraft,
        Hunter,
        Construction
    }
}
