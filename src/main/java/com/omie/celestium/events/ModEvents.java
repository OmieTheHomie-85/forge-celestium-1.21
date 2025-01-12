package com.omie.celestium.events;


import com.omie.celestium.Celestium;
import com.omie.celestium.PlayerStats.PlayerStatsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class ModEvents {
    private static final ResourceLocation PLAYER_STATS = ResourceLocation.fromNamespaceAndPath(Celestium.MOD_ID, "player_stats");

    @SubscribeEvent
    public void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PlayerStatsProvider.PLAYER_STATS).isPresent()) {
                event.addCapability(PLAYER_STATS, new PlayerStatsProvider());
            }
        }
    }
}
