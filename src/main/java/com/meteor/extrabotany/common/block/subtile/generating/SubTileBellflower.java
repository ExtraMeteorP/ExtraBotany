package com.meteor.extrabotany.common.block.subtile.generating;

import java.util.Random;

import com.meteor.extrabotany.common.core.handler.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileGenerating;

public class SubTileBellflower extends SubTileGenerating{
	
	private static final int RANGE = 4;
	private static final int DELAY = 15;
	private static int blockCount;
	
	@Override
	public int getColor() {
		return 0xF1F391;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		World world = supertile.getWorldObj();
		Random rand = new Random();
		int x = supertile.xCoord;
		int y = supertile.yCoord;
		int z = supertile.zCoord;
		if(mana < getMaxMana() && y > 100){
			
			float canSeeSky = world.canBlockSeeTheSky(x,y,z) ? 1F : 0.4F;
			
			int windpower = 1;
			if(ticksExisted % 400 == 0)
				windpower = world.rand.nextInt(6) + rand.nextInt(5) + 1;
			
			float buff = y/100;
			
			float block = this.blockCount/5;
			
			int eff = (int) (ConfigHandler.efficiencyBellflower + windpower * buff * canSeeSky * 0.9F - block);
			
			if(ticksExisted % DELAY == 0){
				updateObscuratedBlockCount();
				mana += eff;			
			}		
		}	
	}
	
	public void updateObscuratedBlockCount(){
		this.blockCount = 0;
		for (int x = -RANGE; x < RANGE + 1; x++)
			for (int y = -RANGE; y < RANGE + 1; y++)
				for (int z = -RANGE; z < RANGE + 1; z++)
					if (!supertile.getWorldObj().isAirBlock(x + supertile.xCoord, y + supertile.yCoord, z + supertile.zCoord))
						this.blockCount += 1;
	}
	
	@Override
	public int getDelayBetweenPassiveGeneration() {
		return 10;
	}
	
	@Override
	public RadiusDescriptor getRadius() {
		return new RadiusDescriptor.Square(toChunkCoordinates(), RANGE);
	}
	
	@Override
	public int getMaxMana() {
		return 200;
	}

}
