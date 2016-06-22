package com.meteor.extrabotany.common.recipe;

import net.minecraft.item.ItemStack;

import com.meteor.extrabotany.common.item.ModItems;
import com.meteor.extrabotany.common.lib.LibOreDictName;

import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeRuneAltar;
import vazkii.botania.common.lib.LibOreDict;

public class ModRuneRecipe {
	public static RecipeRuneAltar eternalSlienceRecipe;
	public static RecipeRuneAltar combatuniformRecipe;
	public static RecipeRuneAltar excaliberRecipe;
	public static RecipeRuneAltar vaxeRecipe;
	public static RecipeRuneAltar vhandgunRecipe;
	public static RecipeRuneAltar r1Recipe;
	public static RecipeRuneAltar r2Recipe;
	public static RecipeRuneAltar r3Recipe;
	public static RecipeRuneAltar r4Recipe;
	public static RecipeRuneAltar r5Recipe;
	public static RecipeRuneAltar r6Recipe;
	public static RecipeRuneAltar r7Recipe;
	public static RecipeRuneAltar r8Recipe;
	public static RecipeRuneAltar r9Recipe;
	public static RecipeRuneAltar r10Recipe;
	public static RecipeRuneAltar r11Recipe;
	public static RecipeRuneAltar r12Recipe;
	
	public static void init() {
		
		final int costTier1 = 5200;
		final int costTier2 = 8000;
		final int costTier3 = 12000;
		final int costTier4 = 20000;
		
		final ItemStack shard = new ItemStack(ModItems.material, 1, 11);
		final String runeWater = LibOreDict.RUNE[0], runeFire = LibOreDict.RUNE[1], runeEarth = LibOreDict.RUNE[2], runeAir = LibOreDict.RUNE[3], runeSpring = LibOreDict.RUNE[4], runeSummer = LibOreDict.RUNE[5], runeAutumn = LibOreDict.RUNE[6], runeWinter = LibOreDict.RUNE[7], runeMana = LibOreDict.RUNE[8], runeLust = LibOreDict.RUNE[9], runeGluttony = LibOreDict.RUNE[10], runeGreed = LibOreDict.RUNE[11], runeSloth = LibOreDict.RUNE[12], runeWrath = LibOreDict.RUNE[13], runeEnvy = LibOreDict.RUNE[14], runePride = LibOreDict.RUNE[15];
		
		eternalSlienceRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.eternalslience), costTier4, shard, shard, shard, shard, shard, shard, shard, shard
		, LibOreDictName.PRISMATIC_SHARD, LibOreDictName.PRISMATIC_SHARD, new ItemStack(ModItems.manapotato), LibOreDictName.ASTRAL_FORCE, new ItemStack(ModItems.material, 1, 9), runeGluttony, runeSloth, runePride);
		combatuniformRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.valkyriecombatuniform), costTier4, shard, shard, shard, shard, shard, shard, shard, shard
		, LibOreDictName.GAIA_ESSENCE, LibOreDictName.GAIA_ESSENCE, LibOreDictName.ASTRAL_FORCE, LibOreDictName.LYCORIS_GREEN, LibOreDictName.LYCORIS_PURPLE, runeSpring, runeGreed, runeMana);
		excaliberRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.excaliber), costTier3, shard, LibOreDictName.PRISMATIC_SHARD, LibOreDictName.PRISMATIC_SHARD, new ItemStack(ModItems.vhandgun), new ItemStack(ModItems.vpowerbattleaxe), new ItemStack(ModItems.excaliberfake)
		, new ItemStack(ModItems.heliacalclaymore), LibOreDictName.GAIA_ESSENCE, LibOreDictName.GAIA_ESSENCE, LibOreDictName.GAIA_ESSENCE, LibOreDictName.GAIA_ESSENCE, new ItemStack(ModItems.gaiatablet));
		vaxeRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.vpowerbattleaxe), costTier2, new ItemStack(ModItems.manapotato), LibOreDictName.BLANK_CARD, LibOreDict.ELEMENTIUM, LibOreDict.ELEMENTIUM, LibOreDict.ELEMENTIUM, LibOreDictName.QUARTZ_ELEMENTIUM);
		vhandgunRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.vhandgun), costTier2, new ItemStack(ModItems.manapotato), LibOreDictName.BLANK_CARD, LibOreDict.ELEMENTIUM, LibOreDict.ELEMENTIUM, LibOreDict.ELEMENTIUM, LibOreDictName.STRING_GOLD);
		r1Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.cthulhueye), costTier3, shard, shard, shard, shard, shard, shard, runeLust);
		r2Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.lokighostrick), costTier3, shard, shard, shard, shard, shard, shard, runeSpring);
		r3Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.hermeswand), costTier3, shard, shard, shard, shard, shard, shard, runeMana);
		r4Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.cronusphantom), costTier3, shard, shard, shard, shard, shard, shard, runeSummer);
		r5Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.excaliberfake), costTier3, shard, shard, shard, shard, shard, shard, runeWinter);
		r6Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.theseusship), costTier3, shard, shard, shard, shard, shard, shard, runeGreed);
		r7Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.vrangerboots), costTier3, shard, shard, shard, shard, shard, shard, runeSloth);
		r8Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.hestiachastity), costTier3, shard, shard, shard, shard, shard, shard, runeWrath);
		r9Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.hermestravelclothing), costTier3, shard, shard, shard, shard, shard, shard, runePride);
		r10Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.aphroditegrace), costTier3, shard, shard, shard, shard, shard, shard, runeEnvy);
		r11Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.maxwelldemon), costTier3, shard, shard, shard, shard, shard, shard, runeGluttony);
		r12Recipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.athenabless), costTier3, shard, shard, shard, shard, shard, shard, runeAutumn);
	}
	
}
