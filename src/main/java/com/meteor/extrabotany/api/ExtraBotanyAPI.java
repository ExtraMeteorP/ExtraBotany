package com.meteor.extrabotany.api;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.api.extrabotany.recipe.RecipeInfernoidisy;
import com.meteor.extrabotany.api.extrabotany.recipe.RecipeStonesia;
import com.meteor.extrabotany.common.block.ModBlocks;
import com.meteor.extrabotany.common.core.handler.PropertyHandler;
import com.meteor.extrabotany.common.item.ModItems;
import com.valentin4311.candycraftmod.CandyCraft;

public class ExtraBotanyAPI {
	
	public static ModItems ModItems = new ModItems();
	public static ModBlocks ModBlocks = new ModBlocks();
	
	public static Set<Item> diplopbambooBlacklist = new LinkedHashSet<Item>();
	public static Set<Item> artifaconiaWhitelist = new LinkedHashSet<Item>();
	
	public static List<RecipeInfernoidisy> infernoidisyRecipes = new ArrayList<RecipeInfernoidisy>();
	public static List<RecipeStonesia> stonesiaRecipes = new ArrayList<RecipeStonesia>();
	
	public static Set<Object> sweetTier1 = new LinkedHashSet<Object>();//8
	public static Set<Object> sweetTier2 = new LinkedHashSet<Object>();//16
	public static Set<Object> sweetTier3 = new LinkedHashSet<Object>();//32
	public static Set<Object> sweetTier4 = new LinkedHashSet<Object>();//64
	public static Set<Object> sweetTier5 = new LinkedHashSet<Object>();//128
	public static Set<Object> sweetTier6 = new LinkedHashSet<Object>();//256
	
	static{
		
		if(ExtraBotany.candycraftLoaded){
			sT1(CandyCraft.WaffleNugget);
			sT1(CandyCraft.SugarCrystal);
			
			sT2(CandyCraft.ChewingGum);
			sT2(CandyCraft.Lollipop);
			sT2(CandyCraft.CranberryFish);
			sT2(CandyCraft.Dragibus);
			sT2(CandyCraft.Gummy);
			sT2(CandyCraft.GummyBall);
			sT2(CandyCraft.PEZDust);
			sT2(CandyCraft.CandiedCherry);
			sT2(CandyCraft.ChocolateCoins);
			sT2(CandyCraft.Licorice);
			sT2(CandyCraft.CranberryScale);
			sT2(CandyCraft.HoneyShard);
			sT2(CandyCraft.CottonCandy);
			sT2(CandyCraft.MarshmallowFlower);
			sT2(CandyCraft.NougatPowder);

			sT3(CandyCraft.CranberryFishCooked);
			sT3(CandyCraft.HoneyComb);
			sT3(CandyCraft.Waffle);
			sT3(CandyCraft.PEZ);
		}
		
		sT2(Items.cookie);
		sT2(Items.sugar);
		
		sT6(Items.cake);
	}
	
	public static void sT1(Item i){
		sweetTier1.add(i);
	}
	
	public static void sT2(Item i){
		sweetTier2.add(i);
	}
	
	public static void sT3(Item i){
		sweetTier3.add(i);
	}
	
	public static void sT4(Item i){
		sweetTier4.add(i);
	}
	
	public static void sT5(Item i){
		sweetTier5.add(i);
	}
	
	public static void sT6(Item i){
		sweetTier6.add(i);
	}
	
	public static DamageSource[] damageSource = {
		new DamageSource("realDamage"),
		new DamageSource("realDamageHoly"),
		new DamageSource("realDamageCursed"),
		new DamageSource("realDamageGaia"),
		new DamageSource("magicDamage"),
		new DamageSource("magicDamageMissile"),
		new DamageSource("magicDamageLandmine"),
	};
	
	public static boolean isRealDamage(DamageSource s){
		return s.toString().startsWith("realDamage");
	}
	
	public static boolean isMagicDamage(DamageSource s){
		return s.toString().startsWith("magicDamage");
	}
	
	public static void addShield(float shield, EntityPlayer player){
		PropertyHandler.addShieldAmount(shield, player);
	}
	
	public static void setShield(float shield, EntityPlayer player){
		PropertyHandler.setShieldAmount(shield, player);
	}
	
	public static void getShield(EntityPlayer player){
		PropertyHandler.getShieldAmount(player);
	}
	
	public static void getMaxShield(EntityPlayer player){
		PropertyHandler.getMaxShieldAmount(player);
	}
	
	public static void blacklistItemFromDiplopBamboo(Item item){
		diplopbambooBlacklist.add(item);
	}
	
	public static boolean isItemBlacklistedFromDiplopBamboo(Item item){
		return diplopbambooBlacklist.contains(item);
	}
	
	public static void whitelistItemFromArtifaconia(Item item){
		artifaconiaWhitelist.add(item);
	}
	
	public static boolean isItemWhitelistedFromArtifaconia(Item item){
		return artifaconiaWhitelist.contains(item);
	}
	
	public static RecipeInfernoidisy registerInfernoidisyRecipe(Object input, Block output, int outputMeta) {
		RecipeInfernoidisy recipe = new RecipeInfernoidisy(input, output, outputMeta);
		infernoidisyRecipes.add(recipe);
		return recipe;
	}
	
	public static RecipeStonesia registerStonesiaRecipe(Object input, int mana) {
		RecipeStonesia recipe = new RecipeStonesia(input, mana);
		stonesiaRecipes.add(recipe);
		return recipe;
	}
	
	public static RecipeInfernoidisy removeInfernoidisyRecipe(Object input, Block output, int outputMeta) {
		RecipeInfernoidisy recipe = new RecipeInfernoidisy(input, output, outputMeta);
		infernoidisyRecipes.remove(recipe);
		return recipe;
	}
	
	public static RecipeStonesia removeStonesiaRecipe(Object input, int mana) {
		RecipeStonesia recipe = new RecipeStonesia(input, mana);
		stonesiaRecipes.remove(recipe);
		return recipe;
	}

}
