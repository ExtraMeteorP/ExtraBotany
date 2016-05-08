package com.meteor.extrabotany.common.entity.bullet;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityBulletSilver extends EntityBullet{
	
	public EntityBulletSilver(World world)
	{
	    super(world);
	    this.setDamage(9F);
	}

	public EntityBulletSilver(World world, EntityLivingBase entity)
	{
	    super(world, entity);
	}

	public EntityBulletSilver(World world, double x, double y, double z)
	{
	    super(world, x, y, z);
	}

}
