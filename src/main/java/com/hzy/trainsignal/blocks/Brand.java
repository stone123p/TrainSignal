package com.hzy.trainsignal.blocks;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.tileentity.TileEntityBrand;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Brand extends BlockContainer {
	protected int meta=0;
	protected Brand(Material p_i45394_1_, String string,int meta) {
		super(p_i45394_1_);
		this.setBlockName(string+"_"+meta);
		this.setBlockTextureName(TrainSignal.MODID+":"+string+"_"+meta);
		this.setCreativeTab(TrainSignal.trainsignalTab);
		this.setHardness(0.3f);
		this.setBlockBounds(0.35f, 0.35f, 0.35f, 0.65f, 0.65f, 0.65f);
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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
    	if(p_149689_5_ instanceof EntityPlayer)
    		((TileEntityBrand)world.getTileEntity(x, y, z)).face=p_149689_5_.rotationYaw/45;
    		
        	
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBrand(this.meta);
	}
}