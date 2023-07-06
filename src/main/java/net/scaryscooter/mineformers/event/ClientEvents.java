package net.scaryscooter.mineformers.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scaryscooter.mineformers.Mineformers;
import net.scaryscooter.mineformers.item.ModItems;
import net.scaryscooter.mineformers.networking.ModMessages;
import net.scaryscooter.mineformers.networking.packet.ExampleC2SPacket;
import net.scaryscooter.mineformers.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Mineformers.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.TESTING_KEY.consumeClick()) {
                Minecraft.getInstance().player.getItemInHand(InteractionHand.MAIN_HAND).copyAndClear();
                Minecraft.getInstance().player.setItemInHand(InteractionHand.MAIN_HAND, ModItems.TRANSFORMIUM_PICKAXE.get().asItem().getDefaultInstance());
            }
        }
    }
    @Mod.EventBusSubscriber(modid = Mineformers.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.TESTING_KEY);
        }
    }
}
