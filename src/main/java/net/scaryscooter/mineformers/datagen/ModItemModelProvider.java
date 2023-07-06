package net.scaryscooter.mineformers.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.mineformers.Mineformers;
import net.scaryscooter.mineformers.block.ModBlocks;
import net.scaryscooter.mineformers.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Mineformers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_TRANSFORMIUM);
        simpleItem(ModItems.TRANSFORMIUM);
        simpleItem(ModItems.RAW_UNSTABLE_TRANSFORMIUM);
        simpleItem(ModItems.UNSTABLE_TRANSFORMIUM);
        simpleItem(ModItems.DARK_ENERGON_CRYSTAL);
        simpleItem(ModItems.ENERGON_CUBE);
        simpleItem(ModItems.TRANSFORMIUM_CORE);
        simpleItem(ModItems.ENERGIZED_TRANSFORMIUM_CORE);

        handheldItem(ModItems.TRANSFORMIUM_SWORD);
        handheldItem(ModItems.TRANSFORMIUM_PICKAXE);
        handheldItem(ModItems.TRANSFORMIUM_AXE);
        handheldItem(ModItems.TRANSFORMIUM_SHOVEL);
        handheldItem(ModItems.TRANSFORMIUM_HOE);

        saplingItem(ModBlocks.CYBERFORMED_SAPLING);

        simpleItem(ModItems.TRANSFORMIUM_HELMET);
        simpleItem(ModItems.TRANSFORMIUM_CHESTPLATE);
        simpleItem(ModItems.TRANSFORMIUM_LEGGINGS);
        simpleItem(ModItems.TRANSFORMIUM_BOOTS);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Mineformers.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Mineformers.MOD_ID, "block/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Mineformers.MOD_ID, "item/" + item.getId().getPath()));
    }
}
