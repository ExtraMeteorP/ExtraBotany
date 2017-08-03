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
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.Botania;

import com.meteor.extrabotany.common.entity.EntitySakuraFall;

public class SubTileJudasvowSakura extends SubTileEntity implements IManaUsingItem{
	
	private static final String TAG_NAME = "playername";
	private static final String TAG_SAKURA = "sakura";
	
	String name;
	int count = 0;
	

	@Override
	public void writeToPacketNBT(NBTTagCompound cmp) {
		super.writeToPacketNBT(cmp);
		cmp.setString(TAG_NAME, name);
		cmp.setInteger(TAG_SAKURA, count);
	}

	@Override
	public void readFromPacketNBT(NBTTagCompound cmp) {
		super.readFromPacketNBT(cmp);
		name = cmp.getString(TAG_NAME);
		count = cmp.getInteger(TAG_SAKURA);
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

		for(int r = 0; r<3; r++){
			for(int i = 0; i < 360; i += 2) {
				float rad = i * (float) Math.PI / 180F;
				double x = this.supertile.xCoord + 0.5 - Math.cos(rad) * (5-0.05*r);
				double y = this.supertile.yCoord + 0.2;
				double z = this.supertile.zCoord + 0.5 - Math.sin(rad) * (5-0.05*r);

				Botania.proxy.sparkleFX(this.supertile.getWorldObj(), x, y, z, 0.96F, 0.58F, 0.66F, 2F, 5);
			}
		}
		World world = this.supertile.getWorldObj();
		
		List<IMob> ls = supertile.getWorldObj().getEntitiesWithinAABB(IMob.class, AxisAlignedBB.getBoundingBox(supertile.xCoord - 5, supertile.yCoord - 5, supertile.zCoord - 5, supertile.xCoord + 6, supertile.yCoord + 6, supertile.zCoord + 6));
		if(!this.supertile.getWorldObj().isRemote && ls.size() > 0 && count < 9){
			if(ticksExisted % 8 == 0 && ticksExisted > 0){
				Entity mob = (Entity) ls.get(0);
				EntitySakuraFall sakura = new EntitySakuraFall(world, world.getPlayerEntityByName(name),(float) (160+Math.random()*40));    
				if (sakura != null && mob != null) {
					sakura.setPosition(mob.posX, mob.posY+0.4, mob.posZ);
			    	world.spawnEntityInWorld(sakura);
			    	count++;
			    }
			}		
		}
		
		if(count == 9)
			this.supertile.getWorldObj().func_147480_a(supertile.xCoord, supertile.yCoord, supertile.zCoord, true);
	}
	
	@Override
	public boolean usesMana(ItemStack stack) {
		return true;
	}

}
