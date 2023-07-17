package net.scaryscooter.mineformers.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scaryscooter.mineformers.Mineformers;
import net.scaryscooter.mineformers.networking.ModMessages;
import net.scaryscooter.mineformers.networking.packet.ChangeToolC2SPacket;
import net.scaryscooter.mineformers.networking.packet.AddToolC2SPacket;
import net.scaryscooter.mineformers.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Mineformers.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
//        public static ItemStack saved;

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {

            if(KeyBinding.ADD_TOOL.consumeClick()) {
//                saved = Minecraft.getInstance().player.getItemInHand(InteractionHand.MAIN_HAND).copy();
                ModMessages.sendToServer(new AddToolC2SPacket());
            }

            if (KeyBinding.CHANGE_TOOL.consumeClick()) {
//                Minecraft.getInstance().player.setItemInHand(InteractionHand.MAIN_HAND, saved);
                ModMessages.sendToServer(new ChangeToolC2SPacket());
            }

        }
    }
    @Mod.EventBusSubscriber(modid = Mineformers.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.ADD_TOOL);
            event.register(KeyBinding.CHANGE_TOOL);
        }
    }
}
