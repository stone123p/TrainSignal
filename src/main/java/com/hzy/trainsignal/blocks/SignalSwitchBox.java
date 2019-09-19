package com.hzy.trainsignal.blocks;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.items.TSItems;
import com.hzy.trainsignal.tileentity.TileEntitySwitchBox;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SignalSwitchBox extends BlockContainer {

	protected SignalSwitchBox(Material material) {
		super(material);
		this.setBlockName("signal_switch_box");
		this.setBlockTextureName(TrainSignal.MODID+":signal_switch_box");
		this.setCreativeTab(TrainSignal.trainsignalTab);
		this.setHardness(0.3f);
		this.setLightLevel(0.4f);
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
	private IIcon signal_top_texture,signal_side_texture,signal_bottom_texture,signal_port_texture ;
	@Override
	public IIcon getIcon(int side, int meta) {
		if(side==1) {
			return signal_top_texture;
		}else if(side==0) {
			return signal_bottom_texture;
		}else if(side==2||side==5||side==4) {
			return signal_port_texture;
		}else {
			return signal_side_texture;
		}
		
	}
	@Override
	public void registerBlockIcons(IIconRegister register) {
		signal_top_texture=register.registerIcon(TrainSignal.MODID+":signal_box_swtich");
		signal_side_texture=register.registerIcon(TrainSignal.MODID+":signal_box_side");
		signal_port_texture=register.registerIcon(TrainSignal.MODID+":signal_box_side_port");
		signal_bottom_texture=register.registerIcon(TrainSignal.MODID+":signal_box_bottom");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySwitchBox();
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntitySwitchBox entity=(TileEntitySwitchBox)world.getTileEntity(x,y,z);
		if(world.isRemote)
        	player.addChatMessage(new ChatComponentText("side"+side ));
		if(player.getCurrentEquippedItem()!=null) {
			ItemStack itemStack=player.getHeldItem();

			if(itemStack.getItem()==TSItems.remote ){
	           switch(side) {
	           case 2:
	        	   //out
	        	    bindOutport(player,world,  x,  y,  z,itemStack);
	        	   break;
	           case 5:
	        	   //defer
	        	   bindInport(player, world,entity,itemStack,0);
	        	   break;
	           case 4:
	        	   //resstone
	        	   bindInport(player, world,entity,itemStack,1);
	        	   break;
	           }
			}
			
		}
		
		return true;
	}


	private void bindInport(EntityPlayer player,World world, TileEntitySwitchBox entity, ItemStack itemStack, int f) {
		if(itemStack.getTagCompound().hasKey("bind")){
			NBTTagCompound nbt = (NBTTagCompound) itemStack.getTagCompound().getTag("bind");
            if(world.isRemote)
            	player.addChatMessage(new ChatComponentText("the "+(f==0?"default_port":"red_stone_port") +" has been bound with"+nbt ));
            entity.ToBind(nbt.getInteger("x"),nbt.getInteger("y"),nbt.getInteger("z"), f);
		}
          				
	}
	private void bindOutport(EntityPlayer player,World world, int x, int y, int z, ItemStack remote) {
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
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block,int part1) {
		super.breakBlock(world, x, y, z, block, part1);
		world.removeTileEntity(x, y, z);
		
	}
	
	public boolean isTurnOn=false;
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,	Block block) {
		boolean isOn=world.isBlockIndirectlyGettingPowered(x, y, z);
		if(!world.isRemote && this.isTurnOn!=isOn) {
			this.isTurnOn=isOn;
			TileEntitySwitchBox entity=(TileEntitySwitchBox)world.getTileEntity(x,y,z);
			entity.setEmitSignal(this.isTurnOn);
		}
		

       
	}
	
	
}
