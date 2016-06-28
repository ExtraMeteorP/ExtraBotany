package com.meteor.extrabotany.common.item.weapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.common.lib.LibItemName;
import com.meteor.extrabotany.common.lib.LibReference;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemDarksword extends ItemSword{
	
	public static ToolMaterial toolMaterial = EnumHelper.addToolMaterial("B_DARK", 3, -1, 6.2F, 4.5F, 20);
	
	public static String TAG_COOLDOWN = "cooldown";

	public ItemDarksword() {
		super(toolMaterial);
		setUnlocalizedName(LibItemName.DARKSWORD);
		setTextureName(LibReference.MOD_ID + ":" + LibItemName.DARKSWORD);
		setCreativeTab(ExtraBotany.tabExtraBotany);
		GameRegistry.registerItem(this, LibItemName.DARKSWORD);
	}
	
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player){
		World world = player.worldObj;
		boolean b = world.isDaytime();	
		return target.attackEntityFrom(DamageSource.causeMobDamage(player), toolMaterial.getDamageVsEntity() + (b ? 0 : 7F));	
	}
}
