package net.scaryscooter.mineformers.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.scaryscooter.mineformers.item.ModItems;
import net.scaryscooter.mineformers.util.InventoryUtil;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TransformiumMultiTool extends Item {
    public TransformiumMultiTool(Properties properties) {
        super(properties);
    }

    public static CompoundTag isMultiTool = new CompoundTag();

    public static CompoundTag getIsMultiTool() {
        isMultiTool.putString("mineformers:transformium_multi_tool", "Transformium Multi-Tool");
        return isMultiTool;
    }

    public static ItemStack tool1, tool2, tool3, tool4, tool5;
    public static Item[] tools = {ModItems.TRANSFORMIUM_SWORD.get(),
            ModItems.TRANSFORMIUM_PICKAXE.get(),
            ModItems.TRANSFORMIUM_AXE.get(),
            ModItems.TRANSFORMIUM_SHOVEL.get(),
            ModItems.TRANSFORMIUM_HOE.get()};
    public static List<Item> toolList = Arrays.asList(tools);
    public static List<ItemStack> toolStack = Arrays.asList(tool1, tool2, tool3, tool4, tool5);
    public static boolean checkTool(ItemStack itemStack, Player player) {
        if (toolList.contains(itemStack.getItem())) {
            return true;
        } else {
            return false;
        }
    }

//    public static void addTool(ItemStack itemStack, Player player) {
//        if (checkTool(itemStack, player)) {
//            if (tool1 == null) {
//                tool1 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
//                tool1.setTag(getIsMultiTool());
//                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool1);
//                multiTool = tool1;
//            } else if (tool2 == null) {
//                tool2 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
//                tool2.setTag(getIsMultiTool());
//                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool2);
//                multiTool = tool2;
//            } else if (tool3 == null) {
//                tool3 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
//                tool3.setTag(getIsMultiTool());
//                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool3);
//                multiTool = tool3;
//            } else if (tool4 == null) {
//                tool4 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
//                tool4.setTag(getIsMultiTool());
//                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool4);
//                multiTool = tool4;
//            } else if (tool5 == null) {
//                tool5 = player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
//                tool5.setTag(getIsMultiTool());
//                player.getInventory().setItem(InventoryUtil.getFirstInventoryIndex(player, multiTool), tool5);
//                multiTool = tool5;
//            } else {
//                player.setItemInHand(InteractionHand.MAIN_HAND, player.getItemInHand(InteractionHand.MAIN_HAND));
//            }
//        }
//    }

    public static void switchTool(List<ItemStack> list, Player player) {
        if (player.getItemInHand(InteractionHand.MAIN_HAND).getTag() == getIsMultiTool()) {
            int index = list.indexOf(player.getItemInHand(InteractionHand.MAIN_HAND));

            if (list.indexOf(player.getItemInHand(InteractionHand.MAIN_HAND)) == 4) {
                player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                player.setItemInHand(InteractionHand.MAIN_HAND, list.get(0));
            } else {
                player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                player.setItemInHand(InteractionHand.MAIN_HAND, list.get(index + 1));
            }

        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        if (itemStack.hasTag()) {
            String currentMultiTool = itemStack.getTag().getString("mineformers:transformium_multi_tool");
            componentList.add(Component.literal(currentMultiTool).withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
    }
}
