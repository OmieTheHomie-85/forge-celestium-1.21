package com.omie.celestium.item.custom;

import com.omie.celestium.item.ModFoods;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.core.jmx.Server;

import static com.omie.celestium.Celestium.rCELESTIUM_EAT_COUNT_KEY;

public class RawCelestiumItem extends Item {


    public RawCelestiumItem(Properties pProperties) {
        super(pProperties.food(ModFoods.RAW_CELESTIUM));
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (entity instanceof Player player){
            int count = player.getPersistentData().getInt(rCELESTIUM_EAT_COUNT_KEY) + 1;
            player.getPersistentData().putInt(rCELESTIUM_EAT_COUNT_KEY, count);
            if (count >= 3) {
                if (player instanceof ServerPlayer) {
                    ServerPlayer serverPlayer = (ServerPlayer)player;
                    if (serverPlayer.gameMode.getGameModeForPlayer() != GameType.CREATIVE) {
                        serverPlayer.kill();
                    }
                }
                player.getPersistentData().putInt(rCELESTIUM_EAT_COUNT_KEY, 0);
            }
        }
        return super.finishUsingItem(stack, world, entity);
    }
}
