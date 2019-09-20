package com.hzy.trainsignal.renderer;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.tileentity.TileEntitySignalBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderTileEntitySignalBlock extends TileEntitySpecialRenderer {
	ResourceLocation texture;
	String location="";
	ResourceLocation objModelLocation;
	ArrayList<IModelCustom> model=new ArrayList<IModelCustom>();
	public RenderTileEntitySignalBlock() {
		texture = new ResourceLocation(TrainSignal.MODID, "textures/models/baseTexture.png");
	   
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light1.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light2.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light3.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light4.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light5.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light6.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light7.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light8.obj")));
		model.add(AdvancedModelLoader.loadModel(new ResourceLocation(TrainSignal.MODID, "models/light9.obj")));

	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z,float f) {
		int[] name=new int[] {1,1,2,2,3,3};
		TileEntitySignalBlock te2 = (TileEntitySignalBlock) tileentity;
		
		
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.44, y +(te2.meta==1?.45:0), z + 0.5);
    	GL11.glRotated(-te2.face*45+90, 0f, 1f, 0f);
		GL11.glTranslatef((float)0, (float) 0 , (float) 0 );
		GL11.glScalef(.3f, .3f, .3f);
		GL11.glPushMatrix();
			model.get(te2.meta-1).renderAll();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		renderColorController(te2);
		
	}
	private void renderColorController(TileEntitySignalBlock te2) {
		
	}

}
