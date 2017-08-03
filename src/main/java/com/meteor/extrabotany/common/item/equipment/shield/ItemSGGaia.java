package com.meteor.extrabotany.common.item.equipment.shield;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.meteor.extrabotany.common.lib.LibItemName;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemSGGaia extends ItemShieldGeneratorBase{
	
	public ItemSGGaia() {
		super(LibItemName.BAUBLESGGAIA);
	}
	
	@SubscribeEvent
	public void onPlayerHurt(LivingHurtEvent event) {
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(getShieldGenerator(player) != null && getShieldGenerator(player).getItem() == this){
				ItemStack sg = getShieldGenerator(player);
				
			}
		}
	}
	
	@Override
	public float getGenerateSpeed(){
		return 0.22F;
	}
	
	@Override
	public int getMaxShield(){
		return 220;
	}
	
	@Override
	public int getCD(){
		return 180;
	}
	
	@Override
	public int getManaCost(){
		return 3;
	}
}
