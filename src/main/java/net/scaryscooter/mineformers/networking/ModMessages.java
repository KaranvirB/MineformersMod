package net.scaryscooter.mineformers.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.scaryscooter.mineformers.Mineformers;
import net.scaryscooter.mineformers.networking.packet.ChangeToolC2SPacket;
import net.scaryscooter.mineformers.networking.packet.AddToolC2SPacket;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Mineformers.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(AddToolC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(AddToolC2SPacket::new)
                .encoder(AddToolC2SPacket::toByte)
                .consumerMainThread(AddToolC2SPacket::handle)
                .add();

        net.messageBuilder(ChangeToolC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ChangeToolC2SPacket::new)
                .encoder(ChangeToolC2SPacket::toByte)
                .consumerMainThread(ChangeToolC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
