package com.omie.celestium.Keybinds;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeybindEventHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (ModKeybinds.OPEN_GUI_KEY.isDown()) {



        }
    }
}
