package com.meteor.extrabotany.common.enchantment;

import vazkii.botania.api.item.IRelic;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.meteor.extrabotany.common.core.handler.ConfigHandler;

public class EnchDivineMark extends Enchantment{

	public EnchDivineMark() {
		super(ConfigHandler.enchDivineMark, 2, EnumHelper.addEnchantmentType("relic"));
		this.setName("divinemark");
	}
	
	@Override
    public int getMaxLevel(){
        return 3;
    }
	
	@Override
	public boolean canApply(ItemStack stack){
        return stack.getItem() instanceof IRelic;
    }
}
