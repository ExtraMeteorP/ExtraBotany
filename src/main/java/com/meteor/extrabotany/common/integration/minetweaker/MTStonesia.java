package com.meteor.extrabotany.common.integration.minetweaker;

import java.util.LinkedList;
import java.util.List;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.api.extrabotany.recipe.RecipeStonesia;
import com.meteor.extrabotany.common.core.util.LogHelper;
import com.meteor.extrabotany.common.integration.minetweaker.utils.BaseListAddition;
import com.meteor.extrabotany.common.integration.minetweaker.utils.BaseListRemoval;
import com.meteor.extrabotany.common.integration.minetweaker.utils.InputHelper;
import com.meteor.extrabotany.common.integration.minetweaker.utils.StackHelper;

@ZenClass("mods.ExtraBotany.Stonesia")
public class MTStonesia {
	
	public static final String name = "ExtraBotany Stonesia";
	
	@ZenMethod
    public static void addRecipe(IIngredient blockInput, int burntime) {
        if(blockInput == null || burntime == 0) {
            LogHelper.error(String.format("Required parameters missing for %s Recipe.", name));
            return;
        }
        
        Object input = InputHelper.toObject(blockInput);
        
        if(input == null || (input instanceof ItemStack && !InputHelper.isABlock((ItemStack)input))) {
            LogHelper.error(String.format("Input must be a block or an oredict entry."));
            return;
        }
        
        if(input instanceof ItemStack) input = Block.getBlockFromItem(((ItemStack)input).getItem());
        
        RecipeStonesia recipe = new RecipeStonesia(input, burntime);
        
        MineTweakerAPI.apply(new Add(recipe));
    }
    
    private static class Add extends BaseListAddition<RecipeStonesia> {
        public Add(RecipeStonesia recipe) {
            super(MTStonesia.name, ExtraBotanyAPI.stonesiaRecipes);
            recipes.add(recipe);
        }
        
        @Override
        protected String getRecipeInfo(RecipeStonesia recipe) {
            return "";
        }
    }
    
    @ZenMethod
    public static void removeRecipe(IIngredient input) {
        List<RecipeStonesia> recipes = new LinkedList<RecipeStonesia>();
        
        for(RecipeStonesia recipe : ExtraBotanyAPI.stonesiaRecipes) {
            if(recipe.getInput() instanceof String){
            	for(ItemStack ostack : OreDictionary.getOres((String) recipe.getInput())){
            		IItemStack in = InputHelper.toIItemStack(ostack);
		            if(StackHelper.matches(input, in)) {
		                recipes.add(recipe);
		            }
            	}
            }else if(recipe.getInput() instanceof Block){
            	IItemStack in = InputHelper.toIItemStack(new ItemStack((Block) recipe.getInput()));
            	if(StackHelper.matches(input, in)) {
	                recipes.add(recipe);
	            }
            }
        }
        
        if(!recipes.isEmpty()) {
            MineTweakerAPI.apply(new Remove(recipes));
        } else {
            
        }
    }
    
    private static class Remove extends BaseListRemoval<RecipeStonesia> {
        public Remove(List<RecipeStonesia> recipes) {
            super(MTStonesia.name, ExtraBotanyAPI.stonesiaRecipes, recipes);
        }
        
        @Override
        protected String getRecipeInfo(RecipeStonesia recipe) {
            return "";
        }
    }

}
