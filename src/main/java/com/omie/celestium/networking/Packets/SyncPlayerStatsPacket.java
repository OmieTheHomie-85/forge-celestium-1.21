package com.omie.celestium.networking.Packets;

import com.omie.celestium.PlayerStats.PlayerStats;
import com.omie.celestium.PlayerStats.PlayerStatsProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.network.NetworkContext;
import net.minecraftforge.network.NetworkInstance;
import net.minecraftforge.network.PacketDistributor;
import net.minecraft.network.protocol.Packet;


import java.util.function.Supplier;


public class SyncPlayerStatsPacket {
    private final int level;
    private final int strength;
    private final int agility;
    private final int statPoints;


    public SyncPlayerStatsPacket(int level, int strength, int agility, int statPoints) {
        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.statPoints = statPoints;
    }

    // Encode data to send
    public static void encode(SyncPlayerStatsPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.level);
        buffer.writeInt(packet.strength);
        buffer.writeInt(packet.agility);
        buffer.writeInt(packet.statPoints);
    }

    // Decode data when received
    public static SyncPlayerStatsPacket decode(FriendlyByteBuf buffer) {
        return new SyncPlayerStatsPacket(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
    }

    // Packet Handler
    public static void handle(SyncPlayerStatsPacket packet, CustomPayloadEvent.Context ctx) {


        ctx.enqueueWork(() -> {
            // Ensure the player exists before updating stats
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.getCapability(PlayerStatsProvider.PLAYER_STATS).ifPresent(stats -> {
                    stats.setLevel(packet.level);
                    stats.setStrength(packet.strength);
                    stats.setAgility(packet.agility);
                    stats.setStatPoints(packet.statPoints);
                });
            }
        });

        ctx.setPacketHandled(true);

    }
}
