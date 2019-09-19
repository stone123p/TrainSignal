package com.hzy.trainsignal.proxy;

import com.hzy.trainsignal.tileentity.TileEntitySwitchBox;
import com.hzy.trainsignal.renderer.RenderTileEntityBrand;
import com.hzy.trainsignal.tileentity.TileEntityBrand;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;
import com.hzy.trainsignal.tileentity.TileEntitySignalReceiveBox;


import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		TileEntitySpecialRenderer render1 = new RenderTileEntityBrand();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrand.class,render1); 	
	}
	public void registerTileEntitys() {
		GameRegistry.registerTileEntity(TileEntitySignalControllerBox.class, "TileEntitySignalControllerBox");
		GameRegistry.registerTileEntity(TileEntitySignalReceiveBox.class, "TileEntitySignalReceiveBox");
		GameRegistry.registerTileEntity(TileEntitySwitchBox.class, "TileEntitySwitchBox");
		GameRegistry.registerTileEntity(TileEntityBrand.class,"TileEntityBrand");

	}
}
