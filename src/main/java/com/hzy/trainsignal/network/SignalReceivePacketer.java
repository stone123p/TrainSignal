package com.hzy.trainsignal.network;

import com.hzy.trainsignal.tileentity.TileEntitySignalReceiveBox;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class SignalReceivePacketer implements IMessage {
	public int x;
	public int y;
	public int z;
	public boolean[] actions_signal=new boolean[10];
	public byte ac0,ac1,ac2,ac3,ac4,ac5,ac6,ac7,ac8,ac9;
	public SignalReceivePacketer() {
		
	}
	public SignalReceivePacketer(TileEntitySignalReceiveBox entity) {
		x = entity.xCoord;
		y = entity.yCoord;
		z = entity.zCoord;
		ac0 = entity.actions_signal[0];
		ac1 = entity.actions_signal[1];
		ac2 = entity.actions_signal[2];
		ac3 = entity.actions_signal[3];
		ac4 = entity.actions_signal[4];
		ac5 = entity.actions_signal[5];
		ac6 = entity.actions_signal[6];
		ac7 = entity.actions_signal[7];
		ac8 = entity.actions_signal[8];
		ac9 = entity.actions_signal[9];
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		ac0 = buf.readByte();
		ac1 = buf.readByte();
		ac2 = buf.readByte();
		ac3 = buf.readByte();
		ac4 = buf.readByte();
		ac5 = buf.readByte();
		ac6 = buf.readByte();
		ac7 = buf.readByte();
		ac8 = buf.readByte();
		ac9 = buf.readByte();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);		
		buf.writeByte(ac0);
		buf.writeByte(ac1);
		buf.writeByte(ac2);
		buf.writeByte(ac3);
		buf.writeByte(ac4);
		buf.writeByte(ac5);
		buf.writeByte(ac6);
		buf.writeByte(ac7);
		buf.writeByte(ac8);
		buf.writeByte(ac9);

	}

}
