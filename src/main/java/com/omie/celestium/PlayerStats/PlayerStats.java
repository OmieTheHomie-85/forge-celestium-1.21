package com.omie.celestium.PlayerStats;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.capabilities.Capability;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.NotNull;

@AutoRegisterCapability
public class PlayerStats {

    private int level = 1;
    private int statPoints = 0;
    private int agility = 0;
    private int strength = 0;
    private int health = 0;
    private int xp = 0;
    private int maxXp = 100;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStatPoints(int statPoints) {
        this.statPoints = statPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp, ServerPlayer player) {
        this.xp += xp;
        this.checkLevelUp(player);
    }

    private void checkLevelUp(ServerPlayer player) {
        while(xp >= maxXp){
            xp -= maxXp;
            this.level++;
            this.statPoints++;
            maxXp = (int) (100 * Math.pow(1.5, level-1));
            player.sendSystemMessage(Component.literal("You leveled up! New Level: " + level));
        }
    }


}
