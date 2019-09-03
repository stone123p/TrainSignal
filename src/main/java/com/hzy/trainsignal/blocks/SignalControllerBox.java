package com.hzy.trainsignal.blocks;

import java.util.List;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SignalControllerBox extends BlockContainer {
	protected SignalControllerBox(Material material) {
		super(material);
		this.setBlockName("SignalControllerBox");
		this.setBlockTextureName(TrainSignal.MODID+":SignalControllerBox");
		this.setCreativeTab(TrainSignal.trainsignalTab);
		this.setHardness(0.3f);
		this.setLightLevel(0.4f);
	}
	@Override
	public int getRenderType(){
	    return -1;
	}
	public boolean isFullCube()
    {
        return false;
    }
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySignalControllerBox();
	}


	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z,
			AxisAlignedBB AABB, List list, Entity entity) {
		this.setBlockBounds(0.3f, 0.0f, 0.3f, 0.7f, 0.3f, 0.7f);
		super.addCollisionBoxesToList(world, x, y, z, AABB, list, entity);
		
	}
	
	

}