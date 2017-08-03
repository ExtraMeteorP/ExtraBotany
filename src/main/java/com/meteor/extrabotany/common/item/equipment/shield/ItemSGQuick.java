package com.meteor.extrabotany.common.item.equipment.shield;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.meteor.extrabotany.common.core.handler.EntityHandler;
import com.meteor.extrabotany.common.lib.LibItemName;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemSGQuick extends ItemShieldGeneratorBase{
	
	public ItemSGQuick() {
		super(LibItemName.BAUBLESGQUICK);
	}
	
	@SubscribeEvent
	public void onPlayerHurt(LivingHurtEvent event) {
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(getShieldGenerator(player) != null && getShieldGenerator(player).getItem() == this){
				ItemStack sg = getShieldGenerator(player);
				if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityLiving){
					EntityLiving el = (EntityLiving) event.source.getEntity();
					EntityHandler.knockBack(el, player, 2F, 2F);
				}
			}
		}
	}
	
	@Override
	public float getGenerateSpeed(){
		return 0.6F;
	}
	
	@Override
	public int getMaxShield(){
		return 60;
	}
	
	@Override
	public int getCD(){
		return 70;
	}
	
	@Override
	public int getManaCost(){
		return 5;
	}
}
