package com.omie.celestium.networking.Packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class TeleportC2SPacket {
    public TeleportC2SPacket() {

    }

    // Encode data to send
    public static void encode(TeleportC2SPacket packet, FriendlyByteBuf buffer) {

    }

    // Decode data when received
    public static TeleportC2SPacket decode(FriendlyByteBuf buffer) {
        return new TeleportC2SPacket();
    }

    // Packet Handler
    public static void handle(TeleportC2SPacket packet, CustomPayloadEvent.Context ctx) {

    }
}
