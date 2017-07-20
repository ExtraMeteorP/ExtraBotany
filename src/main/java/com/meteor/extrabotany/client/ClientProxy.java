package com.meteor.extrabotany.client;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.common.MinecraftForge;

import com.meteor.extrabotany.client.gui.GuiDrop;
import com.meteor.extrabotany.client.render.RenderShield;
import com.meteor.extrabotany.client.render.block.RenderGaiaChest;
import com.meteor.extrabotany.client.render.entity.RenderGaiaIII;
import com.meteor.extrabotany.client.render.entity.RenderGaiaIIIDark;
import com.meteor.extrabotany.client.render.entity.RenderGaiaIIIPhantom;
import com.meteor.extrabotany.client.render.entity.RenderLycorisradiataGreen;
import com.meteor.extrabotany.client.render.entity.RenderLycorisradiataPurple;
import com.meteor.extrabotany.client.render.entity.RenderLycorisradiataRed;
import com.meteor.extrabotany.client.render.entity.RenderSpear;
import com.meteor.extrabotany.client.render.entity.RenderTeleportPearl;
import com.meteor.extrabotany.client.render.tile.RenderTileGaiaChest;
import com.meteor.extrabotany.client.render.tile.RenderTileRelicPlate;
import com.meteor.extrabotany.common.CommonProxy;
import com.meteor.extrabotany.common.block.tile.TileGaiaChest;
import com.meteor.extrabotany.common.block.tile.TileRelicPlate;
import com.meteor.extrabotany.common.core.handler.ConfigHandler;
import com.meteor.extrabotany.common.core.version.UpdateChecker;
import com.meteor.extrabotany.common.entity.EntityItemUnbreakable;
import com.meteor.extrabotany.common.entity.EntityLycorisradiataGreen;
import com.meteor.extrabotany.common.entity.EntityLycorisradiataPurple;
import com.meteor.extrabotany.common.entity.EntityLycorisradiataRed;
import com.meteor.extrabotany.common.entity.EntitySpear;
import com.meteor.extrabotany.common.entity.EntityTeleportPearl;
import com.meteor.extrabotany.common.entity.gaia.EntityGaiaIII;
import com.meteor.extrabotany.common.entity.gaia.EntityGaiaIIIDark;
import com.meteor.extrabotany.common.entity.gaia.EntityGaiaIIIPhantom;
import com.meteor.extrabotany.common.integration.Intergration;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		Intergration.preInitClient(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		initRenderers();
		initEntities();
		new UpdateChecker().init();;
		Intergration.initClient(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		Intergration.postInitClient(event);
	}
	private void initEntities(){
		RenderingRegistry.registerEntityRenderingHandler(EntityItemUnbreakable.class, new RenderItem());	
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaIIIPhantom.class, new RenderGaiaIIIPhantom());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaIIIDark.class, new RenderGaiaIIIDark());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaIII.class, new RenderGaiaIII());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, new RenderSpear());
		RenderingRegistry.registerEntityRenderingHandler(EntityLycorisradiataRed.class, new RenderLycorisradiataRed());
		RenderingRegistry.registerEntityRenderingHandler(EntityLycorisradiataGreen.class, new RenderLycorisradiataGreen());
		RenderingRegistry.registerEntityRenderingHandler(EntityLycorisradiataPurple.class, new RenderLycorisradiataPurple());
		RenderingRegistry.registerEntityRenderingHandler(EntityTeleportPearl.class, new RenderTeleportPearl(1.0F));
	}
	
	private void initRenderers() {
		if(ConfigHandler.disableShieldDisplay == false){
			MinecraftForge.EVENT_BUS.register(new RenderShield());
		    FMLCommonHandler.instance().bus().register(new RenderShield());	
		}
	    if(ConfigHandler.disableEasterEgg == false){
	    	MinecraftForge.EVENT_BUS.register(new GuiDrop());
	    	FMLCommonHandler.instance().bus().register(new GuiDrop());
	    }

	    RenderingRegistry.registerBlockHandler(new RenderGaiaChest());
	    
	    ClientRegistry.bindTileEntitySpecialRenderer(TileGaiaChest.class, new RenderTileGaiaChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileRelicPlate.class, new RenderTileRelicPlate());
	}

}
