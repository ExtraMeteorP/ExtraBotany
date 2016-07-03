package com.meteor.extrabotany.common.core.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.meteor.extrabotany.common.core.util.LogHelper;

import cpw.mods.fml.common.network.ByteBufUtils;

public class DataReader {
	
	ByteArrayInputStream input;
	DataInputStream dataStream;
	public byte ID;

	public DataReader(byte[] data){
		this(data, true);
	}

	public DataReader(byte[] data, boolean getID){
		input = new ByteArrayInputStream(data);
		dataStream = new DataInputStream(input);

		//get id byte
		if (getID){
			try{
				ID = dataStream.readByte();
			}catch (IOException e){
				LogHelper.error("ExtraBotanyDataReader (getID): " + e.toString());
				e.printStackTrace();
			}
		}
	}

	public int getInt(){
		int value = 0;
		try{
			value = dataStream.readInt();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getInt): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public float getFloat(){
		float value = 0;
		try{
			value = dataStream.readFloat();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getFloat): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public double getDouble(){
		double value = 0;
		try{
			value = dataStream.readDouble();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getDouble): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public boolean getBoolean(){
		boolean value = false;
		try{
			value = dataStream.readBoolean();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getBoolean): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public String getString(){
		String value = "";
		try{
			value = dataStream.readUTF();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getString): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public byte getByte(){
		byte value = 0;
		try{
			value = dataStream.readByte();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getByte): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public short getShort(){
		short value = 0;
		try{
			value = dataStream.readShort();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getShort): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public long getLong(){
		long value = 0;
		try{
			value = dataStream.readLong();
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getLong): " + e.toString());
			e.printStackTrace();
		}
		return value;
	}

	public NBTTagCompound getNBTTagCompound(){
		NBTTagCompound data = null;
		try{
			int len = dataStream.readInt();
			byte[] bytes = new byte[len];
			dataStream.read(bytes);
			ByteBuf buf = Unpooled.copiedBuffer(bytes);
			data = ByteBufUtils.readTag(buf);
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getNBTTagCompound): " + e.toString());
			e.printStackTrace();
		}
		return data;
	}

	public byte[] getRemainingBytes(){
		byte[] remaining = null;
		try{
			remaining = new byte[dataStream.available()];
			dataStream.read(remaining);
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getRemainingBytes): " + e.toString());
			e.printStackTrace();
		}

		return remaining;
	}

	public ItemStack getItemStack(){
		NBTTagCompound compound = getNBTTagCompound();
		if (compound == null) return null;
		ItemStack stack = ItemStack.loadItemStackFromNBT(compound);
		return stack;
	}

	public int[] getIntArray(){
		try{
			int[] arr = new int[dataStream.readInt()];
			for (int i = 0; i < arr.length; ++i)
				arr[i] = dataStream.readInt();
			return arr;
		}catch (IOException e){
			LogHelper.error("ExtraBotanyDataReader (getIntArray): " + e.toString());
			e.printStackTrace();
		}

		return new int[0];
	}
}
