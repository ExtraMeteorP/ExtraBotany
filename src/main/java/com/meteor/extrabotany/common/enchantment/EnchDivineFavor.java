package com.meteor.extrabotany.common.enchantment;

import vazkii.botania.api.item.IRelic;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.meteor.extrabotany.common.core.handler.ConfigHandler;

public class EnchDivineFavor extends Enchantment{

	public EnchDivineFavor() {
		super(ConfigHandler.enchDivineFavor, 2, EnumHelper.addEnchantmentType("relic"));
		this.setName("divinefavor");
	}
	
	@Override
    public int getMaxLevel(){
        return 5;
    }
	
	@Override
	public boolean canApply(ItemStack stack){
        return stack.getItem() instanceof IRelic;
    }

}
