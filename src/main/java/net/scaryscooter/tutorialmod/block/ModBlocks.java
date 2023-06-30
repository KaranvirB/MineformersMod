package net.scaryscooter.tutorialmod.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.tutorialmod.TutorialMod;
import net.scaryscooter.tutorialmod.block.custom.ModFlammableRotatedPillarBlock;
import net.scaryscooter.tutorialmod.item.ModItems;
import net.scaryscooter.tutorialmod.worldgen.tree.CyberformedTreeGrower;

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

    public static final RegistryObject<Block> CYBERFORMED_LOG = registerBlock("cyberformed_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STRIPPED_CYBERFORMED_LOG = registerBlock("stripped_cyberformed_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CYBERFORMED_WOOD = registerBlock("cyberformed_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STRIPPED_CYBERFORMED_WOOD = registerBlock("stripped_cyberformed_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CYBERFORMED_PLANKS = registerBlock("cyberformed_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(5f).requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> CYBERFORMED_LEAVES = registerBlock("cyberformed_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(5f).requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });
    public static final RegistryObject<Block> CYBERFORMED_SAPLING = registerBlock("cyberformed_sapling",
            () -> new SaplingBlock(new CyberformedTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


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
