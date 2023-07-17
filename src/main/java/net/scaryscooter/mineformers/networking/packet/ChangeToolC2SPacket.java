package net.scaryscooter.mineformers.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.List;
import java.util.function.Supplier;

import static net.scaryscooter.mineformers.item.custom.TransformiumMultiTool.switchTool;
import static net.scaryscooter.mineformers.item.custom.TransformiumMultiTool.toolStack;
import static net.scaryscooter.mineformers.networking.packet.AddToolC2SPacket.*;

public class ChangeToolC2SPacket {
    public ChangeToolC2SPacket() {

    }
    public ChangeToolC2SPacket(FriendlyByteBuf buf) {

    }
    public void toByte(FriendlyByteBuf buf) {

    }

    public static ItemStack saved;

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {

            ServerPlayer player = context.getSender();
            ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);

            switchTool(toolStack, player);

        });
        return true;
    }

//    public static void switchTool(List<ItemStack> list, Player player) {
//        if (player.getItemInHand(InteractionHand.MAIN_HAND).getTag() == getIsMultiTool()) {
//            int index = list.indexOf(player.getItemInHand(InteractionHand.MAIN_HAND));
//
//            if (list.indexOf(player.getItemInHand(InteractionHand.MAIN_HAND)) == 4) {
////                player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
//                player.setItemInHand(InteractionHand.MAIN_HAND, list.get(0));
//                multiTool = player.getItemInHand(InteractionHand.MAIN_HAND);
//            } else {
////                player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
//                player.setItemInHand(InteractionHand.MAIN_HAND, list.get(index + 1));
//                multiTool = player.getItemInHand(InteractionHand.MAIN_HAND);
//            }
//
//        }
//    }

}
