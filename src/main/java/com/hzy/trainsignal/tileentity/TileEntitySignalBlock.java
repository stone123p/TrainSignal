package com.hzy.trainsignal.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntitySignalBlock extends TileEntity {

	public int meta=0;
	public float face=0;

	public TileEntitySignalBlock(int m) {
		this.meta=m;
	}

}