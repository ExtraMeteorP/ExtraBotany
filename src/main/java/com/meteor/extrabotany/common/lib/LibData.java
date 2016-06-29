package com.meteor.extrabotany.common.lib;

import java.util.List;

import com.google.common.collect.Lists;
import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.api.extrabotany.handler.IDataHandler;
import com.meteor.extrabotany.common.util.ODHelper;
import com.valentin4311.candycraftmod.CandyCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class LibData {
	public static int getBlockTemperture(Block block){
		if(block instanceof IFluidBlock){
			IFluidBlock fluid = (IFluidBlock) block;
			return fluid.getFluid().getTemperature();
		}else if(block == Blocks.lava){
			return 1300;
		}else if(block == Blocks.water){
			return 300;
		}else
			return 400;
	}
	
	static{
		
	}
	
    public static int getCandyBurnTime(ItemStack stack){
    	if (stack == null)
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            if(ExtraBotanyAPI.sweetTier6.contains(item) || ODHelper.isODendswith("cake", stack))
            	return 256;
            else if(ExtraBotanyAPI.sweetTier5.contains(item))
            	return 128;
            else if(ExtraBotanyAPI.sweetTier4.contains(item) || ODHelper.isODendswith("pie", stack))
            	return 64;
            else if(ExtraBotanyAPI.sweetTier3.contains(item) || ODHelper.isODendswith("yogurt", stack) || ODHelper.isODendswith("soda", stack) || ODHelper.isODendswith("icecream", stack))
            	return 32;
            else if(ExtraBotanyAPI.sweetTier2.contains(item) || ODHelper.isODendswith("juice", stack) || ODHelper.isODendswith("smoothie", stack) || ODHelper.isODendswith("jelly", stack))
            	return 16;
            else if(ExtraBotanyAPI.sweetTier1.contains(item))
            	return 8;
            else return 0;
        
		}
	
    }
    
    public static int getBookBurnTime(ItemStack stack){
    	if (stack == null)
        {
            return 0;
        }
        else
        {	
        	Item item = stack.getItem();
        	if (item == Items.book) return 25;
        	if (item == Items.written_book) return 35;
        }
    	return LibRegistry.getFuelValue(stack);	
    }
}
