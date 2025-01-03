package com.omie.celestium.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties RAW_CELESTIUM = new FoodProperties.Builder().alwaysEdible().nutrition(1).
            saturationModifier(0.1f).
            effect(new MobEffectInstance(MobEffects.POISON, 200), 1.0F).
            build();

    public static final FoodProperties PROCESSED_CELESTIUM = new FoodProperties.Builder().alwaysEdible().nutrition(1).
            saturationModifier(0.1f).build();
}
