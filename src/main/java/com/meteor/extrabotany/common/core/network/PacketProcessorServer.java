package com.meteor.extrabotany.common.core.network;

import com.meteor.extrabotany.common.core.util.LogHelper;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import io.netty.buffer.ByteBufInputStream;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.relauncher.Side;

public class PacketProcessorServer {
	
	@SubscribeEvent
	public void onServerPacketData(ServerCustomPacketEvent event){
		ByteBufInputStream bbis = new ByteBufInputStream(event.packet.payload());
		byte packetID = -1;
		try{
			if (event.packet.getTarget() != Side.SERVER){
				return;
			}

			//constant details all packets share:  ID, player, and remaining data
			packetID = bbis.readByte();
			NetHandlerPlayServer srv = (NetHandlerPlayServer)event.packet.handler();
			EntityPlayerMP player = srv.playerEntity;
			byte[] remaining = new byte[bbis.available()];
			bbis.readFully(remaining);

			switch (packetID){
			
			}
		}catch (Throwable t){
			LogHelper.error("Server Packet Failed to Handle!");
			LogHelper.error("Packet Type: " + packetID);
			t.printStackTrace();
		}finally{
			try{
				if (bbis != null)
					bbis.close();
			}catch (Throwable t){
				t.printStackTrace();
			}
		}
	}
	
}
