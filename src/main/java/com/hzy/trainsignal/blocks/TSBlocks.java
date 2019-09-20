package com.hzy.trainsignal.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TSBlocks {
	
	public TSBlocks() {
		
	}

	public static Block SignalControllerBox = new SignalControllerBox(Material.rock);
	public static Block SignalReceiveBox = new SignalReceiveBox(Material.rock);
	public static Block SignalSwitchBox = new SignalSwitchBox(Material.rock);
	public static Block Brand1 = new Brand(Material.rock,"rrs1",1);
	public static Block Brand2 = new Brand(Material.rock,"rrs2",2);
	public static Block Brand3 = new Brand(Material.rock,"rrs3",3);
	public static Block Brand4 = new Brand(Material.rock,"rrs4",4);
	public static Block Brand5 = new Brand(Material.rock,"rrs5",5);
	public static Block Brand6 = new Brand(Material.rock,"rrs6",6);
	public static Block SignalBlock1 = new SignalBlock(Material.rock,"SignalBlock_1",1);
	public static Block SignalBlock2 = new SignalBlock(Material.rock,"SignalBlock_2",2);
	public static Block SignalBlock3 = new SignalBlock(Material.rock,"SignalBlock_3",3);
	public static Block SignalBlock4 = new SignalBlock(Material.rock,"SignalBlock_4",4);
	public static Block SignalBlock5 = new SignalBlock(Material.rock,"SignalBlock_5",5);
	public static Block SignalBlock6 = new SignalBlock(Material.rock,"SignalBlock_6",6);
	public static Block SignalBlock7 = new SignalBlock(Material.rock,"SignalBlock_7",7);
	public static Block SignalBlock8 = new SignalBlock(Material.rock,"SignalBlock_8",8);
	public static Block SignalBlock9 = new SignalBlock(Material.rock,"SignalBlock_9",9);


	public static void registerBlocks() {
		registerBlock(SignalControllerBox);
		registerBlock(SignalReceiveBox);
		registerBlock(SignalSwitchBox);
		registerBlock(Brand1);
		registerBlock(Brand2);
		registerBlock(Brand3);
		registerBlock(Brand4);
		registerBlock(Brand5);
		registerBlock(Brand6);
		registerBlock(SignalBlock1);
		registerBlock(SignalBlock2);
		registerBlock(SignalBlock3);
		registerBlock(SignalBlock4);
		registerBlock(SignalBlock5);
		registerBlock(SignalBlock6);
		registerBlock(SignalBlock7);
		registerBlock(SignalBlock8);
		registerBlock(SignalBlock9);
		
	}
	private static void registerBlock(Block block) {
		GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
	
	}
}
