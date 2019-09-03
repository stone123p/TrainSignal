package com.hzy.trainsignal.models;

import com.hzy.trainsignal.tileentity.TileEntitySignalControllerBox;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

public class ModelSignalControllerBox extends ModelBase{
	ModelRenderer body;
	public ModelSignalControllerBox() {
		textureWidth = 64;;
	    textureHeight = 32;
	    
	    this.body = new ModelRenderer(this, 0, 0);
	    this.body.addBox(-5.0f, -5.0f, -0.0f, 12, 6, 12);
	    this.body.setRotationPoint(0,0,0);
	    this.body.setTextureOffset(0,0);
	    this.body.setTextureSize(textureWidth, textureHeight);
	    this.body.mirror=true;
	    
	    

	}
	public void renderModel(TileEntity te, float f){
		body.render(f);

  }
}
