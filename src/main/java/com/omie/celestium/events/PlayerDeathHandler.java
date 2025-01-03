package com.omie.celestium.events;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

import static com.omie.celestium.Celestium.rCELESTIUM_EAT_COUNT_KEY;

public class PlayerDeathHandler {

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof ServerPlayer player) {
            int count = player.getPersistentData().getInt(rCELESTIUM_EAT_COUNT_KEY);
            if (count == 3){
                Objects.requireNonNull(player.getServer()).getPlayerList().broadcastSystemMessage(Component.literal(player.getName().getString() + " couldn't handle the raw power...."), false);


            }
        }
    }
}
