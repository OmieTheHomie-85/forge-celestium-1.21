package com.omie.celestium.item.custom;

import com.omie.celestium.item.ModFoods;
import net.minecraft.world.item.Item;

public class ProcessedCelestiumItem extends Item {
    public ProcessedCelestiumItem(Properties pProperties) {
        super(pProperties.food(ModFoods.PROCESSED_CELESTIUM));
    }
}
