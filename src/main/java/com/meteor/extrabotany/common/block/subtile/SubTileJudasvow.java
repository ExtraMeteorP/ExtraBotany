package com.meteor.extrabotany.common.block.subtile;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.api.subtile.SubTileEntity;

import com.meteor.extrabotany.common.entity.EntitySpear;
import com.meteor.extrabotany.common.lexicon.LexiconModData;

public class SubTileJudasvow extends SubTileEntity implements IManaUsingItem{

	private static final int RANGE = 9;
	private static final String TAG_NAME = "playername";
	
	String name;
	

	@Override
	public void writeToPacketNBT(NBTTagCompound cmp) {
		super.writeToPacketNBT(cmp);
		cmp.setString(TAG_NAME, name);
	}

	@Override
	public void readFromPacketNBT(NBTTagCompound cmp) {
		super.readFromPacketNBT(cmp);
		name = cmp.getString(TAG_NAME);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) entity;
			if(!ManaItemHandler.requestManaExact(stack, player, 1200, true))
				this.supertile.getWorldObj().func_147480_a(supertile.xCoord, supertile.yCoord, supertile.zCoord, true);
			name = player.getDisplayName();
		}
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();	
		int count = 0;
		List<IMob> ls = supertile.getWorldObj().getEntitiesWithinAABB(IMob.class, AxisAlignedBB.getBoundingBox(supertile.xCoord - RANGE, supertile.yCoord - RANGE, supertile.zCoord - RANGE, supertile.xCoord + RANGE + 1, supertile.yCoord + RANGE + 1, supertile.zCoord + RANGE + 1));
		if(!this.supertile.getWorldObj().isRemote){
			if(ticksExisted % 5 == 0 && ticksExisted > 0){
				if(ls.size() > 0)
					for(int t = 0; t < 54; t++){
						if(t % 5 == 0){
							EntitySpear weapon = new EntitySpear(supertile.getWorldObj(),supertile.getWorldObj().getPlayerEntityByName(name));
							for(int i = 0; i < ls.size(); i++){
								weapon.setPosition(((Entity)ls.get(0)).posX, ((Entity)ls.get(0)).posY + 12 + Math.min(2 * i * t, 20), ((Entity)ls.get(0)).posZ);
								weapon.setDelay((int)(i * t * 1.2F));	
							}
							this.supertile.getWorldObj().spawnEntityInWorld(weapon);
							count++;
							break;
						}
					}
			}
			
			if(ticksExisted > 60 || count > 11)
				this.supertile.getWorldObj().func_147480_a(supertile.xCoord, supertile.yCoord, supertile.zCoord, true);	
		}
	}
	
	@Override
	public LexiconEntry getEntry() {
		return LexiconModData.judasvow;
	}

	@Override
	public boolean usesMana(ItemStack arg0) {
		return true;
	}
}
