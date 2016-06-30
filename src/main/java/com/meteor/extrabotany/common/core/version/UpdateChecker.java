package com.meteor.extrabotany.common.core.version;

import com.meteor.extrabotany.common.lib.LibReference;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

public class UpdateChecker {
	
	public static int MESSAGE = 3;

	public static boolean doneChecking = false;
	public static String onlineVersion = "";
	public static boolean triedToWarnPlayer = false;

	public static boolean startedDownload = false;
	public static boolean downloadedFile = false;

	public void init() {
		new ThreadUpdateChecker();
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onTick(ClientTickEvent event) {
		if(doneChecking && event.phase == Phase.END && Minecraft.getMinecraft().thePlayer != null && !triedToWarnPlayer) {
			if(!onlineVersion.isEmpty()) {
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				int onlineBuild = Integer.parseInt(onlineVersion.split("-")[1]);
				int clientBuild = LibReference.VER;
				if(onlineBuild > clientBuild) {
					player.addChatComponentMessage(new ChatComponentTranslation("extrabotany.versioning.message" + player.worldObj.rand.nextInt(MESSAGE)));
					player.addChatComponentMessage(new ChatComponentTranslation("extrabotany.versioning.outdated", clientBuild, onlineBuild));

					IChatComponent component = IChatComponent.Serializer.func_150699_a(StatCollector.translateToLocal("extrabotany.versioning.updateMessage").replaceAll("%version%", onlineVersion));
					player.addChatComponentMessage(component);
				}
			}

			triedToWarnPlayer = true;
		}
	}
}
