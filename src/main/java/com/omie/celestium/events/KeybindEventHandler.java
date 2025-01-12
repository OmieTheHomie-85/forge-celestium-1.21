package com.omie.celestium.events;

import com.omie.celestium.GUI.MenusScreen;
import com.omie.celestium.ModKeybinds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeybindEventHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (ModKeybinds.OPEN_GUI_KEY.isDown()) {

            Minecraft instance = Minecraft.getInstance();
            Screen currentScreen = instance.screen;

            if (currentScreen instanceof MenusScreen){
                instance.setScreen(null);
            } else{
                instance.setScreen(new MenusScreen());
            }

        }
    }
}
