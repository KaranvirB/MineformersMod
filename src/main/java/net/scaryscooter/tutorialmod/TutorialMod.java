package net.scaryscooter.tutorialmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.scaryscooter.tutorialmod.block.ModBlocks;
import net.scaryscooter.tutorialmod.item.ModCreativeModeTabs;
import net.scaryscooter.tutorialmod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Very important comment
    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTab() == ModCreativeModeTabs.CYBERTRON_GEAR_TAB.get()) {
            event.accept(ModItems.TRANSFORMIUM);
            event.accept(ModItems.RAW_TRANSFORMIUM);
            event.accept(ModItems.DARK_ENERGON_CRYSTAL);
            event.accept(ModItems.ENERGON_CUBE);
            event.accept(ModItems.RAW_UNSTABLE_TRANSFORMIUM);
            event.accept(ModItems.UNSTABLE_TRANSFORMIUM);
            event.accept(ModItems.TRANSFORMIUM_CORE);
            event.accept(ModItems.ENERGIZED_TRANSFORMIUM_CORE);
            event.accept(ModItems.SQUIRREL);

            event.accept(ModItems.TRANSFORMIUM_SWORD);
            event.accept(ModItems.TRANSFORMIUM_PICKAXE);
            event.accept(ModItems.TRANSFORMIUM_AXE);
            event.accept(ModItems.TRANSFORMIUM_SHOVEL);
            event.accept(ModItems.TRANSFORMIUM_HOE);

            event.accept(ModItems.TRANSFORMIUM_HELMET);
            event.accept(ModItems.TRANSFORMIUM_CHESTPLATE);
            event.accept(ModItems.TRANSFORMIUM_LEGGINGS);
            event.accept(ModItems.TRANSFORMIUM_BOOTS);

            event.accept(ModBlocks.TRANSFORMIUM_BLOCK);
            event.accept(ModBlocks.DARK_ENERGON_BLOCK);
            event.accept(ModBlocks.ENERGON_BLOCK);

            event.accept(ModBlocks.TRANSFORMIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_TRANSFORMIUM_ORE);
            event.accept(ModBlocks.UNSTABLE_TRANSFORMIUM_ORE);
            event.accept(ModBlocks.DARK_ENERGON_ORE);
            event.accept(ModBlocks.ENERGON_ORE);

            event.accept(ModBlocks.CYBERFORMED_LEAVES);
            event.accept(ModBlocks.CYBERFORMED_LOG);
            event.accept(ModBlocks.CYBERFORMED_WOOD);
            event.accept(ModBlocks.STRIPPED_CYBERFORMED_LOG);
            event.accept(ModBlocks.STRIPPED_CYBERFORMED_WOOD);
            event.accept(ModBlocks.CYBERFORMED_PLANKS);
            event.accept(ModBlocks.CYBERFORMED_SAPLING);
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
