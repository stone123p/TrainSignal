package com.hzy.trainsignal.tileentity;

import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySignalControllerBox extends TileEntity {

	public int default_signal=0;
	public int redstone_signal=0;
	public String ID="1";
	public boolean isTurnOn=false;
	
	public int emitSignal() {
		return isTurnOn?redstone_signal:default_signal;
	}

	public int getDefaultSignal() {
		return this.default_signal;
	}
	public int getRedstoneSignal() {
		return this.redstone_signal;
	}
	public void setDefaultSignal(int s) {
		 this.default_signal=s;
	}
	public void setRedstoneSignal(int s) {
		 this.redstone_signal=s;
	}

}
