package com.meteor.extrabotany.common.core.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.meteor.extrabotany.common.CommonProxy;

public class PropertyHandler implements IExtendedEntityProperties{
	
	private static EntityPlayer player;
	
	public static void setPlayer(EntityPlayer p){
		player = p;
	}

	public static void setShieldAmount(float shield, EntityPlayer p) {
		setPlayer(p);
		player.getDataWatcher().updateObject(30, (int)(Math.min(shield, getMaxShieldAmount(player)))); 
	}

	public static float getShieldAmount(EntityPlayer p) {
		setPlayer(p);
		return player.getDataWatcher().getWatchableObjectInt(30);
	}

	public static void addShieldAmount(float shield, EntityPlayer p) {
		setPlayer(p);
		player.getDataWatcher().updateObject(30, (int)(Math.min(getShieldAmount(player) + shield, getMaxShieldAmount(player))));
	}

	public static float getMaxShieldAmount(EntityPlayer p) {
		setPlayer(p);
		player.getDataWatcher().updateObject(29, (int)(player.getMaxHealth() + ConfigHandler.extraShieldAmount));
		return player.getDataWatcher().getWatchableObjectInt(29);
	}

	public final static String EXT_PROP_NAME = "Shield";
	public final static String TAG_CURRENT_SHIELD = "CurrentShield";
	public final static String TAG_MAX_SHIELD = "MaxShield";
	public static float currentShield;
	public static float maxShield;

	public PropertyHandler(EntityPlayer player)
	{	
		this.player = player;
		player.getDataWatcher().addObject(29, 0);
		player.getDataWatcher().addObject(30, 0);
		this.currentShield = 0;
		this.maxShield = 20;
	}

	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(PropertyHandler.EXT_PROP_NAME, new PropertyHandler(player));
	}
	
	public static final PropertyHandler get(EntityPlayer player)
	{
		return (PropertyHandler) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger(this.TAG_CURRENT_SHIELD, (int)(getShieldAmount(this.player)));
		properties.setInteger(this.TAG_MAX_SHIELD, (int)(getMaxShieldAmount(this.player)));
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.player.getDataWatcher().updateObject(30, properties.getInteger(this.TAG_CURRENT_SHIELD));
		this.player.getDataWatcher().updateObject(29, properties.getInteger(this.TAG_MAX_SHIELD));
	}

	@Override
	public void init(Entity entity, World world)
	{
		
	}
	
	private static String getSaveKey(EntityPlayer player) {
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}

}
