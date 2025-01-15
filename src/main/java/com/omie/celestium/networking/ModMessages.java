package com.omie.celestium.networking;

import com.omie.celestium.Celestium;
import com.omie.celestium.networking.Packets.SyncPlayerStatsPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.SimpleChannel;

public class ModMessages {
    private static final int PROTOCOL_VERSION = 1;
    public static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id(){
        return packetId++;
    }

    public void register() {
        int id = 0;
        INSTANCE = ChannelBuilder.named(ResourceLocation.fromNamespaceAndPath(Celestium.MOD_ID, "messages"))
                .networkProtocolVersion(PROTOCOL_VERSION)
                .clientAcceptedVersions((version, s) -> true)
                .serverAcceptedVersions((version, s )-> true)
                .simpleChannel();
        INSTANCE.messageBuilder(SyncPlayerStatsPacket.class, packetId++)
                .encoder(SyncPlayerStatsPacket::encode)
                .decoder(SyncPlayerStatsPacket::decode)
                .consumerMainThread(SyncPlayerStatsPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG msg){

    }
}
