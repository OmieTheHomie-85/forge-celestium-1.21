package com.omie.celestium.GUI.framework;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseScreen extends Screen {
    private final List<Button> buttons = new ArrayList<>();

    protected BaseScreen(Component pTitle) {
        super(pTitle);
    }

    @Override
    protected void init() {
        super.init();
        for (Button button : buttons) {
            this.addRenderableWidget(button);
        }
        onScreenInit();
    }

    public void addButton(Button button){
        this.buttons.add(button);
    }

    public abstract void onScreenInit();
    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick); // Render the background
        pGuiGraphics.drawCenteredString(
                this.font,
                this.title.getString(),
                this.width / 2,
                20,
                0xFFFFFF // White color
        );
        super.render(pGuiGraphics, pMouseX, pMouseY,pPartialTick);
    }
    
}
