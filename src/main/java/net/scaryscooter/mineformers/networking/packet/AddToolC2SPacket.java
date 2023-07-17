package net.scaryscooter.mineformers.networking.packet;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.scaryscooter.mineformers.item.ModItems;
import net.scaryscooter.mineformers.util.InventoryUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static net.scaryscooter.mineformers.item.custom.TransformiumMultiTool.*;
import static net.scaryscooter.mineformers.networking.packet.ChangeToolC2SPacket.saved;

public class AddToolC2SPacket {
    public AddToolC2SPacket() {

    }
    public AddToolC2SPacket(FriendlyByteBuf buf) {

    }
    public void toByte(FriendlyByteBuf buf) {

    }
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {

            ServerPlayer player = context.getSender();
            ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);

            addTool(itemInHand, player);

        });
        return true;
    }

//    public static CompoundTag isMultiTool = new CompoundTag();
//    public static CompoundTag getIsMultiTool() {
//        isMultiTool.putString("mineformers.transformium_multi_tool", "Transformium Multi-Tool");
//        return isMultiTool;
//    }
//    public static ItemStack tool1, tool2, tool3, tool4, tool5 = null;
    public static ItemStack multiTool = ModItems.TRANSFORMIUM_MULTI_TOOL.get().getDefaultInstance();
//    public static Item[] tools = {ModItems.TRANSFORMIUM_SWORD.get(),
//            ModItems.TRANSFORMIUM_PICKAXE.get(),
//            ModItems.TRANSFORMIUM_AXE.get(),
//            ModItems.TRANSFORMIUM_SHOVEL.get(),
//            ModItems.TRANSFORMIUM_HOE.get()};
//    public static List<Item> toolList = Arrays.asList(tools);
//    public static List<ItemStack> toolStack = Arrays.asList(tool1, tool2, tool3, tool4, tool5);
//    public static boolean checkTool(ItemStack itemStack, Player player) {
//        if (toolList.contains(itemStack.getItem())) {
//            if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.TRANSFORMIUM_MULTI_TOOL.get().getDefaultInstance())) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
//
    public void addTool(ItemStack itemStack, Player player) {
        if (checkTool(itemStack, player)) {
            if (tool1 == null) {
                tool1 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                tool1.setTag(getIsMultiTool());
                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool1);
                multiTool = tool1;
            } else if (tool2 == null) {
                tool2 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                tool2.setTag(getIsMultiTool());
                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool2);
                multiTool = tool2;
            } else if (tool3 == null) {
                tool3 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                tool3.setTag(getIsMultiTool());
                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool3);
                multiTool = tool3;
            } else if (tool4 == null) {
                tool4 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                tool4.setTag(getIsMultiTool());
                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool4);
                multiTool = tool4;
            } else if (tool5 == null) {
                tool5 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                tool5.setTag(getIsMultiTool());
                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool5);
                multiTool = tool5;
            } else {
                player.setItemInHand(InteractionHand.MAIN_HAND, player.getItemInHand(InteractionHand.MAIN_HAND));
            }
        }
    }

}
