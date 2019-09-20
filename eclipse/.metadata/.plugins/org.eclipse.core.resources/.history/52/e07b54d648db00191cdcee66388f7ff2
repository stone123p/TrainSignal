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
	public static Block Brand1 = new Brand(Material.rock,"Brand",1);
	public static Block Brand2 = new Brand(Material.rock,"Brand",2);
	public static Block Brand3 = new Brand(Material.rock,"Brand",3);
	public static Block Brand4 = new Brand(Material.rock,"Brand",4);
	public static Block Brand5 = new Brand(Material.rock,"Brand",5);
	public static Block Brand6 = new Brand(Material.rock,"Brand",6);


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
	}
	private static void registerBlock(Block block) {
		GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
	
	}
}
