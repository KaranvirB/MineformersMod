package net.scaryscooter.tutorialmod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.common.Mod;
import net.scaryscooter.tutorialmod.TutorialMod;
import net.scaryscooter.tutorialmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYBERFORMED_KEY = registerKey("cyberformed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TRANSFORMIUM_KEY = registerKey("transformium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNSTABLE_TRANSFORMIUM_KEY = registerKey("unstable_transformium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_ENERGON_KEY = registerKey("dark_energon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENERGON_KEY = registerKey("energon_ore");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest stoneReplaceablesEnergon = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldTransformiumOres = List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.TRANSFORMIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TRANSFORMIUM_ORE.get().defaultBlockState()));

        register(context, CYBERFORMED_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CYBERFORMED_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(ModBlocks.CYBERFORMED_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, TRANSFORMIUM_KEY, Feature.ORE, new OreConfiguration(overworldTransformiumOres, 6));
        register(context, UNSTABLE_TRANSFORMIUM_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.UNSTABLE_TRANSFORMIUM_ORE.get().defaultBlockState(), 20));
        register(context, DARK_ENERGON_KEY, Feature.ORE, new OreConfiguration(endstoneReplaceables, ModBlocks.DARK_ENERGON_ORE.get().defaultBlockState(), 30, 0.5F));
        register(context, ENERGON_KEY, Feature.ORE, new OreConfiguration(stoneReplaceablesEnergon, ModBlocks.ENERGON_ORE.get().defaultBlockState(), 12));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                         ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
