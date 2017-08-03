package com.meteor.extrabotany.common.lexicon;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconCategory;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lexicon.BLexiconEntry;
import vazkii.botania.common.lexicon.DLexiconEntry;
import vazkii.botania.common.lexicon.page.PageCraftingRecipe;
import vazkii.botania.common.lexicon.page.PageManaInfusionRecipe;
import vazkii.botania.common.lexicon.page.PageMultiblock;
import vazkii.botania.common.lexicon.page.PagePetalRecipe;
import vazkii.botania.common.lexicon.page.PageRuneRecipe;
import vazkii.botania.common.lexicon.page.PageText;

import com.meteor.extrabotany.common.block.ModBlocks;
import com.meteor.extrabotany.common.block.ModMultiBlocks;
import com.meteor.extrabotany.common.core.handler.ConfigHandler;
import com.meteor.extrabotany.common.item.ModItems;
import com.meteor.extrabotany.common.lib.LibBlockName;
import com.meteor.extrabotany.common.lib.LibLexiconName;
import com.meteor.extrabotany.common.lib.LibReference;
import com.meteor.extrabotany.common.recipe.ModManaInfusionRecipe;
import com.meteor.extrabotany.common.recipe.ModPetalRecipe;
import com.meteor.extrabotany.common.recipe.ModRecipe;
import com.meteor.extrabotany.common.recipe.ModRuneRecipe;

public class LexiconModData {
	//Other
	public static LexiconEntry pickup;
	public static LexiconEntry shield;
	public static LexiconEntry advancedmaterial;
	//Generating 
	public static LexiconEntry candyflower;
	public static LexiconEntry blueenchantress;
	public static LexiconEntry sunshinelily;
	public static LexiconEntry moonlightlily;
	public static LexiconEntry geminiorchid;
	public static LexiconEntry ominiviolet;
	public static LexiconEntry pyschobloom;
	public static LexiconEntry stonesia;
	public static LexiconEntry bellflower;
	//Functional
	public static LexiconEntry necrofleur;
	public static LexiconEntry numerondandelife;
	public static LexiconEntry woodienia;
	public static LexiconEntry icebirdium;
	public static LexiconEntry numeronbalsam;
	public static LexiconEntry volatilily;
	public static LexiconEntry judasvow;
	public static LexiconEntry diplopbamboo;
	public static LexiconEntry voiduim;
	public static LexiconEntry artifaconia;
	public static LexiconEntry infernoidisy;
	public static LexiconEntry launchish;
	public static LexiconEntry annoyobloom;
	public static LexiconEntry manalinkuim;
	//Fun
	public static LexiconEntry infinitymana;
	//Relics
	public static LexiconEntry hestiachastity;
	public static LexiconEntry maxwelldemon;
	public static LexiconEntry athenabless;
	public static LexiconEntry aphroditegrace;
	public static LexiconEntry dice20;
	public static LexiconEntry excaliber;
	public static LexiconEntry excaliberfake;
	public static LexiconEntry vpowerbattleaxe;
	public static LexiconEntry vhandgun;
	public static LexiconEntry vrangerboots;
	public static LexiconEntry phoenixblaster;
	public static LexiconEntry snowballcannon;
	public static LexiconEntry tacticalshotgun;
	public static LexiconEntry gaia3;
	
	public static LexiconEntry cronusphantom;
	public static LexiconEntry hermestravelclothing;
	public static LexiconEntry cthulhueye;
	public static LexiconEntry eternalslience;
	public static LexiconEntry hermestravelwand;
	public static LexiconEntry lokighostrick;
	public static LexiconEntry olympusguard;
	public static LexiconEntry theseusship;
	public static LexiconEntry valkyriecombatsuit;
	
	//Cosmetic
	public static LexiconEntry cosmetic;
	//Basic
	public static LexiconEntry blankcard;
	public static LexiconEntry shard;
	public static LexiconEntry petal;
	public static LexiconEntry astralforce;
	public static LexiconEntry teleportpearl;
	//Weapon
	public static LexiconEntry coronaclaymore;
	public static LexiconEntry scissorblade;
	public static LexiconEntry angelwand;
	//enchantment
	public static LexiconEntry enchantment;
	//util
	public static LexiconEntry manareader;
	//box
	public static LexiconEntry key;
	public static LexiconEntry mysterybox;
	public static LexiconEntry dungeonbox;
	//Category
	public static LexiconCategory categoryExtra;
	
