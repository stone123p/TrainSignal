package com.hzy.trainsignal.proxy;

import com.hzy.trainsignal.renderer.RenderSignalControllerBox;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		TileEntitySpecialRenderer render1 = new RenderSignalControllerBox();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySignalControllerBox.class,render1); 	
	}
	public void registerTileEntitys() {
		GameRegistry.registerTileEntity(TileEntitySignalControllerBox.class, "TileEntitySignalControllerBox");
	}
}
