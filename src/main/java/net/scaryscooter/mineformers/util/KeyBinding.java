package net.scaryscooter.mineformers.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_MODDED = "key.category.mineformers.modded";
    public static final String KEY_TEST = "key.mineformers.test";

    public static final KeyMapping TESTING_KEY = new KeyMapping(KEY_TEST, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, InputConstants.KEY_C, KEY_CATEGORY_MODDED);
}