	public static void init() {	
		categoryExtra = new LexiconCategory(StatCollector.translateToLocal("category.Botania:extra"));
		categoryExtra.setIcon(LibReference.EXTRA);
		categoryExtra.setPriority(0);
		BotaniaAPI.addCategory(categoryExtra);	
		//enchantment
		enchantment = new ELexiconEntry(LibLexiconName.ENCHANTMENT, categoryExtra);
		enchantment.setLexiconPages(new PageText("0"), 
				new PageCraftingRecipe("1", ModRecipe.egaiablessing), 
				new PageCraftingRecipe("2", ModRecipe.edivinefavor), 
				new PageCraftingRecipe("3", ModRecipe.edivinemark));
		enchantment.setIcon(new ItemStack(Items.enchanted_book));
		//util
		key = new BLexiconEntry(LibLexiconName.U_KEY, categoryExtra);
		key.setLexiconPages(new PageText("0"));
		key.setIcon(new ItemStack(ModItems.key));
		
		mysterybox = new BLexiconEntry(LibLexiconName.U_MYSTERYBOX, categoryExtra);
		mysterybox.setLexiconPages(new PageText("0"));
		mysterybox.setIcon(new ItemStack(ModItems.boxs));
		
		dungeonbox = new BLexiconEntry(LibLexiconName.U_DUNGEONBOX, categoryExtra);
		dungeonbox.setLexiconPages(new PageText("0"));
		dungeonbox.setIcon(new ItemStack(ModItems.dungeonbox));
		
		manareader = new BLexiconEntry(LibLexiconName.U_MANAREADER, categoryExtra);
		manareader.setLexiconPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipe.manareader));
		manareader.setIcon(new ItemStack(ModItems.reader));
		//Other
		pickup = new ELexiconEntry(LibLexiconName.O_PICKUP, categoryExtra);
		pickup.setLexiconPages(new PageText("0"));
		pickup.setIcon(new ItemStack(ModItems.material, 1, 14));
		
		shield = new ELexiconEntry(LibLexiconName.O_SHIELD, categoryExtra);
		shield.setLexiconPages(new PageText("0"));
		shield.setIcon(new ItemStack(ModItems.material, 1, 13));
		//Basic
		blankcard = new BLexiconEntry(LibLexiconName.BA_BLANKCARD, categoryExtra);
		blankcard.setLexiconPages(new PageText("0"), 
				new PageManaInfusionRecipe("1", ModManaInfusionRecipe.blankCardRecipe));
		blankcard.setIcon(new ItemStack(ModItems.material, 1, 1));
		
		shard = new BLexiconEntry(LibLexiconName.BA_PRISMATICSHARD, categoryExtra);
		shard.setLexiconPages(new PageText("0"));
		shard.setIcon(new ItemStack(ModItems.material));
		
		advancedmaterial = new ELexiconEntry(LibLexiconName.O_ADVANCEDMATERIAL, categoryExtra);
		advancedmaterial.setLexiconPages(new PageText("0"), new PageText("1"), new PageText("2"));
		advancedmaterial.setIcon(new ItemStack(ModItems.material, 1, 11));
		
		petal = new BLexiconEntry(LibLexiconName.BA_PETAL, categoryExtra);
		petal.setLexiconPages(new PageText("0"));
		petal.setIcon(new ItemStack(ModItems.lycorisrandom));
		
		teleportpearl = new ELexiconEntry(LibLexiconName.BA_TELEPORTPEARL, categoryExtra);
		teleportpearl.setLexiconPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipe.teleportpearl));
		teleportpearl.setIcon(new ItemStack(ModItems.teleportpearl));
		
		//weapon
		angelwand = new ELexiconEntry(LibLexiconName.W_ANGELWAND, categoryExtra);
		angelwand.setLexiconPages(new PageText("0"),
				new PageCraftingRecipe("1", ModRecipe.angelwand));
		angelwand.setIcon(new ItemStack(ModItems.angelwand));

		coronaclaymore = new ELexiconEntry(LibLexiconName.W_CLAYMORE, categoryExtra);
		coronaclaymore.setLexiconPages(new PageText("0"));
		coronaclaymore.setIcon(new ItemStack(ModItems.heliacalclaymore));
		
		scissorblade = new ELexiconEntry(LibLexiconName.W_BLADE, categoryExtra);
		scissorblade.setLexiconPages(new PageText("0"),
				new PageCraftingRecipe("1", ModRecipe.bladered), new PageCraftingRecipe("2", ModRecipe.bladepurple));
		scissorblade.setIcon(new ItemStack(ModItems.scissorred));
		
		//Bauble
		cosmetic = new ELexiconEntry(LibLexiconName.B_COSMETIC, categoryExtra);
		cosmetic.setLexiconPages(new PageText("0"), 
				new PageCraftingRecipe("1", ModRecipe.baubleDog0), 
				new PageCraftingRecipe("2", ModRecipe.baubleDog1), 
				new PageCraftingRecipe("3", ModRecipe.baubleDog2), 
				new PageCraftingRecipe("4", ModRecipe.baubleDog3));
		cosmetic.setIcon(new ItemStack(ModItems.dog, 1, 0));
		//Generating
		candyflower = new ELexiconEntry(LibLexiconName.GFLOWER_CANDYFLOWER, BotaniaAPI.categoryGenerationFlowers);
		candyflower.setLexiconPages(new PageText("0"), new PageText("1"),
				new PagePetalRecipe("2", ModPetalRecipe.candyflowerRecipe));
		candyflower.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.CANDY_FLOWER));
		
		blueenchantress = new ELexiconEntry(LibLexiconName.GFLOWER_BLUEENCHANTRESS, BotaniaAPI.categoryGenerationFlowers);
		blueenchantress.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.blueenchantressRecipe));
		blueenchantress.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.BLUE_ENCHANTRESS));
		
		sunshinelily = new ELexiconEntry(LibLexiconName.GFLOWER_SUNSHINELILY, BotaniaAPI.categoryGenerationFlowers);
		sunshinelily.setLexiconPages(new PageText("0"), new PageText("1"),
				new PagePetalRecipe("2", ModPetalRecipe.sunshinelilyRecipe));
		sunshinelily.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.SUNSHINE_LILY));
		
		moonlightlily = new ELexiconEntry(LibLexiconName.GFLOWER_MOONLIGHTLILY, BotaniaAPI.categoryGenerationFlowers);
		moonlightlily.setLexiconPages(new PageText("0"), new PageText("1"),
				new PagePetalRecipe("2", ModPetalRecipe.moonlightlilyRecipe));
		moonlightlily.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.MOONLIGHT_LILY));
		
		ominiviolet = new ELexiconEntry(LibLexiconName.GFLOWER_OMINIVIOLET, BotaniaAPI.categoryGenerationFlowers);
		ominiviolet.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.ominivioletRecipe));
		ominiviolet.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.OMNIVIOLET));
		
		geminiorchid = new ELexiconEntry(LibLexiconName.GFLOWER_GEMINIORCHID, BotaniaAPI.categoryGenerationFlowers);
		geminiorchid.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.geminiorchidRecipe));
		geminiorchid.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.GEMINIORCHID));
		
		stonesia = new ELexiconEntry(LibLexiconName.GFLOWER_STONESIA, BotaniaAPI.categoryGenerationFlowers);
		stonesia.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.stonesiaRecipe));
		stonesia.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.STONESIA));
		
		pyschobloom = new ELexiconEntry(LibLexiconName.GFLOWER_PYSCHOBLOOM, BotaniaAPI.categoryGenerationFlowers);
		pyschobloom.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.pyschobloomRecipe));
		pyschobloom.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.PYSCHOBLOOM));
		
		bellflower = new ELexiconEntry(LibLexiconName.GFLOWER_BELLFLOWER, BotaniaAPI.categoryGenerationFlowers);
		bellflower.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.bellflowerRecipe));
		bellflower.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.BELLFLOWER));
		//Functional
		necrofleur = new ELexiconEntry(LibLexiconName.FFLOWER_NECROFLEUR, BotaniaAPI.categoryFunctionalFlowers);
		necrofleur.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.necrofleurRecipe));
		necrofleur.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.NECRO_FLUER));
		
		numerondandelife = new ELexiconEntry(LibLexiconName.FFLOWER_NUMERONDANDELIFE, BotaniaAPI.categoryFunctionalFlowers);
		numerondandelife.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.numerondandelifeRecipe));
		numerondandelife.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.NUMERON_DANDELIFE));
		
		icebirdium = new ELexiconEntry(LibLexiconName.FFLOWER_ICEBIRDIUM, BotaniaAPI.categoryFunctionalFlowers);
		icebirdium.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.icebirdiumRecipe));
		icebirdium.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.ICEBIRDIUM));
		
		judasvow = new ELexiconEntry(LibLexiconName.FFLOWER_JUDASVOW, BotaniaAPI.categoryFunctionalFlowers);
		judasvow.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.judasvowRecipe));
		judasvow.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.JUDASVOW));
		
		volatilily = new ELexiconEntry(LibLexiconName.FFLOWER_VOLATILILY, BotaniaAPI.categoryFunctionalFlowers);
		volatilily.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.volatililyRecipe));
		volatilily.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.VOLATILILY));
		
		numeronbalsam = new ELexiconEntry(LibLexiconName.FFLOWER_NUMERONBALSAM, BotaniaAPI.categoryFunctionalFlowers);
		numeronbalsam.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.numeronbalsamRecipe));
		numeronbalsam.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.NUMERON_BALSAM));
		
		if(ConfigHandler.enableDiplopbamboo){
			diplopbamboo = new ELexiconEntry(LibLexiconName.FFLOWER_DIPLOPBAMBOO, BotaniaAPI.categoryFunctionalFlowers);
			diplopbamboo.setLexiconPages(new PageText("0"),
					new PagePetalRecipe("1", ModPetalRecipe.diplopbambooRecipe));
			diplopbamboo.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.DIPLOPBAMBOO));
		}
		
		voiduim = new ELexiconEntry(LibLexiconName.FFLOWER_VOIDUIM, BotaniaAPI.categoryFunctionalFlowers);
		voiduim.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.voiduimRecipe));
		voiduim.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.VOIDUIM));
		
		woodienia = new ELexiconEntry(LibLexiconName.FFLOWER_WOODIENIA, BotaniaAPI.categoryFunctionalFlowers);
		woodienia.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.woodieniaRecipe));
		woodienia.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.WOODIENIA));
		
		artifaconia = new ELexiconEntry(LibLexiconName.FFLOWER_ARTIFACONIA, BotaniaAPI.categoryFunctionalFlowers);
		artifaconia.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.artifaconiaRecipe));
		artifaconia.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.ARTIFACONIA));
		
		infernoidisy = new ELexiconEntry(LibLexiconName.FFLOWER_INFERNOIDISY, BotaniaAPI.categoryFunctionalFlowers);
		infernoidisy.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.infernoidisyRecipe));
		infernoidisy.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.INFERNOIDISY));
		
		launchish = new ELexiconEntry(LibLexiconName.FFLOWER_LAUNCHISH, BotaniaAPI.categoryFunctionalFlowers);
		launchish.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.launchishRecipe));
		launchish.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.LAUNCHISH));
		
		annoyobloom = new ELexiconEntry(LibLexiconName.FFLOWER_ANNOYOBLOOM, BotaniaAPI.categoryFunctionalFlowers);
		annoyobloom.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.annoyobloomRecipe));
		annoyobloom.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.ANNOYOBLOOM));
		
		manalinkuim = new ELexiconEntry(LibLexiconName.FFLOWER_MANALINKUIM, BotaniaAPI.categoryFunctionalFlowers);
		manalinkuim.setLexiconPages(new PageText("0"),
				new PagePetalRecipe("1", ModPetalRecipe.manalinkuim));
		manalinkuim.setIcon(ItemBlockSpecialFlower.ofType(LibBlockName.MANALINKUIM));
		//For Fun
		infinitymana = new DLexiconEntry(LibLexiconName.D_INFINITYMANA, categoryExtra);
		infinitymana.setIcon(new ItemStack(vazkii.botania.common.block.ModBlocks.pool));
		//Relics
		
		maxwelldemon = new LLexiconEntry(LibLexiconName.R_MAXWELLDEMON, categoryExtra);
		maxwelldemon.setIcon(new ItemStack(ModItems.maxwelldemon));
		maxwelldemon.setLexiconPages(new PageText("0"));
	
		excaliber = new LLexiconEntry(LibLexiconName.R_EXCALIBER, categoryExtra);
		excaliber.setIcon(new ItemStack(ModItems.excaliber));
		excaliber.setLexiconPages(new PageText("0"));
		
		eternalslience = new LLexiconEntry(LibLexiconName.R_ETERNALSLIENCE, categoryExtra);
		eternalslience.setIcon(new ItemStack(ModItems.eternalslience));
		eternalslience.setLexiconPages(new PageText("0"));
		
		hermestravelwand = new LLexiconEntry(LibLexiconName.R_HERMESTRAVELWAND, categoryExtra);
		hermestravelwand.setIcon(new ItemStack(ModItems.hermeswand));
		hermestravelwand.setLexiconPages(new PageText("0"));
		
		valkyriecombatsuit = new LLexiconEntry(LibLexiconName.R_VALKYRIECOMBATSUIT, categoryExtra);
		valkyriecombatsuit.setIcon(new ItemStack(ModItems.valkyriecombatuniform));
		valkyriecombatsuit.setLexiconPages(new PageText("0"));
		
		gaia3 = new ELexiconEntry(LibLexiconName.R_GAIAIII, categoryExtra);
		gaia3.setIcon(new ItemStack(Item.getItemFromBlock(vazkii.botania.common.block.ModBlocks.pylon), 1, 2));
		gaia3.setLexiconPages(new PageText("0"), new PageText("1"), new PageMultiblock("3", ModMultiBlocks.gaia), new PageText("2"));
		gaia3.setPriority();
	}
}
