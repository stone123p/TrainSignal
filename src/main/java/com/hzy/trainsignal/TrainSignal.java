package com.hzy.trainsignal;



import com.hzy.trainsignal.blocks.TSBlocks;
import com.hzy.trainsignal.handler.GuiHandler;
import com.hzy.trainsignal.handler.SignalControllerPacketerHandler;
import com.hzy.trainsignal.handler.SignalReceivePacketerHandler;
import com.hzy.trainsignal.items.TSItems;
import com.hzy.trainsignal.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Mod(modid = TrainSignal.MODID, version = TrainSignal.VERSION)
public class TrainSignal {
	public static final String MODID = "trainsignal";
	public static final String NAME = "TrainSignal";
    public static final String VERSION = "0.1";
    
    public static final int  Controller_BOX_GUIID = 0;
    public static final int  Receive_BOX_GUIID = 1;
    @Instance
    public static TrainSignal instance;
    
    @SidedProxy(clientSide="com.hzy.trainsignal.proxy.ClientProxy",serverSide="com.hzy.trainsignal.proxy.CommonProxy")
    public static CommonProxy nealeProxy;
    
    //seting Tab
  	public static CreativeTabs trainsignalTab = new CreativeTabs("trainsignalTab"){
  		@Override
  		public Item getTabIconItem() {
  			return Items.apple; 
  		}
  	};
    
    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
    	
    	TSBlocks.registerBlocks();
    	TSItems.registerItems();
    	new SignalControllerPacketerHandler().registerNetwork();
    	new SignalReceivePacketerHandler().registerNetwork();
    	new GuiHandler();
    	nealeProxy.registerRenders();
		nealeProxy.registerTileEntitys();
		
		
    }
}
