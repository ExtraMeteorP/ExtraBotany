package com.meteor.extrabotany.common.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.item.IRelic;
import vazkii.botania.common.item.relic.ItemRelic;

import com.meteor.extrabotany.common.lib.LibItemName;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class EventPunish {
	
	@SubscribeEvent
	public void onPickedUp(ItemPickupEvent event) {
			ItemStack stack = event.pickedUp.getEntityItem();
			EntityPlayer player = event.player;
			String b = LibItemName.BINDING;
			if(stack.getItem() instanceof IRelic)
				if(((IRelic)stack.getItem()).getSoulbindUsername(stack).equals(b))
					player.attackEntityFrom(ItemRelic.damageSource(), 9999F);
	}
}
