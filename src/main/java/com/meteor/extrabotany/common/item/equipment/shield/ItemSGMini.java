package com.meteor.extrabotany.common.item.equipment.shield;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.meteor.extrabotany.common.lib.LibItemName;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemSGMini extends ItemShieldGeneratorBase{
	
	public ItemSGMini() {
		super(LibItemName.BAUBLESGMINI);
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerHurt(LivingHurtEvent event) {
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(getShieldGenerator(player) != null && getShieldGenerator(player).getItem() == this){
				ItemStack sg = getShieldGenerator(player);
				if(event.ammount>10F){
					setCurrentShield(sg, 0);
				}
			}
		}
	}
	
	@Override
	public float getGenerateSpeed(){
		return 0.15F;
	}
	
	@Override
	public int getMaxShield(){
		return 100;
	}
	
	@Override
	public int getCD(){
		return 100;
	}
	
	@Override
	public int getManaCost(){
		return 1;
	}
}
