package net.scaryscooter.mineformers.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.mineformers.Mineformers;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Mineformers.MOD_ID);

    public static RegistryObject<CreativeModeTab> MINEFORMERS_TAB = CREATIVE_MODE_TABS.register("mineformers_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TRANSFORMIUM.get()))
                    .title(Component.translatable("creativemodetab.mineformers_tab")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
