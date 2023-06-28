package net.scaryscooter.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
