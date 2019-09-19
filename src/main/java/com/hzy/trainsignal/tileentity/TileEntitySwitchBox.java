package com.hzy.trainsignal.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntitySwitchBox extends TileEntity {
	public String ID = "";
	public int default_X,default_Y,default_Z,redstone_X,redstone_Y,redstone_Z;
	public int emitSignal =0;
	public int getEmitSignal(int x,int y,int z) {
		TileEntity entity=this.worldObj.getTileEntity(x, y, z);
		if(entity instanceof TileEntitySignalControllerBox) {
			TileEntitySignalControllerBox controller = (TileEntitySignalControllerBox)entity;
			this.ID=controller.ID;
			return controller.emitSignal();
		}else if(entity instanceof TileEntitySwitchBox){
			TileEntitySwitchBox controller = (TileEntitySwitchBox)entity;
			this.ID=controller.ID;
			return controller.emitSignal;
		}
		return 0;
			
	}
	public void setEmitSignal(boolean isTurnOn) {
		this.emitSignal=isTurnOn?getEmitSignal(redstone_X,redstone_Y,redstone_Z):getEmitSignal(default_X,default_Y,default_Z);
	}
	

	
	public void ToBind(int x, int y, int z, int side) {
		if(side==0) {
			default_X=x;
			default_Y=y;
			default_Z=z;
		}else {
			redstone_X=x;
			redstone_Y=y;
			redstone_Z=z;
		}
	}

}