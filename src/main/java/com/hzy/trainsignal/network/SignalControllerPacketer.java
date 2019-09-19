package com.hzy.trainsignal.network;

import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class SignalControllerPacketer implements IMessage {
	public int x;
	public int y;
	public int z;
	public int default_signal;
	public int redstone_signal;
	public SignalControllerPacketer() {
		
	}
	public SignalControllerPacketer(TileEntitySignalControllerBox entity) {
		x = entity.xCoord;
		y = entity.yCoord;
		z = entity.zCoord;
		default_signal = entity.default_signal;
		redstone_signal = entity.redstone_signal;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		default_signal = buf.readInt();
		redstone_signal = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);		
		buf.writeInt(default_signal);
		buf.writeInt(redstone_signal);
	}

}
