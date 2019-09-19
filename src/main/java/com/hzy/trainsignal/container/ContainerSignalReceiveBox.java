package com.hzy.trainsignal.container;

import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;
import com.hzy.trainsignal.tileentity.TileEntitySignalReceiveBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerSignalReceiveBox extends Container {

	public ContainerSignalReceiveBox(InventoryPlayer inventory, TileEntitySignalReceiveBox entity) {
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

}
