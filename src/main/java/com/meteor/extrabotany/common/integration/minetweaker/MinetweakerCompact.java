package com.meteor.extrabotany.common.integration.minetweaker;

import net.minecraft.item.ItemStack;
import minetweaker.MineTweakerAPI;
import stanhebben.zenscript.annotations.ZenClass;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;

@ZenClass("mods.ExtraBotany")
public class MinetweakerCompact {
	
	public static void init(){
		MineTweakerAPI.registerClass(MTInfernoidisy.class);	
		MineTweakerAPI.registerClass(MTStonesia.class);	
	}
	
	public static boolean isSubtile(ItemStack stack) {
        return stack.getItem() instanceof ItemBlockSpecialFlower;
    }

    public static boolean subtileMatches(ItemStack stack, ItemStack stack2) {
        return (ItemBlockSpecialFlower.getType(stack2).equals(ItemBlockSpecialFlower.getType(stack)));
    }

}
