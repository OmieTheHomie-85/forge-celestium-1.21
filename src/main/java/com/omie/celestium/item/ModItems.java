package com.omie.celestium.item;

import com.omie.celestium.Celestium;
import com.omie.celestium.item.custom.ProcessedCelestiumItem;
import com.omie.celestium.item.custom.RawCelestiumItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Celestium.MOD_ID);

    public static final RegistryObject<Item> RAW_CELESTIUM = ITEMS.register("raw_celestium",
            () -> new RawCelestiumItem((new Item.Properties()).food(ModFoods.RAW_CELESTIUM)));

    public static final RegistryObject<Item> PROCESSED_CELESTIUM = ITEMS.register("processed_celestium",
            () -> new ProcessedCelestiumItem((new Item.Properties()).food(ModFoods.PROCESSED_CELESTIUM)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
