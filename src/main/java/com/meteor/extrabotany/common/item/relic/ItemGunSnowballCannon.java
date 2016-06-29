package com.meteor.extrabotany.common.item.relic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

import com.meteor.extrabotany.common.entity.bullet.EntityBulletSnowball;

public class ItemGunSnowballCannon extends ItemGunRelic{

	public ItemGunSnowballCannon(String name) {
		super(name);
	}
	
	@Override
	public int selectBullet(EntityPlayer player){
		if(player.inventory.hasItem(Items.snowball))
		return 1;
		else return 0;
	}
	
	@Override
	public void consumeBullet(EntityPlayer player){
		if(selectBullet(player) == 1)
			player.inventory.consumeInventoryItem(Items.snowball);
	}
	
	@Override
	public void summonBullet(EntityPlayer player){
		EntityBulletSnowball snowball = new EntityBulletSnowball(player.worldObj, player);
		if(selectBullet(player) == 1)
			player.worldObj.spawnEntityInWorld(snowball);
	}
	
	@Override
	public int getReloadSpeed(){
		return 16;
	}
	
	@Override
	public int getReloadAmount(){
		return 16;
	}

}
