package com.hzy.trainsignal.container;

import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerSignalControllerBox extends Container {

	public ContainerSignalControllerBox(InventoryPlayer inventory, TileEntitySignalControllerBox entity) {
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

}
