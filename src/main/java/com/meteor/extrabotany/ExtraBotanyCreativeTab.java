package com.meteor.extrabotany;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.meteor.extrabotany.common.block.ModBlocks;
import com.meteor.extrabotany.common.item.ModItems;
import com.meteor.extrabotany.common.lib.LibReference;

public class ExtraBotanyCreativeTab extends CreativeTabs{
	List list;
	
	public ExtraBotanyCreativeTab() {
		super(LibReference.MOD_ID);
		setNoTitle();
		setBackgroundImageName(LibReference.GUI_CREATIVE);
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ModItems.boxs);
	}

	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
	@Override
	public void displayAllReleventItems(List list) {
		this.list = list;
		addItem(ModItems.SGBee);
		addItem(ModItems.SGGaia);
		addItem(ModItems.SGEnhanced);
		addItem(ModItems.SGMini);
		addItem(ModItems.SGQuick);
		//Flowers
		addBlock(ModBlocks.specialFlower);
		//Mana Using Item
		addItem(ModItems.manapotato);
		addItem(ModItems.gaiatablet);
		addItem(ModItems.teleportpearl);
		addItem(ModItems.angelwand);
		addItem(ModItems.reader);
		//Relics
		addItem(ModItems.maxwelldemon);
		addItem(ModItems.excaliber);
		addItem(ModItems.hermeswand);
		addItem(ModItems.eternalslience);
		addItem(ModItems.valkyriecombatuniform);
		//Test
		addItem(ModItems.itemtest);
		//Basic
		addItem(ModItems.material);
		addItem(ModItems.key);
		addItem(ModItems.boxs);
		addItem(ModItems.dungeonbox);
		//Spawn Card
		addItem(ModItems.lycorisgreen);
		addItem(ModItems.lycorispurple);
		addItem(ModItems.lycorisred);
		addItem(ModItems.lycorisrandom);		
		//Blocks
		addBlock(ModBlocks.gaiaquartz);
		addBlock(ModBlocks.gaiaquartzstairs);
		addBlock(ModBlocks.gaiaquartzslab);
		addBlock(ModBlocks.elvenquartz);
		addBlock(ModBlocks.elvenquartzstairs);
		addBlock(ModBlocks.elvenquartzslab);
		addBlock(ModBlocks.gaiachest);
		//Baubles
		addItem(ModItems.dog);
		addItem(ModItems.gaiawise);

		addItem(ModItems.scissorpurple);
		addItem(ModItems.scissorred);
		addItem(ModItems.heliacalclaymore);
		//Others
		addItem(ModItems.recordA);
		addItem(ModItems.recordB);
		addItem(ModItems.recordC);
	}
	
	private void addItem(Item item) {
		item.getSubItems(item, this, list);
	}

	private void addBlock(Block block) {
		ItemStack stack = new ItemStack(block);
		block.getSubBlocks(stack.getItem(), this, list);
	}

	private void addStack(ItemStack stack) {
		list.add(stack);
	}

}
