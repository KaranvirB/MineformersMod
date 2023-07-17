package net.scaryscooter.mineformers.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_MODDED = "key.category.mineformers.modded";
    public static final String ADD_TOOL_KEY = "key.mineformers.add_tool_key";
    public static final String CHANGE_TOOL_KEY = "key.mineformers.change_tool_key";

    public static final KeyMapping ADD_TOOL = new KeyMapping(ADD_TOOL_KEY, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, InputConstants.KEY_V, KEY_CATEGORY_MODDED);
    public static final KeyMapping CHANGE_TOOL = new KeyMapping(CHANGE_TOOL_KEY, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, InputConstants.KEY_R, KEY_CATEGORY_MODDED);
}
