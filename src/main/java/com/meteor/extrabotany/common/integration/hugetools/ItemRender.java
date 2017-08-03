package com.meteor.extrabotany.common.integration.hugetools;

import net.minecraft.client.Minecraft;

import com.meteor.extrabotany.client.render.item.GunRenderer;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRender {
	public static void initHugeItemRender(){
		Minecraft mc = FMLClientHandler.instance().getClient();
		GunRenderer gunRenderer = new GunRenderer(mc.gameSettings, mc.getTextureManager());
	}
}
