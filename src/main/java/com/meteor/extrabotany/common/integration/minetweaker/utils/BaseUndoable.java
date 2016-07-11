package com.meteor.extrabotany.common.integration.minetweaker.utils;

import minetweaker.IUndoableAction;

public abstract class BaseUndoable implements IUndoableAction {

	protected final String name;

	protected boolean success = false;

	protected BaseUndoable(String name) {
	    this.name = name;
	}
	
	protected String getRecipeInfo() {
	    return "Unknown item";
	}
	
	@Override
	public boolean canUndo() {
	    return success;
	}
	
	@Override
	public String describe() {
	    return String.format("[ModTweaker2] Altering %s Recipe(s) for %s", this.name, this.getRecipeInfo());
	}
	
    @Override
    public String describeUndo() {
        return String.format("[ModTweaker2] Reverting %s Recipe(s) changes for %s", this.name, this.getRecipeInfo());
    }
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
	        return false;
	    
	    if(!(obj instanceof BaseUndoable)) {
	        return false;
	    }
	    
	    BaseUndoable u = (BaseUndoable)obj;
	    
	    if(!name.equals(u.name))
	        return false;
	    
	    return true;
	}
	
	@Override
	public int hashCode() {
	    return name.hashCode();
	}
	
    @Override
    public Object getOverrideKey() {
        return null;
    }
}
