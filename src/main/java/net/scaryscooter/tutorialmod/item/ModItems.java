package net.scaryscooter.tutorialmod.item;

import net.minecraft.world.item.*;
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
    public static final RegistryObject<Item> DARK_ENERGON_CRYSTAL = ITEMS.register("dark_energon_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERGON_CUBE = ITEMS.register("energon_cube",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_UNSTABLE_TRANSFORMIUM = ITEMS.register("raw_unstable_transformium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNSTABLE_TRANSFORMIUM = ITEMS.register("unstable_transformium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TRANSFORMIUM_CORE = ITEMS.register("transformium_core",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERGIZED_TRANSFORMIUM_CORE = ITEMS.register("energized_transformium_core",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TRANSFORMIUM_SWORD = ITEMS.register("transformium_sword",
            () -> new SwordItem(Tiers.DIAMOND, 11, 5f, new Item.Properties()));
    public static final RegistryObject<Item> SQUIRREL = ITEMS.register("squirrel",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
