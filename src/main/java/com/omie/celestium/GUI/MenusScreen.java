package com.omie.celestium.GUI;

import com.omie.celestium.GUI.framework.BaseScreen;
import com.omie.celestium.GUI.framework.ButtonFactory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;


public class MenusScreen extends BaseScreen {
    private int level = 0;

    public MenusScreen(){
        super(Component.literal("Menus Screen"));

    }

    @Override
    public void onScreenInit() {
        addButton(ButtonFactory.createButton(this.width / 2 - 60, this.height / 2 - 20, 120, 20, "Level: " + level, pButton ->{
            level++;
            this.minecraft.player.displayClientMessage(Component.literal("Leveled up to " + level), true);
        }));
        addButton(ButtonFactory.createButton(this.width / 2 - 60, this.height / 2 + 10, 120, 20 , "Back", button -> {
            this.minecraft.setScreen(null); // Close the screen
        }));

    }

}
