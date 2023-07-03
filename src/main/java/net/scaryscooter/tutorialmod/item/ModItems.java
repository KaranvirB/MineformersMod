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
            () -> new SwordItem(Tiers.DIAMOND, 9, 5f, new Item.Properties().durability(2000)));
    public static final RegistryObject<Item> TRANSFORMIUM_PICKAXE = ITEMS.register("transformium_pickaxe",
            () -> new PickaxeItem(Tiers.NETHERITE, 7, 5f, new Item.Properties().durability(2000)));
    public static final RegistryObject<Item> TRANSFORMIUM_AXE = ITEMS.register("transformium_axe",
            () -> new AxeItem(Tiers.NETHERITE, 10, 5f, new Item.Properties().durability(2000)));
    public static final RegistryObject<Item> TRANSFORMIUM_SHOVEL = ITEMS.register("transformium_shovel",
            () -> new ShovelItem(Tiers.NETHERITE, 6, 5f, new Item.Properties().durability(2000)));
    public static final RegistryObject<Item> TRANSFORMIUM_HOE = ITEMS.register("transformium_hoe",
            () -> new HoeItem(Tiers.NETHERITE, 8, 5f, new Item.Properties().durability(2000)));
    public static final RegistryObject<Item> SQUIRREL = ITEMS.register("squirrel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRANSFORMIUM_HELMET = ITEMS.register("transformium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TRANSFORMIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TRANSFORMIUM_CHESTPLATE = ITEMS.register("transformium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TRANSFORMIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TRANSFORMIUM_LEGGINGS = ITEMS.register("transformium_leggings",
            () -> new ArmorItem(ModArmorMaterials.TRANSFORMIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TRANSFORMIUM_BOOTS = ITEMS.register("transformium_boots",
            () -> new ArmorItem(ModArmorMaterials.TRANSFORMIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
