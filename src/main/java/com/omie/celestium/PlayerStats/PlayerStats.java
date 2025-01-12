package com.omie.celestium.PlayerStats;

import net.minecraft.nbt.CompoundTag;

public class PlayerStats {
    private int level = 1;
    private int statPoints = 0;
    private int strength = 0;
    private int agility = 0;

    public int getLevel() {
        return level;
    }
    public void addLevel(int amt){
        this.level+=amt;
    }


    public int getStatPoints() {
        return statPoints;
    }
    public void addStatPoints(int amt){
        this.statPoints += amt;
    }
    public void spendStatPoints(){
        statPoints = Math.max(0, this.statPoints - 1);
    }

    public int getStrength() {
        return strength;
    }
    public void increaseStrength() {
        if (statPoints > 0){
            this.strength++;
            spendStatPoints();
        }
    }

    public int getAgility() {
        return agility;
    }
    public void increaseAgility() {
        if (statPoints > 0){
            this.agility++;
            spendStatPoints();
        }
    }

    public void copyFrom(PlayerStats source){
        this.level = source.getLevel();
        this.strength = source.getStrength();
        this.agility = source.getAgility();
        this.statPoints = source.getStatPoints();

    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("level", level);
        nbt.putInt("pts", statPoints);
        nbt.putInt("strength", strength);
        nbt.putInt("agility", agility);
    }

    public void loadNBTData(CompoundTag nbt){
        level = nbt.getInt("level");
        statPoints = nbt.getInt("pts");
        strength = nbt.getInt("strength");
        agility = nbt.getInt("agility");
    }

}
