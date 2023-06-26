package net.scaryscooter.tutorialmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.tutorialmod.TutorialMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> TRANSFORMIUM = ITEMS.register("transformium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TRANSFORMIUM = ITEMS.register("raw_transformium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SQUIRREL = ITEMS.register("squirrel",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
