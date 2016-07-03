package com.meteor.extrabotany.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.meteor.extrabotany.common.lib.LibReference;
import com.meteor.extrabotany.common.potion.ModPotions;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemPill extends ItemFood{

	public ItemPill(String name) {
		super(0,0,false);
		this.setUnlocalizedName(name)
		.setTextureName(LibReference.MOD_ID + ":" + name);
		GameRegistry.registerItem(this, name);
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
    {
		if(!player.worldObj.isRemote)
			player.addPotionEffect(new PotionEffect(ModPotions.cure.getId(), 200, 0));
        	player.setHealth(player.getMaxHealth());
    }
	
}
