package net.scaryscooter.tutorialmod.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.tutorialmod.TutorialMod;
import net.scaryscooter.tutorialmod.block.ModBlocks;
import net.scaryscooter.tutorialmod.item.ModItems;
import net.scaryscooter.tutorialmod.util.ModTags;

import javax.annotation.Nullable;
import javax.swing.*;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(ModItems.RAW_TRANSFORMIUM.get()), RecipeCategory.MISC,
                ModItems.TRANSFORMIUM.get(), 1, 200, "transformium");
        oreBlasting(consumer, List.of(ModItems.RAW_TRANSFORMIUM.get()), RecipeCategory.MISC,
                ModItems.TRANSFORMIUM.get(), 1, 100, "transformium");
        oreSmelting(consumer, List.of(ModItems.RAW_UNSTABLE_TRANSFORMIUM.get()), RecipeCategory.MISC,
                ModItems.UNSTABLE_TRANSFORMIUM.get(), 1, 200, "unstable_transformium");
        oreBlasting(consumer, List.of(ModItems.RAW_UNSTABLE_TRANSFORMIUM.get()), RecipeCategory.MISC,
                ModItems.UNSTABLE_TRANSFORMIUM.get(), 1, 100, "unstable_transformium");

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.TRANSFORMIUM.get(),
                RecipeCategory.MISC, ModBlocks.TRANSFORMIUM_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.ENERGON_CUBE.get(),
                RecipeCategory.MISC, ModBlocks.ENERGON_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_ENERGON_CRYSTAL.get(),
                RecipeCategory.MISC, ModBlocks.DARK_ENERGON_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSFORMIUM_CORE.get())
                .define('#', ModBlocks.TRANSFORMIUM_BLOCK.get())
                .define('Q', ModItems.UNSTABLE_TRANSFORMIUM.get())
                .pattern(" # ")
                .pattern("#Q#")
                .pattern(" # ")
                .unlockedBy("has_unstable_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.UNSTABLE_TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENERGIZED_TRANSFORMIUM_CORE.get())
                .define('#', ModBlocks.ENERGON_BLOCK.get())
                .define('Q', ModItems.TRANSFORMIUM_CORE.get())
                .pattern("###")
                .pattern("#Q#")
                .pattern("###")
                .unlockedBy("has_transformium_core", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM_CORE.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSFORMIUM_PICKAXE.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .define('Q', Items.STICK)
                .pattern("###")
                .pattern(" Q ")
                .pattern(" Q ")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSFORMIUM_SWORD.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .define('Q', Items.STICK)
                .pattern("#")
                .pattern("#")
                .pattern("Q")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSFORMIUM_AXE.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .define('Q', Items.STICK)
                .pattern("##")
                .pattern("#Q")
                .pattern(" Q")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSFORMIUM_SHOVEL.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .define('Q', Items.STICK)
                .pattern("#")
                .pattern("Q")
                .pattern("Q")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSFORMIUM_HOE.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .define('Q', Items.STICK)
                .pattern("##")
                .pattern(" Q")
                .pattern(" Q")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
//                .define('#', Ingredient.of())
//                .pattern("#")
//                .pattern("#")
//                .unlockedBy("has_cyberformed_planks", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.CYBERFORMED_PLANKS.get()).build()))
//                .save(consumer);

        stickRecipe(consumer, RecipeCategory.MISC, Items.STICK, ModBlocks.CYBERFORMED_PLANKS.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CYBERFORMED_PLANKS.get(), 4)
                .requires(ModBlocks.CYBERFORMED_LOG.get())
                .unlockedBy("has_cyberformed_log", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CYBERFORMED_LOG.get()).build()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TRANSFORMIUM_HELMET.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TRANSFORMIUM_CHESTPLATE.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TRANSFORMIUM_LEGGINGS.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TRANSFORMIUM_BOOTS.get())
                .define('#', ModItems.TRANSFORMIUM.get())
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TRANSFORMIUM.get()).build()))
                .save(consumer);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TRANSFORMIUM.get())
//                .requires(ModBlocks.TRANSFORMIUM_BLOCK.get())
//                .unlockedBy("has_transformium_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.TRANSFORMIUM_BLOCK.get()).build()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRANSFORMIUM_BLOCK.get())
//                .define('#', ModItems.TRANSFORMIUM.get())
//                .pattern("###")
//                .pattern("###")
//                .pattern("###")
//                .unlockedBy("has_transformium", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModItems.TRANSFORMIUM.get()).build()))
//                .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(TutorialMod.MOD_ID, getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }

    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
                                                  RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
                                                  String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(TutorialMod.MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(TutorialMod.MOD_ID, p_250475_));
    }

    protected static void stickRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory recipeCategory, ItemLike itemLike, ItemLike plankLike) {
        stickRecipe(consumer, recipeCategory, itemLike, plankLike, (String)null);
    }
    protected static void stickRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike itemLike, ItemLike plankLike, @Nullable String groupLike) {
        ShapedRecipeBuilder.shaped(category, itemLike)
                .define('#', plankLike)
                .pattern("#")
                .pattern("#")
                .group(groupLike).unlockedBy(getHasName(plankLike),
                has(plankLike)).save(consumer, new ResourceLocation(TutorialMod.MOD_ID, getItemName(plankLike)) + "_stick");
    }
    protected static String getHasName(ItemLike itemLike) {
        return "has_" + getItemName(itemLike);
    }

    protected static String getItemName(ItemLike name) {
        return BuiltInRegistries.ITEM.getKey(name.asItem()).getPath();
    }
}
