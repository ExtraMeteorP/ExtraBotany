package com.meteor.extrabotany.common.item.equipment.shield;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.equipment.bauble.ItemBauble;
import baubles.api.BaubleType;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;

import com.meteor.extrabotany.common.lib.LibItemName;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemShieldGeneratorBase extends ItemBauble{

	private static final String TAG_CURRENTSHIELD = "currentShield";
	private static final String TAG_CD = "CD";
	
	public float getGenerateSpeed(){
		return 0;
	}
	
	public int getMaxShield(){
		return 0;
	}
	
	public int getCD(){
		return 0;
	}
	
	public int getManaCost(){
		return 0;
	}
	
	public static float getShieldAmount(EntityPlayer player){
		if(getShieldGenerator(player) != null){
			ItemStack sg = getShieldGenerator(player);
			return getCurrentShield(sg);
		}else
			return 0;
	}
	
	public static int getShieldCD(EntityPlayer player){
		if(getShieldGenerator(player) != null){
			ItemStack sg = getShieldGenerator(player);
			return getCD(sg);
		}else
			return 0;
	}
	
	public void recoverShield(EntityPlayer player, float f){
		if(getShieldGenerator(player) != null){
			ItemStack sg = getShieldGenerator(player);
			setCurrentShield(sg, Math.min(f+getCurrentShield(sg), getMaxShield()));
		}
	}
	
	public ItemShieldGeneratorBase(String name) {
		super(name);
		this.setMaxStackSize(1);
		setHasSubtypes(true);
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
		if(GuiScreen.isShiftKeyDown()) {
			addStringToTooltip(String.valueOf(getCurrentShield(stack)), list);
			addStringToTooltip(String.valueOf(getCD(stack)), list);
		}
	}
	
	static void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}
	
	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) entity;
			if(getCD(stack)>0){
				setCD(stack, getCD(stack)-1);
			}else{
				if(ManaItemHandler.requestManaExact(stack, player, Math.max(1, (int)(getManaCost()*getGenerateSpeed()*20)), true))
					recoverShield(player, getGenerateSpeed());	
			}
		}
	}
	
	public static ItemStack getShieldGenerator(EntityPlayer player) {
		InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);
		ItemStack stack1 = baubles.getStackInSlot(1);
		ItemStack stack2 = baubles.getStackInSlot(2);
		return isShieldGenerator(stack1) ? stack1 : isShieldGenerator(stack2) ? stack2 : null;
	}

	private static boolean isShieldGenerator(ItemStack stack) {
		return stack != null && stack.getItem() instanceof ItemShieldGeneratorBase;
	}
	
	@SubscribeEvent
	public void onPlayerAttacked(LivingHurtEvent event) {
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(getShieldGenerator(player) != null){
				ItemStack sg = getShieldGenerator(player);
				int dam = (int) (event.ammount);
				setCurrentShield(sg, Math.max(getCurrentShield(sg) - dam, 0 ));
				event.ammount = Math.max(event.ammount - getCurrentShield(sg), 0);
				setCD(sg, getCD());
			}
		}
	}
	
	public static float getCurrentShield(ItemStack stack){
		return ItemNBTHelper.getFloat(stack, TAG_CURRENTSHIELD, 0);
	}
	
	public static void setCurrentShield(ItemStack stack, float i){
		ItemNBTHelper.setFloat(stack, TAG_CURRENTSHIELD, i);
	}
	
	public static int getCD(ItemStack stack){
		return ItemNBTHelper.getInt(stack, TAG_CD, 0);
	}
	
	public static void setCD(ItemStack stack, int i){
		ItemNBTHelper.setInt(stack, TAG_CD, i);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.RING;
	}

}
