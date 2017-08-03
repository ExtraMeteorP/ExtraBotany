package com.meteor.extrabotany.common.core.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class EnchHelper {
	
	public static int getEnchLevel(Enchantment e, ItemStack stack){
		return EnchantmentHelper.getEnchantmentLevel(e.effectId, stack);
	}
	
	public static void setEnch(Enchantment e, int l, ItemStack stack){
		stack.addEnchantment(e, l);
	}

}
