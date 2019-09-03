package com.hzy.trainsignal.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TSBlocks {
	
	public TSBlocks() {
		
	}

	public static Block SignalControllerBox = new SignalControllerBox(Material.rock);
	
	public static void registerBlocks() {
		registerBlock(SignalControllerBox);
	}
	private static void registerBlock(Block block) {
		GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
	}
}