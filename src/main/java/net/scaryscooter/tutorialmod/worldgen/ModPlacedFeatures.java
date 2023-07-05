package net.scaryscooter.tutorialmod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.scaryscooter.tutorialmod.TutorialMod;
import net.scaryscooter.tutorialmod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CYBERFORMED_PLACED_KEY = createKey("cyberformed_placed");

    public static final ResourceKey<PlacedFeature> TRANSFORMIUM_PLACED_KEY = createKey("transformium_placed");
    public static final ResourceKey<PlacedFeature> UNSTABLE_TRANSFORMIUM_PLACED_KEY = createKey("unstable_transformium_placed");
    public static final ResourceKey<PlacedFeature> DARK_ENERGON_PLACED_KEY = createKey("dark_energon_placed");
    public static final ResourceKey<PlacedFeature> ENERGON_PLACED_KEY = createKey("energon_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CYBERFORMED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CYBERFORMED_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 01, 2), ModBlocks.CYBERFORMED_SAPLING.get()));

        register(context, TRANSFORMIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TRANSFORMIUM_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(20))));
        register(context, UNSTABLE_TRANSFORMIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNSTABLE_TRANSFORMIUM_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(80))));
        register(context, DARK_ENERGON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DARK_ENERGON_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(80))));
        register(context, ENERGON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENERGON_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(150))));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TutorialMod.MOD_ID, name));
    }
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
