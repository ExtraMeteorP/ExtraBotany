package com.meteor.extrabotany.common.item.weapon;

public class ItemGunPistol extends ItemGun{

	public ItemGunPistol(String name) {
		super(name);
	}
	
	@Override
	public int getReloadSpeed(){
		return 16;
	}
	
	@Override
	public int getReloadAmount(){
		return 6;
	}
}
