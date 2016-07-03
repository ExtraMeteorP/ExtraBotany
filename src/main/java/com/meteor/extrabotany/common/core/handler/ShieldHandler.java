package com.meteor.extrabotany.common.core.handler;

import com.meteor.extrabotany.common.core.network.DataReader;
import com.meteor.extrabotany.common.core.network.DataWriter;
import com.meteor.extrabotany.common.core.network.NetworkHandler;
import com.meteor.extrabotany.common.core.network.PacketID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ShieldHandler implements IExtendedEntityProperties{
	
	public static final String identifier = "Shield";
	
	private Entity entity;
	public static String SHIELD = "shield";
	public static String SHIELD_CURRENT = "currentShield";
	public static String SHIELD_MAX = "maxShield";
	
	private float currentShield = 0F;
	private float maxShield = 20F;
	
	private boolean hasDoneFullSync = false;

	private boolean hasUpdate = false;

	private boolean forcingSync = false;
	private int ticksToSync = 0;
	private final int syncTickDelay = 100;
	
	public ShieldHandler(){
		setupDefaults();
	}
	
	private void setupDefaults(){
		currentShield = 0F;
		maxShield = 20F + ConfigHandler.extraShieldAmount;
	}
	
	public static ShieldHandler For(EntityLivingBase living){
		return (ShieldHandler)living.getExtendedProperties(identifier);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound tags = new NBTTagCompound();
		compound.setTag(SHIELD, tags);
		compound.setFloat(SHIELD_CURRENT, currentShield);
		compound.setFloat(SHIELD_MAX, maxShield);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound tags = compound.getCompoundTag(SHIELD);
		currentShield = compound.getFloat(SHIELD_CURRENT);
		maxShield = compound.getFloat(SHIELD_MAX);
	}

	@Override
	public void init(Entity entity, World world) {
		this.entity = entity;
	}
	
	public boolean HasDoneFullSync(){
		return this.hasDoneFullSync;
	}

	public void setFullSync(){
		this.ticksToSync = 0;
		this.hasUpdate = true;
		this.hasDoneFullSync = true;
		this.forcingSync = true;
	}

	public void setDelayedSync(int delay){
		setFullSync();
		this.ticksToSync = delay;
	}

	public void forceSync(){
		this.forcingSync = true;
		this.ticksToSync = 0;
	}

	public boolean hasUpdate(){
		if (!(this.entity instanceof EntityPlayer) && !forcingSync){
			return false;
		}
		this.ticksToSync--;
		if (this.ticksToSync <= 0) this.ticksToSync = this.syncTickDelay;
		return this.hasUpdate && this.ticksToSync == this.syncTickDelay;
	}

	private byte[] getUpdateData(){
		DataWriter writer = new DataWriter();
		writer.add(this.entity.getEntityId());
		
		writer.add(currentShield);
		writer.add(maxShield);

		this.hasUpdate = false;
		this.forcingSync = false;
		
		return writer.generate();
	}
	
	public boolean handlePacketData(byte[] data){
		DataReader rdr = new DataReader(data, false);
		
		int entID = rdr.getInt();

		if (entID != this.entity.getEntityId()){
			return false;
		}
		
		currentShield = rdr.getFloat();
		maxShield = rdr.getFloat();
		
		return true;	
	}
	
	public void handleExtendedPropertySync(){
		if (!this.HasDoneFullSync()) this.setFullSync();

		if (!entity.worldObj.isRemote && this.hasUpdate()){
			byte[] data = this.getUpdateData();
			NetworkHandler.INSTANCE.sendPacketToAllClientsNear(entity.worldObj.provider.dimensionId, entity.posX, entity.posY, entity.posZ, 32, PacketID.SHIELD, data);
		}
	}
	
	public void setShieldAmount(float shield, EntityPlayer p) {
		this.currentShield = Math.min(shield, maxShield);
	}

	public float getShieldAmount(EntityPlayer p) {
		return this.currentShield;
	}

	public void addShieldAmount(float shield, EntityPlayer p) {
		this.currentShield = Math.min(this.currentShield + shield, maxShield);
	}

	public float getMaxShieldAmount(EntityPlayer p) {
		return this.maxShield + ConfigHandler.extraShieldAmount;
	}

}
