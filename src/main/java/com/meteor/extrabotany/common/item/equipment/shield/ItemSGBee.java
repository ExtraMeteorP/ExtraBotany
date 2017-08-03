package com.meteor.extrabotany.common.item.equipment.shield;

import com.meteor.extrabotany.common.lib.LibItemName;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemSGBee extends ItemShieldGeneratorBase{
	
	public ItemSGBee() {
		super(LibItemName.BAUBLESGBEE);
	}
	
	@SubscribeEvent
	public void onPlayerHurt(LivingHurtEvent event) {
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(getShieldGenerator(player) != null && getShieldGenerator(player).getItem() == this){
				ItemStack sg = getShieldGenerator(player);
				if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityLiving){
					EntityLiving el = (EntityLiving) event.source.getEntity();
					if(getCurrentShield(sg) > 8){
						recoverShield(player, -8);
						el.attackEntityFrom(DamageSource.causePlayerDamage(player), 8F);
					}
					if(getCurrentShield(sg) > 0 && getCurrentShield(sg) <= event.ammount)
						el.attackEntityFrom(DamageSource.causePlayerDamage(player), 20F);
				}
			}
		}
	}
	
	@Override
	public float getGenerateSpeed(){
		return 0.2F;
	}
	
	@Override
	public int getMaxShield(){
		return 220;
	}
	
	@Override
	public int getCD(){
		return 140;
	}
	
	@Override
	public int getManaCost(){
		return 2;
	}
	
}
