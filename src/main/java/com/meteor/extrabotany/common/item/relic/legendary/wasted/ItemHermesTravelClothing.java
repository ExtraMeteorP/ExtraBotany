package com.meteor.extrabotany.common.item.relic.legendary.wasted;
/*
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.item.relic.ItemRelic;

import com.meteor.extrabotany.common.item.relic.legendary.ItemRelicArmorSet;
import com.meteor.extrabotany.common.lib.LibItemName;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemHermesTravelClothing extends ItemRelicArmorSet implements IManaUsingItem{
	public ItemHermesTravelClothing(int type, String name) {
		super(1, LibItemName.HERMESTRAVELCLOTHING);
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
	
	public static boolean hasHermesTravelClothing(EntityPlayer player){
		boolean bool = false;
		for(ItemStack stack : player.inventory.armorInventory) {
            if(stack != null && stack.getItem() instanceof ItemHermesTravelClothing) {
            	if(ItemRelic.isRightPlayer(player, stack)){
            		bool = true;
            		}else bool = false;
            	}	
		}
		return bool;
	}
	
	@SubscribeEvent
	 public void PlayerHurtEvent(LivingHurtEvent event) { 
	        if(!(event.entity instanceof EntityPlayerMP)) {
	            return;
	        }
	        EntityPlayer player = (EntityPlayer) event.entity;
	        for(ItemStack stack : player.inventory.armorInventory) {
	            if(stack != null && stack.getItem() instanceof ItemHermesTravelClothing) {
	            	if(ItemRelic.isRightPlayer(player, stack)){
	            	int rand = new Random().nextInt(3);
	            	if(rand == 2 && ManaItemHandler.requestManaExact(stack, player, 100, true)){
	            		event.setCanceled(true);
	            		}
	            	}
	            }
	        }
	 }
	
	@Override
	public boolean usesMana(ItemStack stack) {
		return true;
	}

}
*/
