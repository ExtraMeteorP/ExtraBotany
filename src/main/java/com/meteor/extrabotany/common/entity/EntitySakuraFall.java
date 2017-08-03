package com.meteor.extrabotany.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.meteor.extrabotany.common.core.handler.WorldHandler;

import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ability.StylishRankManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySakuraFall extends EntityThrowable {
	
	public EntitySakuraFall(World world) {
		super(world);
	}
	
	private float roll;
	
	public EntitySakuraFall(World world, EntityLivingBase thrower,float roll) {
		super(world, thrower);
		this.roll = roll;
	}
	
	public float getRoll(){
		return this.roll;
	}
	
    @Override
    protected float getGravityVelocity(){
        return 0F;
    }
    
    @Override
	protected void entityInit() {
		setSize(0F, 0F);
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		EntityLivingBase thrower = getThrower();
		if(!worldObj.isRemote && (thrower == null || !(thrower instanceof EntityPlayer) || thrower.isDead)) {
			setDead();
			return;
		}
		EntityPlayer player = (EntityPlayer) thrower;
		if(!worldObj.isRemote) {
			AxisAlignedBB axis = AxisAlignedBB.getBoundingBox(posX, posY, posZ, lastTickPosX, lastTickPosY, lastTickPosZ).expand(2, 2, 2);
			List<EntityLivingBase> entities = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axis);
			for(EntityLivingBase living : entities) {
				if(living == thrower)
					continue;

				if(living.hurtTime == 0) {
					if(player != null){
						living.attackEntityFrom(DamageSource.causePlayerDamage(player), 14F);
					}else {
						living.attackEntityFrom(DamageSource.magic, 14F);
					}
					return;
				}
			}
			
			if(this.ticksExisted > 15)
				setDead();
		}
		
		this.motionY = 0;
		this.motionX = 0;
		this.motionZ = 0;
	}
	
	@Override
	protected void onImpact(MovingObjectPosition pos) {

	}
	
}
