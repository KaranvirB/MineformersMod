package net.scaryscooter.mineformers.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InventoryUtil {
    public static boolean hasPlayerStackInInventory(Player player, ItemStack itemStack) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack currentStack = player.getInventory().getItem(i);
            if (!currentStack.isEmpty() && currentStack.is(itemStack.getItem())) {
                return true;
            }
        }
        return false;
    }

    public static int getFirstInventoryIndex(Player player, ItemStack itemStack) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack currentStack = player.getInventory().getItem(i);
            if (!currentStack.isEmpty() && currentStack.is(itemStack.getItem())) {
                return i;
            }
        }
        return -1;
    }
}
