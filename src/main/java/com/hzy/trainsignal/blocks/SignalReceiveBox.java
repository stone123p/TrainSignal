package com.hzy.trainsignal.blocks;

import java.util.List;
import java.util.Random;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.items.TSItems;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;
import com.hzy.trainsignal.tileentity.TileEntitySignalReceiveBox;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SignalReceiveBox extends BlockContainer {
	protected SignalReceiveBox(Material material) {
		super(material);
		this.setBlockName("signal_receive_box");
		this.setBlockTextureName(TrainSignal.MODID+":signal_receive_box");
		this.setCreativeTab(TrainSignal.trainsignalTab);
		this.setHardness(0.3f);
		this.setBlockBounds(0.15f, 0.0f, 0.15f, 0.85f, 0.35f, 0.85f);

		
	}
	@Override
	public int getRenderType(){
	    return 0;
	}
	public boolean isFullCube()
    {
        return false;
    }
	@Override
	public boolean isOpaqueCube() {
		return false;
	}


	private IIcon signal_top_texture,signal_side_texture,signal_bottom_texture ;
	@Override
	public IIcon getIcon(int side, int meta) {
		if(side==1) {
			return signal_top_texture;
		}else if(side==0) {
			return signal_bottom_texture;
		}else {
			return signal_side_texture;
		}
		
	}
	@Override
	public void registerBlockIcons(IIconRegister register) {
		signal_top_texture=register.registerIcon(TrainSignal.MODID+":signal_box_receiver");
		signal_side_texture=register.registerIcon(TrainSignal.MODID+":signal_box_side");
		signal_bottom_texture=register.registerIcon(TrainSignal.MODID+":signal_box_bottom");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
	
		return new TileEntitySignalReceiveBox();
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntitySignalReceiveBox entity=(TileEntitySignalReceiveBox)world.getTileEntity(x,y,z);
		
		if(player.getCurrentEquippedItem() != null) {
			ItemStack itemStack=player.getHeldItem();

			if(itemStack.getItem()==TSItems.remote ){
	            player.addChatMessage(new ChatComponentText(Boolean.toString(itemStack.getTagCompound()!=null)));
				if(itemStack.getTagCompound() !=null){

					if(itemStack.getTagCompound().hasKey("bind")){
						NBTTagCompound nbt = (NBTTagCompound) itemStack.getTagCompound().getTag("bind");
			            if(world.isRemote)
			            	player.addChatMessage(new ChatComponentText("the receive box has been bound with"+nbt ));
			            entity.ToBind(nbt.getInteger("x"),nbt.getInteger("y"),nbt.getInteger("z"));

			           
			            return true;
					}
				}
			}
			
		}
		if(world.isRemote){
			return true;
		}else if(player.getHeldItem()==null){
			FMLNetworkHandler.openGui(player, TrainSignal.instance, TrainSignal.Receive_BOX_GUIID, world, x, y,z);
		}
		return true;
	}



	@Override
	public boolean hasTileEntity() {
		return true;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block,int part1) {
		super.breakBlock(world, x, y, z, block, part1);
		world.removeTileEntity(x, y, z);
		
	}
	@Override
	public boolean canProvidePower()
    {
        return true;
    }
	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z,int side) {
		
		super.isProvidingWeakPower(world, x, y, z, side);
		TileEntity tileEntity = world.getTileEntity(x, y, z);
        return tileEntity instanceof TileEntitySignalReceiveBox ? ((TileEntitySignalReceiveBox) tileEntity).isProvidingStrongPower() : 0;		
	}
	
	
	
	

}
