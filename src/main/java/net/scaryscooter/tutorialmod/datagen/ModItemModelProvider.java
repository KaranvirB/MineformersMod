package net.scaryscooter.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.scaryscooter.tutorialmod.TutorialMod;
import net.scaryscooter.tutorialmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
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

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
