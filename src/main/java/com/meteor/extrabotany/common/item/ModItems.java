package com.meteor.extrabotany.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.meteor.extrabotany.common.item.basic.ItemBox;
import com.meteor.extrabotany.common.item.basic.ItemMaterial;
import com.meteor.extrabotany.common.item.basic.ItemRecordA;
import com.meteor.extrabotany.common.item.basic.ItemRecordB;
import com.meteor.extrabotany.common.item.basic.ItemRecordC;
import com.meteor.extrabotany.common.item.equipment.ItemBaubleDog;
import com.meteor.extrabotany.common.item.equipment.ItemGaiaWise;
import com.meteor.extrabotany.common.item.equipment.shield.ItemSGBee;
import com.meteor.extrabotany.common.item.equipment.shield.ItemSGEnhanced;
import com.meteor.extrabotany.common.item.equipment.shield.ItemSGGaia;
import com.meteor.extrabotany.common.item.equipment.shield.ItemSGMini;
import com.meteor.extrabotany.common.item.equipment.shield.ItemSGQuick;
import com.meteor.extrabotany.common.item.relic.legendary.ItemEternalSlience;
import com.meteor.extrabotany.common.item.relic.legendary.ItemExcaliber;
import com.meteor.extrabotany.common.item.relic.legendary.ItemHermesWand;
import com.meteor.extrabotany.common.item.relic.legendary.ItemMaxwellDemon;
import com.meteor.extrabotany.common.item.relic.legendary.ItemValkyrieCombatUniform;
import com.meteor.extrabotany.common.item.weapon.ItemHeliacalClaymore;
import com.meteor.extrabotany.common.item.weapon.ItemMermaidDagger;
import com.meteor.extrabotany.common.item.weapon.ItemScissorBladePurple;
import com.meteor.extrabotany.common.item.weapon.ItemScissorBladeRed;
import com.meteor.extrabotany.common.lib.LibEntityName;
import com.meteor.extrabotany.common.lib.LibItemName;
import com.meteor.extrabotany.common.lib.LibOreDictName;

public class ModItems {
	public static Item manapotato;
	public static Item gaiatablet;
	public static Item excaliber;
	public static Item lycorisgreen;
	public static Item lycorispurple;
	public static Item lycorisred;
	public static Item lycorisrandom;
	public static Item maxwelldemon;
	public static Item teleportpearl;
	public static Item gaianecklacebroken;
	public static Item dog;
	public static Item hermeswand;
	public static Item eternalslience;
	public static Item valkyriecombatuniform;
	
	public static Item gaiawise;
	public static Item angelwand;
	public static Item heliacalclaymore;
	
	public static Item itemtest;
	public static Item material;
	public static Item dungeonbox;
	public static Item boxs;
	
	public static Item scissorred;
	public static Item scissorpurple;
	
	public static Item recordB;
	public static Item recordA;
	public static Item recordC;
	
	public static Item key;
	
	public static Item reader;
	
	public static Item SGBee;
	public static Item SGGaia;
	public static Item SGEnhanced;
	public static Item SGMini;
	public static Item SGQuick;
	
	public static Item dagger;
	
	public static void init() {
		
		dagger = new ItemMermaidDagger(ToolMaterial.GOLD, "mermaiddagger");
		
		SGBee = new ItemSGBee();
		SGGaia = new ItemSGGaia();
		SGEnhanced = new ItemSGEnhanced();
		SGMini = new ItemSGMini();
		SGQuick = new ItemSGQuick();
		
		reader = new ItemManaReader(LibItemName.MANAREADER);
		
		recordA = new ItemRecordA("A", LibItemName.RECORD_A);
		recordB = new ItemRecordB("B", LibItemName.RECORD_B);
		recordC = new ItemRecordC("C", LibItemName.RECORD_C);

		itemtest = new ItemTest("test");
		
		dungeonbox = new ItemDungeonBox(LibItemName.DUNGEONBOX);
		boxs = new ItemBox(LibItemName.BOX);
		
		scissorred = new ItemScissorBladeRed(ToolMaterial.WOOD, LibItemName.SCISSORBLADERED);
		scissorpurple = new ItemScissorBladePurple(ToolMaterial.WOOD, LibItemName.SCISSORBLADEPURPLE);

		material = new ItemMaterial(LibItemName.MATERIAL);
				
		heliacalclaymore = new ItemHeliacalClaymore();
		dog = new ItemBaubleDog();
		gaiawise = new ItemGaiaWise(LibItemName.GAIAWISE);
		angelwand = new ItemAngelWand(LibItemName.ANGELWAND);
		
		maxwelldemon = new ItemMaxwellDemon();
		excaliber = new ItemExcaliber();		
		hermeswand = new ItemHermesWand(LibItemName.HERMESWAND);	
		eternalslience = new ItemEternalSlience(LibItemName.ETERNALSLIENCE);
		valkyriecombatuniform = new ItemValkyrieCombatUniform(LibItemName.VALKYRIECOMBATUNIFORM);
		
		manapotato = new ItemManaPotato(LibItemName.MANAPOTATO);
		gaiatablet = new ItemGaiaTablet();
		teleportpearl = new ItemTeleportPearl(LibItemName.TELEPORTPEARL);
		
		lycorisgreen = new ItemSpawnCardLycorisGreen(LibEntityName.LYCORISGREEN);
		lycorisred = new ItemSpawnCardLycorisRed(LibEntityName.LYCORISRED);
		lycorispurple = new ItemSpawnCardLycorisPurple(LibEntityName.LYCORISPURPLE);
		lycorisrandom = new ItemSpawnCardLycorisRandom("lycorisrandom");
		
		key = new ItemMods("key");
		
		//OreDict
		OreDictionary.registerOre(LibOreDictName.DOG, new ItemStack(dog, 1, 0));
		OreDictionary.registerOre(LibOreDictName.DOG, new ItemStack(dog, 1, 1));
		OreDictionary.registerOre(LibOreDictName.DOG, new ItemStack(dog, 1, 2));
		OreDictionary.registerOre(LibOreDictName.DOG, new ItemStack(dog, 1, 3));
		OreDictionary.registerOre(LibOreDictName.PRISMATIC_SHARD, new ItemStack(material, 1, 0));
		OreDictionary.registerOre(LibOreDictName.BLANK_CARD, new ItemStack(material, 1, 1));
		OreDictionary.registerOre(LibOreDictName.GAIA_ESSENCE, new ItemStack(material, 1, 2));
		OreDictionary.registerOre(LibOreDictName.ASTRAL_FORCE, new ItemStack(material, 1, 3));
		OreDictionary.registerOre(LibOreDictName.LYCORIS_RED, new ItemStack(material, 1, 4));
		OreDictionary.registerOre(LibOreDictName.LYCORIS_GREEN, new ItemStack(material, 1, 5));
		OreDictionary.registerOre(LibOreDictName.LYCORIS_PURPLE, new ItemStack(material, 1, 6));
		OreDictionary.registerOre(LibOreDictName.QUARTZ_GAIA, new ItemStack(material, 1, 7));
		OreDictionary.registerOre(LibOreDictName.QUARTZ_ELEMENTIUM, new ItemStack(material, 1, 8));
		OreDictionary.registerOre(LibOreDictName.STRING_GOLD, new ItemStack(material, 1, 9));
		OreDictionary.registerOre(LibOreDictName.DICE_EMPTY, new ItemStack(material, 1, 10));
	}

}
