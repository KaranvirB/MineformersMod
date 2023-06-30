package net.scaryscooter.tutorialmod.datagen;

import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.tutorialmod.TutorialMod;
import net.scaryscooter.tutorialmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TRANSFORMIUM_BLOCK);
        blockWithItem(ModBlocks.TRANSFORMIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TRANSFORMIUM_ORE);
        blockWithItem(ModBlocks.UNSTABLE_TRANSFORMIUM_ORE);
        blockWithItem(ModBlocks.ENERGON_BLOCK);
        blockWithItem(ModBlocks.ENERGON_ORE);
        blockWithItem(ModBlocks.DARK_ENERGON_BLOCK);
        blockWithItem(ModBlocks.DARK_ENERGON_ORE);

        logBlock((RotatedPillarBlock) ModBlocks.CYBERFORMED_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.CYBERFORMED_WOOD.get(), blockTexture(ModBlocks.CYBERFORMED_LOG.get()), blockTexture(ModBlocks.CYBERFORMED_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CYBERFORMED_LOG.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_cyberformed_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_cyberformed_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CYBERFORMED_WOOD.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_cyberformed_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_cyberformed_log"));

        blockWithItem(ModBlocks.CYBERFORMED_PLANKS);
        blockWithItem(ModBlocks.CYBERFORMED_LEAVES);
        saplingBlock(ModBlocks.CYBERFORMED_SAPLING);

        simpleBlockItem(ModBlocks.CYBERFORMED_LOG.get(), models().withExistingParent("tutorialmod:cyberformed_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.CYBERFORMED_WOOD.get(), models().withExistingParent("tutorialmod:cyberformed_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_CYBERFORMED_LOG.get(), models().withExistingParent("tutorialmod:stripped_cyberformed_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_CYBERFORMED_WOOD.get(), models().withExistingParent("tutorialmod:stripped_cyberformed_wood", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
