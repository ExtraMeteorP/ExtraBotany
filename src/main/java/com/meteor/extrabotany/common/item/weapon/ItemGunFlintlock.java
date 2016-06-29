package com.meteor.extrabotany.common.item.weapon;

public class ItemGunFlintlock extends ItemGun{

	public ItemGunFlintlock(String name) {
		super(name);
	}
	
	@Override
	public int getReloadSpeed(){
		return 22;
	}
	
	@Override
	public int getReloadAmount(){
		return 6;
	}
}
