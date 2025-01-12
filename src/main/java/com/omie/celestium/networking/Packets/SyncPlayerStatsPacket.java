package com.omie.celestium.networking.Packets;

import com.omie.celestium.PlayerStats.PlayerStats;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;

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
        return new SyncPlayerStatsPacket(
                buffer.readInt(),
                buffer.readInt(),
                buffer.readInt(),
                buffer.readInt()
        );
    }
//    public static void handle(SyncPlayerStatsPacket packet, Supplier<NetworkEvent.Context> context) {
//        context.get().enqueueWork(() -> {
//            // Update the player's stats on the client
//            Minecraft.getInstance().player.getCapability(PlayerStats.INSTANCE).ifPresent(stats -> {
//                stats.setLevel(packet.level);
//                stats.setStrength(packet.strength);
//                stats.setAgility(packet.agility);
//                stats.setStatPoints(packet.statPoints);
//            });
//        });
//        context.get().setPacketHandled(true);
//    }
}
