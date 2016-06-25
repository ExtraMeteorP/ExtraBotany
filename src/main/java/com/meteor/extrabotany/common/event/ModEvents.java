package com.meteor.extrabotany.common.event;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;

public class ModEvents {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new EventKnowledgeTypeUnlock());
	    MinecraftForge.EVENT_BUS.register(new EventPunish());
		MinecraftForge.EVENT_BUS.register(new EventHighDamageResistance());
		MinecraftForge.EVENT_BUS.register(new EventShield());
		MinecraftForge.EVENT_BUS.register(new EventBulletGold());
		MinecraftForge.EVENT_BUS.register(new EventUnbreakable());
	    MinecraftForge.EVENT_BUS.register(new EventGaiaIII());
	    MinecraftForge.EVENT_BUS.register(new EventElven());
	    MinecraftForge.EVENT_BUS.register(new EventAchievement());
	    MinecraftForge.EVENT_BUS.register(new EventMobDrop());
	}
}
