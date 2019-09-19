package com.hzy.trainsignal.gui;

import org.lwjgl.opengl.GL11;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;
import com.hzy.trainsignal.container.ContainerSignalControllerBox;
import com.hzy.trainsignal.handler.SignalControllerPacketerHandler;
import com.hzy.trainsignal.network.SignalControllerPacketer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiSignalControllerBox extends GuiContainer {
	private TileEntitySignalControllerBox entity;
	private GuiTextField text;
	public int data1,data2;
	

	public GuiSignalControllerBox(InventoryPlayer inventory, TileEntitySignalControllerBox entity) {

		super(new ContainerSignalControllerBox(inventory,entity));
		this.entity=entity;
		this.data2=entity.default_signal;
		this.data1=entity.redstone_signal;
		
	}

	
	Minecraft mc=Minecraft.getMinecraft();

	private int guiWidth = 176;
	private int guiHeight= 94;
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();

		this.entity.default_signal=this.data2;
		this.entity.redstone_signal=this.data1;
		this.entity.ID=this.text.getText();
		SignalControllerPacketerHandler.network.sendToServer(new SignalControllerPacketer(this.entity));

	}

	private GuiButton[] Btns﻿=new GuiButton[4];
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);

		if(button.enabled)
		if (button.id == 0){
			if(data1>0)data1-=1;
			
		}else if (button.id == 1){
			if(data1<9)data1+=1;
		}else if(button.id == 2) {
			if(data2>0)data2-=1;
		}else if(button.id == 3) {
			if(data2<9)data2+=1;
		}
	}


	@Override
	public void initGui() {
		super.initGui();
		int guiX = (width-guiWidth)/2;
		int guiY = (height-guiHeight)/2;
		this.text=new GuiTextField(fontRendererObj,guiX+70,guiY+62,55,15);
		this.text.setMaxStringLength(13);
		this.text.setText(this.entity.ID);
	    this.text.setFocused(true);
	    
	    this.buttonList.clear();
	    String[] labels =new String[]{"<",">"};
	    
	    for(int i=0;i<2;i++){
	    	for(int j=0;j<2;j++) {
	    		Btns﻿[i+2*j] = new GuiOptionButton(i+2*j, guiX+83+28*i, guiY+17+22*j, labels[i]);
		    	Btns﻿[i+2*j].width = 14;
		    	
		        this.buttonList.add(Btns﻿[i+2*j]);
	    	}
	    }
	   
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float ticks, int x, int y) {
		int guiX = (width-guiWidth)/2;
		int guiY = (height-guiHeight)/2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(TrainSignal.MODID+":textures/gui/gui_controller_box.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0 , guiWidth, guiHeight);
		Btns﻿[0].enabled=data1>0;
		Btns﻿[1].enabled=data1<9;
		Btns﻿[2].enabled=data2>0;
		Btns﻿[3].enabled=data2<9;
		
		fontRendererObj.drawSplitString("控制箱",guiX+guiWidth/2-30, guiY+5,116, 0x000000);//StatCollector.translateToLocal("GuiBook.Environment.con")
		fontRendererObj.drawSplitString("ID:",guiX+50, guiY+65,116, 0x000000);//StatCollector.translateToLocal("GuiBook.Environment.con")
		fontRendererObj.drawSplitString(Integer.toString(data1),guiX+(85+6+113)/2, guiY+23,116, 0x000000);
		fontRendererObj.drawSplitString(Integer.toString(data2),guiX+(85+6+113)/2, guiY+46,116, 0x000000);
		this.text.drawTextBox();
	}
	@Override
	protected void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);

	}
	

	@Override
	protected void keyTyped(char part1, int part2) {
		super.keyTyped(part1, part2);
		this.text.textboxKeyTyped(part1, part2);
	}

	@Override
	public void updateScreen()
    {
		this.text.updateCursorCounter();
    }
}
