package com.hzy.trainsignal.gui;


import org.lwjgl.opengl.GL11;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.container.ContainerSignalReceiveBox;
import com.hzy.trainsignal.handler.SignalReceivePacketerHandler;
import com.hzy.trainsignal.network.SignalReceivePacketer;
import com.hzy.trainsignal.tileentity.TileEntitySignalReceiveBox;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiSignalReceiveBox extends GuiContainer {


	@Override
	public void onGuiClosed() {
	
		SignalReceivePacketerHandler.network.sendToServer(new SignalReceivePacketer(this.entity));
		super.onGuiClosed();
	}
	private TileEntitySignalReceiveBox entity;

	public GuiSignalReceiveBox(InventoryPlayer inventory, TileEntitySignalReceiveBox entity) {
		super(new ContainerSignalReceiveBox(inventory,entity));
		this.entity=entity;

	}
	Minecraft mc=Minecraft.getMinecraft();

	private int guiWidth = 176;
	private int guiHeight= 94;
	private int[] metas=new int[10];


	
	@Override
	protected void drawGuiContainerBackgroundLayer(float ticks, int x, int y) {
		int guiX = (width-guiWidth)/2;
		int guiY = (height-guiHeight)/2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(TrainSignal.MODID+":textures/gui/gui_receive_box.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0 , guiWidth, guiHeight);
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<2;j++) {
				metas[i+5*j]=this.entity.actions_signal[i+5*j]==(byte)1?2:(guiX+76+i*16<=x&&x<=guiX+76+10+i*16&&guiY+18+25*j<=y&&y<=guiY+18+14+25*j)?1:0;
				drawTexturedModalRect(guiX+76+i*16, guiY+18+25*j, 199, 14*metas[i+5*j] ,10, 14);
			}
		}
		fontRendererObj.drawSplitString("接收箱",guiX+guiWidth/2-30, guiY+5,116, 0x000000);
		fontRendererObj.drawSplitString("bind with:"+this.entity.BindID,guiX+50, guiY+63,116, 0x000000);
		for(int i=0;i<5;i++) {
			for(int j=0;j<2;j++) {
				fontRendererObj.drawSplitString(Integer.toString(i+j*5),guiX+79+i*16, guiY+22+25*j, 116, 0xffffff);
			}
		}
		
		
	}
	@Override
	protected void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
		int guiX = (width-guiWidth)/2;
		int guiY = (height-guiHeight)/2;
		for(int i=0;i<5;i++) {
			for(int j=0;j<2;j++) {
				if(guiX+76+i*16<=x&&x<=guiX+76+10+i*16&&guiY+18+25*j<=y&&y<=guiY+18+14+25*j){
					this.entity.actions_signal[i+5*j]=(byte) (this.entity.actions_signal[i+5*j]==(byte)0?1:0);
				}
			}
		}

	}

}
