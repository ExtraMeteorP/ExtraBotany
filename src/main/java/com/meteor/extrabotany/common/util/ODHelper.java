package com.meteor.extrabotany.common.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ODHelper {
	
	public static boolean isOreDict(String oredict, ItemStack stack){
    	for(ItemStack ostack:OreDictionary.getOres(oredict)){
    		ItemStack cstack = ostack.copy();
    		if(stack.isItemEqual(cstack))
    			return true;
    	}
    	return false;
    }
    
    public static boolean isODendswith(String oredict, ItemStack stack){
    	String[] od = OreDictionary.getOreNames();
    	for(int i = 0; i < od.length; i++){
    		String ood = od[i];
    		if(ood.endsWith(oredict)){
	    		for(ItemStack ostack:OreDictionary.getOres(ood)){
	        		ItemStack cstack = ostack.copy();
	        		if(stack.isItemEqual(cstack))
	        			return true;
	    		}
    		}
    	}
    	return false;
    }
    
    public static boolean isODstartswith(String oredict, ItemStack stack){
    	String[] od = OreDictionary.getOreNames();
    	for(int i = 0; i < od.length; i++){
    		String ood = od[i];
    		if(ood.startsWith(oredict)){
	    		for(ItemStack ostack:OreDictionary.getOres(ood)){
	        		ItemStack cstack = ostack.copy();
	        		if(stack.isItemEqual(cstack))
	        			return true;
	    		}
    		}
    	}
    	return false;
    }
    
}
