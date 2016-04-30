package com.meteor.extrabotany.common.item.relic;

import com.meteor.extrabotany.common.entity.bullet.EntityBulletExploding;
import com.meteor.extrabotany.common.entity.bullet.EntityBulletGold;
import com.meteor.extrabotany.common.entity.bullet.EntityBulletHighVelocity;
import com.meteor.extrabotany.common.entity.bullet.EntityBulletMeteor;
import com.meteor.extrabotany.common.entity.bullet.EntityBulletMusket;
import com.meteor.extrabotany.common.entity.bullet.EntityBulletSilver;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemGunPhoenixBlaster extends ItemGunRelic{

	public ItemGunPhoenixBlaster(String name) {
		super(name);
	}
	
	int shootspeed = 12;
	
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		super.onUsingTick(stack, player, count);
			if(count <= this.getMaxItemUseDuration(stack)- shootspeed && count % shootspeed == 0){
				if(ItemGunRelic.isRightPlayer(player, stack))	
					shoot(player);
			}
	}
	
	@Override
	public void summonBullet(EntityPlayer player){
		EntityBulletExploding s1 = new EntityBulletExploding(player.worldObj, player);
		EntityBulletGold s2 = new EntityBulletGold(player.worldObj, player);
		EntityBulletHighVelocity s3 = new EntityBulletHighVelocity(player.worldObj, player);
		EntityBulletMeteor s4 = new EntityBulletMeteor(player.worldObj, player);
		EntityBulletMusket s5 = new EntityBulletMusket(player.worldObj, player);
		EntityBulletSilver s6 = new EntityBulletSilver(player.worldObj, player);
		if(!player.worldObj.isRemote){
			switch(selectBullet(player)){
			case 1:
				s5.setFire(100);
				player.worldObj.spawnEntityInWorld(s5);
				break;
			case 2:
				s6.setFire(100);
				player.worldObj.spawnEntityInWorld(s6);
				break;
			case 3:
				s2.setFire(100);
				player.worldObj.spawnEntityInWorld(s2);
				break;
			case 4:
				s4.setFire(100);
				player.worldObj.spawnEntityInWorld(s4);
				break;
			case 5:
				s3.setFire(100);
				player.worldObj.spawnEntityInWorld(s3);
				break;
			case 6:
				s1.setFire(100);
				player.worldObj.spawnEntityInWorld(s1);
				break;
			}	
		}
	}

}