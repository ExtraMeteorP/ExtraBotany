package com.meteor.extrabotany.common.item;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class ItemDungeonBox extends ItemMods{
	
	Random rand = new Random();
	
	public ItemDungeonBox(String name) {
		super(name);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		ItemStack s = ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, player.worldObj.rand);
		if(!player.worldObj.isRemote){
			if(player.inventory.hasItem(ModItems.key)){	
				player.inventory.consumeInventoryItem(ModItems.key);
				int a = player.worldObj.rand.nextInt(2) + 1;
				do{
					ItemStack s1 = ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, player.worldObj.rand);
					player.inventory.addItemStackToInventory(s1);
					a--;
				} while(a != 0);
				
				return s.copy();
				
			}else if(!player.inventory.hasItem(ModItems.key)){
				player.addChatMessage(new ChatComponentTranslation("botaniamisc.openChest").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN)));
			}
		}
		return stack;
	}
}
