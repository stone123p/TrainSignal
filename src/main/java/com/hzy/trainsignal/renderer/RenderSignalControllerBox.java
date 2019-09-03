package com.hzy.trainsignal.renderer;

import org.lwjgl.opengl.GL11;

import com.hzy.trainsignal.TrainSignal;
import com.hzy.trainsignal.models.ModelSignalControllerBox;
import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderSignalControllerBox extends TileEntitySpecialRenderer{
	private static final ResourceLocation texture = new ResourceLocation(TrainSignal.MODID+":"+"textures/models/signal_controllor_box.png");
	private ModelSignalControllerBox model;
	public RenderSignalControllerBox(){
		this.model = new ModelSignalControllerBox();
	}
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z,float partialTicks) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
			this.model.renderModel(te, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
