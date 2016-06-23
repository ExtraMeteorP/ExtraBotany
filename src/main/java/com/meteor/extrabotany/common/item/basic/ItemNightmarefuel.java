package com.meteor.extrabotany.common.item.basic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.meteor.extrabotany.common.item.ItemMods;
import com.meteor.extrabotany.common.lib.LibItemName;

public class ItemNightmarefuel extends ItemMods{

	public ItemNightmarefuel() {
		super(LibItemName.NIGHTMAREFUEL);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b) {
		if(entity instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer) entity;
			if(Math.random() < 0.02F)
				if(world.rand.nextInt(200) == 4)
					switch(world.rand.nextInt(5)){
						case 0:
							p.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 60, 1));
							break;
						case 1:
							p.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 60, 1));
							break;
						case 2:
							p.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 60, 1));
							break;
						case 3:
							p.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 60, 1));
							break;
						case 4:
							p.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 60, 1));
							break;
					}
		}	
	}

}
