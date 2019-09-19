package com.hzy.trainsignal.blocks;

import java.util.List;

import javax.swing.Icon;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.handler.SignalControllerPacketerHandler;
import com.hzy.trainsignal.items.TSItems;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

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
import net.minecraft.world.World;

public class SignalControllerBox extends BlockContainer {
	
	protected SignalControllerBox(Material material) {
		super(material);
		this.setBlockName("signal_controlle_box");
		this.setBlockTextureName(TrainSignal.MODID+":signal_controlle_box");
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
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySignalControllerBox();
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
		signal_top_texture=register.registerIcon(TrainSignal.MODID+":signal_box_controller");
		signal_side_texture=register.registerIcon(TrainSignal.MODID+":signal_box_side");
		signal_bottom_texture=register.registerIcon(TrainSignal.MODID+":signal_box_bottom");
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		
		if(player.getCurrentEquippedItem()!=null) {
			ItemStack remote=player.getHeldItem();
			
			if(remote.getItem()==TSItems.remote) {
				if (remote.getTagCompound() == null)
					remote.setTagCompound( new NBTTagCompound());
	            NBTTagCompound bind = new NBTTagCompound();
	            bind.setInteger("x", x );
	            bind.setInteger("y", y );
	            bind.setInteger("z", z );
	            remote.getTagCompound().setTag("bind", bind);
	            if(world.isRemote)
	            	player.addChatMessage(new ChatComponentText("Bind to"+bind));
			}
			
		}
		
		if(world.isRemote){
			return true;
		}else if(player.getHeldItem()==null){
			FMLNetworkHandler.openGui(player, TrainSignal.instance, TrainSignal.Controller_BOX_GUIID, world, x, y,z);
		}
		
		return true;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block,int part1) {
		super.breakBlock(world, x, y, z, block, part1);
		world.removeTileEntity(x, y, z);
	}
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public boolean canProvidePower()
    {
        return true;
    }
	public boolean isTurnOn=false;
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,	Block block) {
		boolean isOn=world.isBlockIndirectlyGettingPowered(x, y, z);
		if(!world.isRemote && this.isTurnOn!=isOn) {
			this.isTurnOn=isOn;
			TileEntitySignalControllerBox entity=(TileEntitySignalControllerBox)world.getTileEntity(x,y,z);
			entity.isTurnOn=this.isTurnOn;
		}
		

       
	}

}
