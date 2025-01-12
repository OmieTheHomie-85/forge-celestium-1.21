package com.omie.celestium.GUI.framework;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class ButtonFactory {
    public static Button createButton(int x, int y, int h, int w, String label, Button.OnPress action){
        return new Button.Builder(Component.literal(label), action).bounds(x, y, h, w).build();
    }
}
