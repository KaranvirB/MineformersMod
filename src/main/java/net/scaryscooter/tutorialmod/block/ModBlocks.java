package net.scaryscooter.tutorialmod.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.tutorialmod.TutorialMod;
import net.scaryscooter.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> TRANSFORMIUM_BLOCK = registerBlock("transformium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> DARK_ENERGON_BLOCK = registerBlock("dark_energon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> ENERGON_BLOCK = registerBlock("energon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> TRANSFORMIUM_ORE = registerBlock("transformium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> DEEPSLATE_TRANSFORMIUM_ORE = registerBlock("deepslate_transformium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> UNSTABLE_TRANSFORMIUM_ORE = registerBlock("unstable_transformium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> DARK_ENERGON_ORE = registerBlock("dark_energon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> ENERGON_ORE = registerBlock("energon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
