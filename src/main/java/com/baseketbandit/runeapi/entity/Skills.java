package com.baseketbandit.runeapi.entity;

import java.util.Arrays;
import java.util.List;

public interface Skills {
    String OVERALL = "Overall";
    String ATTACK = "Attack";
    String DEFENCE = "Defence";
    String STRENGTH = "Strength";
    String HITPOINTS = "Hitpoints";
    String RANGED = "Ranged";
    String PRAYER = "Prayer";
    String MAGIC = "Magic";
    String COOKING = "Cooking";
    String WOODCUTTING = "Woodcutting";
    String FLETCHING = "Fletching";
    String FISHING = "Fishing";
    String FIREMAKING = "Firemaking";
    String CRAFTING = "Crafting";
    String SMITHING = "Smithing";
    String MINING = "Mining";
    String HERBLORE = "Herblore";
    String AGILITY = "Agility";
    String THIEVING = "Thieving";
    String SLAYER = "Slayer";
    String FARMING = "Farming";
    String RUNECRAFT = "Runecraft";
    String HUNTER = "Hunter";
    String CONSTRUCTION = "Construction";

    List<String> asList = Arrays.asList(OVERALL, ATTACK, DEFENCE, STRENGTH, HITPOINTS, RANGED, PRAYER, MAGIC, COOKING, WOODCUTTING, FLETCHING, FISHING, FIREMAKING, CRAFTING, SMITHING, MINING, HERBLORE, AGILITY, THIEVING, SLAYER, FARMING, RUNECRAFT, HUNTER, CONSTRUCTION);
}
