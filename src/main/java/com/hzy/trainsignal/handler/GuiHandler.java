package com.hzy.trainsignal.handler;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.container.ContainerSignalControllerBox;
import com.hzy.trainsignal.container.ContainerSignalReceiveBox;
import com.hzy.trainsignal.gui.GuiSignalControllerBox;
import com.hzy.trainsignal.gui.GuiSignalReceiveBox;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;
import com.hzy.trainsignal.tileentity.TileEntitySignalReceiveBox;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
	public GuiHandler(){
		NetworkRegistry.INSTANCE.registerGuiHandler(TrainSignal.instance, this);
	}
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity=world.getTileEntity(x, y, z);
		if(entity != null){
			switch(ID){
				case TrainSignal.Controller_BOX_GUIID:{
					if(entity instanceof TileEntitySignalControllerBox ){
						return new ContainerSignalControllerBox(player.inventory,(TileEntitySignalControllerBox ) entity);
					}
					break;
				}	
				case TrainSignal.Receive_BOX_GUIID:{
					if(entity instanceof TileEntitySignalReceiveBox ){
						return new ContainerSignalReceiveBox(player.inventory,(TileEntitySignalReceiveBox) entity);
					}
					break;
				}	
				
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity=world.getTileEntity(x, y, z);
		if(entity != null){
			switch(ID){
				case TrainSignal.Controller_BOX_GUIID:{
					if(entity instanceof TileEntitySignalControllerBox ){
						return new GuiSignalControllerBox(player.inventory,(TileEntitySignalControllerBox ) entity);
					}
					break;
				}
				case TrainSignal.Receive_BOX_GUIID:{
					if(entity instanceof TileEntitySignalReceiveBox ){
						return new GuiSignalReceiveBox(player.inventory,(TileEntitySignalReceiveBox ) entity);
					}
					break;
				}
				
			}
		}
		return null;
	}

}
