package com.meteor.extrabotany.common.item;

import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.util.TupleIntJsonSerializable;
import net.minecraft.world.World;
import vazkii.botania.common.block.mana.BlockPool;
import vazkii.botania.common.block.tile.mana.TilePool;
import vazkii.botania.common.core.helper.ItemNBTHelper;

import com.google.common.collect.Maps;
import com.meteor.extrabotany.common.achievement.ModAchievement;
import com.meteor.extrabotany.common.block.subtile.functional.SubTileAnnoyobloom;

public class ItemManaReader extends ItemMods{
	
	private static final String COUNT = "useCount";

	public ItemManaReader(String name) {
		super(name);
		setMaxStackSize(1);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
		addStringToTooltip(StatCollector.translateToLocal("botaniamisc.usecount").replaceAll("%s%", String.valueOf(getCount(stack))), list);
	}
	
	static void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		Block block = par3World.getBlock(par4, par5, par6);
		if(block instanceof BlockPool){
			TileEntity e = par3World.getTileEntity(par4, par5, par6);
			if(e instanceof TilePool){
				TilePool p = (TilePool) e;
				int cap = p.manaCap;
				int mana = p.getCurrentMana();
				if(!par3World.isRemote){
					player.addChatComponentMessage(new ChatComponentTranslation(StatCollector.translateToLocal("botaniamisc.manaDisplay") +":" + mana + "/" + cap));
					setCount(stack, getCount(stack) + 1);
				}
				thousandUse(player, getCount(stack));
			}
		}
		return true;	
	}
	
	public void thousandUse(EntityPlayer player, int count){
		if(count == 1000){
			player.inventory.addItemStackToInventory(new ItemStack(ModItems.material, 1, 4+player.worldObj.rand.nextInt(3)));
			player.addStat(ModAchievement.thousandUse, 1);
			if(!player.worldObj.isRemote){
				player.addChatMessage(new ChatComponentTranslation("botaniamisc.thousandUse").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN)));
				for(int i = 0;i < 6; i++){
					player.worldObj.spawnEntityInWorld(SubTileAnnoyobloom.getRandomFirework(player.worldObj, (float)(player.posX + i/5 - 0.6F), (float)(player.posY + i/3), (float)(player.posZ + i/5 - 0.6F)));
				}
			}
		}
	}
	
	public int getCount(ItemStack stack){
		return ItemNBTHelper.getInt(stack, COUNT, 0);
	}
	
	public void setCount(ItemStack stack, int i){
		ItemNBTHelper.setInt(stack, COUNT, i);
	}

}
