package com.omie.celestium.PlayerStats;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerStatsProvider implements ICapabilityProvider{
    public static Capability<PlayerStats> PLAYER_STATS = CapabilityManager.get(new CapabilityToken<PlayerStats>() { });

    private PlayerStats stats = null;
    private final LazyOptional<PlayerStats> optional = LazyOptional.of(this::createPlayerStats);

    private PlayerStats createPlayerStats() {
        if(this.stats == null){
            this.stats = new PlayerStats();
        }
        return this.stats;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap==PLAYER_STATS){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

}
