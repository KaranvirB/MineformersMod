package net.scaryscooter.tutorialmod.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
                (block) -> createModOreDrops(ModBlocks.TRANSFORMIUM_ORE.get(), ModItems.RAW_TRANSFORMIUM.get(), 1.0F, 1.0F));
        add(ModBlocks.DEEPSLATE_TRANSFORMIUM_ORE.get(),
                (block) -> createModOreDrops(ModBlocks.DEEPSLATE_TRANSFORMIUM_ORE.get(), ModItems.RAW_TRANSFORMIUM.get(), 1.0F, 1.0F));
        add(ModBlocks.UNSTABLE_TRANSFORMIUM_ORE.get(),
                (block) -> createModOreDrops(ModBlocks.UNSTABLE_TRANSFORMIUM_ORE.get(), ModItems.RAW_UNSTABLE_TRANSFORMIUM.get(), 1.0F, 1.0F));
        add(ModBlocks.DARK_ENERGON_ORE.get(),
                (block) -> createModOreDrops(ModBlocks.DARK_ENERGON_ORE.get(), ModItems.DARK_ENERGON_CRYSTAL.get(), 2.0F, 4.0F));
        add(ModBlocks.ENERGON_ORE.get(),
                (block) -> createModOreDrops(ModBlocks.ENERGON_ORE.get(), ModItems.ENERGON_CUBE.get(), 3.0F, 6.0F));

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
    protected LootTable.Builder createModOreDrops(Block block, ItemLike item, float low, float high) {
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(low, high))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
