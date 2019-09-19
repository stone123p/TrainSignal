package com.hzy.trainsignal.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class TSItems {

	public TSItems() {
		
	}
	public static Item remote = new Remote();
	
	public static void registerItems() {
		registerItems(remote);
	}
	private static void registerItems(Item item) {
		GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
	}
}
