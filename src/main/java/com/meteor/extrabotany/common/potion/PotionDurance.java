package com.meteor.extrabotany.common.potion;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;

import com.meteor.extrabotany.common.core.handler.ConfigHandler;
import com.meteor.extrabotany.common.lib.LibPotionEffectName;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PotionDurance extends PotionMods{

	public PotionDurance() {
		super(ConfigHandler.idPotionD, LibPotionEffectName.DURANCE, false, 0x9C64A6, 3);
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
	
	@SubscribeEvent
	public void LivingEvent(LivingEvent.LivingUpdateEvent event) { 
		if(event.entityLiving.isPotionActive(ModPotions.durance)){
			event.entityLiving.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0);;
		}
	}

}
