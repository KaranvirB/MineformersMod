package net.scaryscooter.tutorialmod.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.scaryscooter.tutorialmod.TutorialMod;

import static net.minecraft.tags.TagEntry.tag;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_PLANKS = tag("mod_planks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

//    public static class Items {
//        public static final TagKey<Block> MOD_PLANKS = tag("mod_planks");
//
//        private static TagKey<Block> tag(String name) {
//            return BlockTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
//        }
//        private static TagKey<Block> forgeTag(String name) {
//            return BlockTags.create(new ResourceLocation("forge", name));
//        }
//    }
}
