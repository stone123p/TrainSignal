package com.hzy.trainsignal.handler;

import com.hzy.trainsignal.network.SignalControllerPacketer;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.tileentity.TileEntity;

public class SignalControllerPacketerHandler implements IMessageHandler<SignalControllerPacketer, IMessage> {
	public static SimpleNetworkWrapper network=NetworkRegistry.INSTANCE.newSimpleChannel("SignalControllerChannel");
	public SignalControllerPacketerHandler() {
	
	}
	public void registerNetwork() {
		this.network.registerMessage(SignalControllerPacketerHandler.class, SignalControllerPacketer.class, 0, Side.SERVER);
	}
	
	@Override
	public IMessage onMessage(SignalControllerPacketer message, MessageContext ctx) {
		TileEntity tile = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
		if(tile instanceof TileEntitySignalControllerBox){
			TileEntitySignalControllerBox modifier =  (TileEntitySignalControllerBox)tile;
			modifier.setDefaultSignal(message.default_signal);
			modifier.setRedstoneSignal(message.redstone_signal);
			ctx.getServerHandler().playerEntity.worldObj.markBlockForUpdate(message.x, message.y, message.z);
		}
		return null;
	} 

}
