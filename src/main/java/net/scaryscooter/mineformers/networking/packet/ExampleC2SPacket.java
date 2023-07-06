package net.scaryscooter.mineformers.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.commands.GiveCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.scaryscooter.mineformers.item.ModItems;

import java.util.function.Supplier;

public class ExampleC2SPacket {
    public ExampleC2SPacket() {

    }
    public ExampleC2SPacket(FriendlyByteBuf buf) {

    }
    public void toByte(FriendlyByteBuf buf) {

    }
//    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
//        NetworkEvent.Context context = supplier.get();
//        context.enqueueWork(() -> {
//
//            ServerPlayer player = context.getSender();
//            ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);
//
//            if(itemInHand.isEmpty()) {
//                ModItems.ENERGON_CUBE.get().asItem();
//            }
//
//        });
//        return true;
//    }
}
