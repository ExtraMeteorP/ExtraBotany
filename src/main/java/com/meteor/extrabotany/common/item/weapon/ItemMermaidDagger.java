package com.meteor.extrabotany.common.item.weapon;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.common.item.ModItems;
import com.meteor.extrabotany.common.lib.LibReference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.DamageSource;

public class ItemMermaidDagger extends ItemSword{

	public ItemMermaidDagger(ToolMaterial p_i45356_1_, String name) {
		super(p_i45356_1_);
		this
		.setUnlocalizedName(name)
		.setCreativeTab(ExtraBotany.tabExtraBotany)
		.setMaxStackSize(1)
		.setTextureName(LibReference.MOD_ID + ":" + name);
		GameRegistry.registerItem(this, name);	
	}
	
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player){
		if(target instanceof EntityVillager || (target instanceof EntityPlayer && ((EntityPlayer)target).getDisplayName() == "Prince")){
			target.entityDropItem(new ItemStack(ModItems.material, 1, 10), 1F);
			target.setDead();
		}
		return target.attackEntityFrom(DamageSource.generic, 10F);
	}

}
