package com.hzy.trainsignal.blocks;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.tileentity.TileEntitySignalBlock;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SignalBlock extends BlockContainer {
	protected int meta=0;
	protected SignalBlock(Material p_i45386_1_,String string,int meta) {
		super(p_i45386_1_);
		this.setBlockName(string);
		this.setBlockTextureName(TrainSignal.MODID+":signal");
		this.setCreativeTab(TrainSignal.trainsignalTab);
		this.setHardness(0.3f);
		this.meta=meta;
	}
	@Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public int getRenderType(){
        return -1;
    }
    @Override
    public boolean isOpaqueCube(){
        return false;
    }
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
    	if(p_149689_5_ instanceof EntityPlayer)
    		((TileEntitySignalBlock)world.getTileEntity(x, y, z)).face=p_149689_5_.rotationYaw/45;
    
    }

    
	@Override
	public TileEntity createNewTileEntity(World world, int m) {
		return new TileEntitySignalBlock(this.meta);
	}

}