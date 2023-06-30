package net.scaryscooter.tutorialmod.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.tutorialmod.block.ModBlocks;
import net.scaryscooter.tutorialmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TRANSFORMIUM_BLOCK.get());
        dropSelf(ModBlocks.DARK_ENERGON_BLOCK.get());
        dropSelf(ModBlocks.ENERGON_BLOCK.get());
        dropSelf(ModBlocks.CYBERFORMED_LOG.get());

        add(ModBlocks.TRANSFORMIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.TRANSFORMIUM_ORE.get(), ModItems.RAW_TRANSFORMIUM.get()));
        add(ModBlocks.DEEPSLATE_TRANSFORMIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_TRANSFORMIUM_ORE.get(), ModItems.RAW_TRANSFORMIUM.get()));
        add(ModBlocks.UNSTABLE_TRANSFORMIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.UNSTABLE_TRANSFORMIUM_ORE.get(), ModItems.RAW_UNSTABLE_TRANSFORMIUM.get()));
        add(ModBlocks.DARK_ENERGON_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DARK_ENERGON_ORE.get(), ModItems.DARK_ENERGON_CRYSTAL.get()));
        add(ModBlocks.ENERGON_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENERGON_ORE.get(), ModItems.ENERGON_CUBE.get()));

        dropSelf(ModBlocks.CYBERFORMED_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_CYBERFORMED_LOG.get());
        dropSelf(ModBlocks.STRIPPED_CYBERFORMED_WOOD.get());
        dropSelf(ModBlocks.CYBERFORMED_PLANKS.get());
        dropSelf(ModBlocks.CYBERFORMED_SAPLING.get());

        add(ModBlocks.CYBERFORMED_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.CYBERFORMED_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
