package com.hzy.trainsignal.handler;

import com.hzy.trainsignal.network.SignalReceivePacketer;
import com.hzy.trainsignal.tileentity.TileEntitySignalReceiveBox;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.tileentity.TileEntity;

public class SignalReceivePacketerHandler implements IMessageHandler<SignalReceivePacketer, IMessage> {
	public static SimpleNetworkWrapper network=NetworkRegistry.INSTANCE.newSimpleChannel("SignalReceiveChannel");
	public SignalReceivePacketerHandler() {
	
	}
	public void registerNetwork() {
		this.network.registerMessage(SignalReceivePacketerHandler.class, SignalReceivePacketer.class, 0, Side.SERVER);
	}
	
	@Override
	public IMessage onMessage(SignalReceivePacketer message, MessageContext ctx) {
		TileEntity tile = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
		if(tile instanceof TileEntitySignalReceiveBox){
			TileEntitySignalReceiveBox modifier =  (TileEntitySignalReceiveBox)tile;
			modifier.setActions(new byte[]{message.ac0,message.ac1,message.ac2,message.ac3,message.ac4,message.ac5,message.ac6,message.ac7,message.ac8,message.ac9});
			ctx.getServerHandler().playerEntity.worldObj.markBlockForUpdate(message.x, message.y, message.z);
		}
		return null;
	} 

}
