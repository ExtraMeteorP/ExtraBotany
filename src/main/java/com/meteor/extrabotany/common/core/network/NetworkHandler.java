package com.meteor.extrabotany.common.core.network;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayerMP;

import com.meteor.extrabotany.common.core.util.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler {
	
	private static final String ChannelLabel = "ExtraBotanyDataTunnel";
	private static FMLEventChannel Channel;

	private boolean registeredChannels = false;

	private NetworkHandler(){

	}

	public static final NetworkHandler INSTANCE = new NetworkHandler();

	public void init(){
		Channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(ChannelLabel);
	}

	public void registerChannels(PacketProcessorServer proc){
		if (!registeredChannels){
			registeredChannels = true;
			Channel.register(proc);
			FMLCommonHandler.instance().bus().register(proc);
		}else{
			LogHelper.info("Redundant call to register channels.");
		}
	}

	public void sendPacketToClientPlayer(EntityPlayerMP player, byte packetID, byte[] data){

		//first byte is ID, followed by data
		byte[] pkt_data = new byte[data.length + 1];
		pkt_data[0] = packetID;

		//copy the data
		for (int i = 0; i < data.length; ++i){
			pkt_data[i + 1] = data[i];
		}

		FMLProxyPacket packet = new FMLProxyPacket(Unpooled.copiedBuffer(pkt_data), ChannelLabel);
		packet.setTarget(Side.CLIENT);
		Channel.sendTo(packet, player);
	}

	public void sendPacketToServer(byte packetID, byte[] data){
		byte[] pkt_data = new byte[data.length + 1];
		//first byte is ID
		pkt_data[0] = packetID;

		//copy the data
		for (int i = 0; i < data.length; ++i){
			pkt_data[i + 1] = data[i];
		}

		FMLProxyPacket packet = new FMLProxyPacket(Unpooled.copiedBuffer(pkt_data), ChannelLabel);
		packet.setTarget(Side.SERVER);
		Channel.sendToServer(packet);
	}

	public void sendPacketToAllClientsNear(int dimension, double ox, double oy, double oz, double radius, byte packetID, byte[] data){
		//first byte is ID, followed by data
		byte[] pkt_data = new byte[data.length + 1];
		pkt_data[0] = packetID;

		//copy the data
		for (int i = 0; i < data.length; ++i){
			pkt_data[i + 1] = data[i];
		}

		FMLProxyPacket packet = new FMLProxyPacket(Unpooled.copiedBuffer(pkt_data), ChannelLabel);
		packet.setTarget(Side.CLIENT);
		Channel.sendToAllAround(packet, new TargetPoint(dimension, ox, oy, oz, radius));
	}
	
}
