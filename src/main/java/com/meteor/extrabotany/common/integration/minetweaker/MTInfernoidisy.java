package com.meteor.extrabotany.common.integration.minetweaker;

import java.util.LinkedList;
import java.util.List;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.api.extrabotany.recipe.RecipeInfernoidisy;
import com.meteor.extrabotany.common.core.util.LogHelper;
import com.meteor.extrabotany.common.integration.minetweaker.utils.BaseListAddition;
import com.meteor.extrabotany.common.integration.minetweaker.utils.BaseListRemoval;
import com.meteor.extrabotany.common.integration.minetweaker.utils.InputHelper;
import com.meteor.extrabotany.common.integration.minetweaker.utils.StackHelper;

@ZenClass("mods.ExtraBotany.Infernoidisy")
public class MTInfernoidisy {
	
	public static final String name = "ExtraBotany Infernoidisy";

	@ZenMethod
    public static void addRecipe(IIngredient blockInput, IItemStack blockOutput) {
        if(blockInput == null || blockOutput == null) {
            LogHelper.error(String.format("Required parameters missing for %s Recipe.", name));
            return;
        }
        
        Object input = InputHelper.toObject(blockInput);
        
        if(input == null || (input instanceof ItemStack && !InputHelper.isABlock((ItemStack)input))) {
            LogHelper.error(String.format("Input must be a block or an oredict entry."));
            return;
        }
        
        if(input instanceof ItemStack) input = Block.getBlockFromItem(((ItemStack)input).getItem());
        ItemStack output = InputHelper.toStack(blockOutput);
        
        RecipeInfernoidisy recipe = new RecipeInfernoidisy(input, Block.getBlockFromItem(output.getItem()), output.getItemDamage());
        
        MineTweakerAPI.apply(new Add(recipe));
    }
    
    private static class Add extends BaseListAddition<RecipeInfernoidisy> {
        public Add(RecipeInfernoidisy recipe) {
            super(MTInfernoidisy.name, ExtraBotanyAPI.infernoidisyRecipes);
            recipes.add(recipe);
        }
        
        @Override
        protected String getRecipeInfo(RecipeInfernoidisy recipe) {
            return "";
        }
    }
    
    @ZenMethod
    public static void removeRecipe(IIngredient output) {
        List<RecipeInfernoidisy> recipes = new LinkedList<RecipeInfernoidisy>();
        
        for(RecipeInfernoidisy recipe : ExtraBotanyAPI.infernoidisyRecipes) {
            IItemStack out = InputHelper.toIItemStack(new ItemStack(recipe.getOutput(), 1, recipe.getOutputMeta()));
            
            if(StackHelper.matches(output, out)) {
                recipes.add(recipe);
            }
        }
        
        if(!recipes.isEmpty()) {
            MineTweakerAPI.apply(new Remove(recipes));
        } else {
            
        }
    }
    
    private static class Remove extends BaseListRemoval<RecipeInfernoidisy> {
        public Remove(List<RecipeInfernoidisy> recipes) {
            super(MTInfernoidisy.name, ExtraBotanyAPI.infernoidisyRecipes, recipes);
        }
        
        @Override
        protected String getRecipeInfo(RecipeInfernoidisy recipe) {
            return "";
        }
    }

}
