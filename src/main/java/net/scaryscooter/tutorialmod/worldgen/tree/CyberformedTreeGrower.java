package net.scaryscooter.tutorialmod.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.scaryscooter.tutorialmod.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class CyberformedTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return ModConfiguredFeatures.CYBERFORMED_KEY;
    }
}
