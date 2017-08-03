package com.meteor.extrabotany.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import vazkii.botania.client.core.helper.ShaderHelper;

import com.meteor.extrabotany.common.core.handler.ConfigHandler;
import com.meteor.extrabotany.common.item.equipment.shield.ItemShieldGeneratorBase;
import com.meteor.extrabotany.common.lib.LibReference;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShield{
	public static final ResourceLocation shieldBar = LibReference.BAR_SHIELD;
	private static ResourceLocation textureShield = LibReference.SHIELD;
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onDrawScreenPre(RenderGameOverlayEvent.Pre event) {
		Minecraft mc = Minecraft.getMinecraft();
		Profiler profiler = mc.mcProfiler;

		if(event.type == ElementType.HEALTH) {
			profiler.startSection("ExtraBotany-HUD");
			profiler.endSection();
		}
	}
	
	@SubscribeEvent
	public void onDrawScreenPost(RenderGameOverlayEvent.Post event) {
		Minecraft mc = Minecraft.getMinecraft();
		Profiler profiler = mc.mcProfiler;
		if(event.type == ElementType.ALL) {
			profiler.startSection("ExtraBotany-HUD");
			if(ItemShieldGeneratorBase.getShieldGenerator(mc.thePlayer) != null){
				profiler.startSection("shieldBar");
				if(!ConfigHandler.anotherShieldRender)
					renderShieldB(event.resolution);
				else renderShield(event.resolution);
				profiler.endSection();
			}
			profiler.endSection();
			GL11.glColor4f(1F, 1F, 1F, 1F);
		}
	}
	
	int cx = ConfigHandler.shieldDisplayX;
	int cy = ConfigHandler.shieldDisplayY;
	
	private void renderShieldB(ScaledResolution res) {
		Minecraft mc = Minecraft.getMinecraft();
		ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int scaledWidth = scaledresolution.getScaledWidth();
        int scaledHeight = scaledresolution.getScaledHeight();
        
        mc.getTextureManager().bindTexture(shieldBar);
        
        float s = ItemShieldGeneratorBase.getShieldAmount(mc.thePlayer)/2;
        
        boolean highlight = ItemShieldGeneratorBase.getShieldCD(mc.thePlayer) > 0;
        
        drawTexturedModalRect(scaledWidth / 2 - 121 + cx, scaledHeight - 19 + cy, 0, highlight ? 9 : 0, 9, 9);
        mc.fontRenderer.drawStringWithShadow("x" + ((int)(s*2))/2, scaledWidth / 2 - 110 + cx, scaledHeight - 19 + cy, 0xFFFFFF);
	}
	
	

	private void renderShield(ScaledResolution res) {
		Minecraft mc = Minecraft.getMinecraft();
		ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int scaledWidth = scaledresolution.getScaledWidth();
        int scaledHeight = scaledresolution.getScaledHeight();
        int xBasePos = scaledWidth / 2 - 91 + cx;
        int yBasePos = scaledHeight - 39 + cy;
        
        boolean highlight = ItemShieldGeneratorBase.getShieldCD(mc.thePlayer) > 0;
        
        mc.getTextureManager().bindTexture(shieldBar);
        
        float s1 = ItemShieldGeneratorBase.getShieldAmount(mc.thePlayer);
        float ss1 = s1/2;
        
        for(int r = 0; r < s1/20; r++){
        	int ra = r * 10;
        	if(s1 > 0){
                for(int i = 0; i < Math.min(ss1 - ra, 10); i++){
    	        	if(s1 > 1 + ra * 2)
    	        		this.drawTexturedModalRect(xBasePos + 8 * Math.min(ss1 % 1 == 0 ? i : ss1 > 10 + ra ? i : Math.max(i-1, 0), 9), yBasePos - ra, 0, highlight ? 9 : 0, 9, 9);
    	        	if(ss1 % 1 != 0 && ss1 <= 10 + ra)
    	        		this.drawTexturedModalRect(xBasePos + 8 * Math.min(i , 9), yBasePos - ra, 9, highlight ? 9 : 0, 9, 9);
    	        }
            }
        }  
	}
	
	double zLevel = 0;

	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6)
	{
		float f = 0.00390625F;
		float f1 = 0.00390625F;
	    Tessellator tessellator = Tessellator.instance;
	    tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + par6), (double) this.zLevel, (double) ((float) (par3 + 0) * f), (double) ((float) (par4 + par6) * f1));
	    tessellator.addVertexWithUV((double) (par1 + par5), (double) (par2 + par6), (double) this.zLevel, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + par6) * f1));
	    tessellator.addVertexWithUV((double) (par1 + par5), (double) (par2 + 0), (double) this.zLevel, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + 0) * f1));
	    tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + 0), (double) this.zLevel, (double) ((float) (par3 + 0) * f),(double) ((float) (par4 + 0) * f1));
	    tessellator.draw();
	}
	
	public static void translateToFootLevel(EntityPlayer player) {
		GL11.glTranslated(0, 2F, 0);
	}
	
	@SideOnly(Side.CLIENT)
	public static void renderShield(EntityPlayer player, float partialTicks) {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240, 240);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(textureShield);
		
		if(player != null)
		translateToFootLevel(player);
		GL11.glTranslatef(0, -0.5F, 0);
		GL11.glScalef(1.3F, 1.3F, 1.3F);

		Tessellator tes = Tessellator.instance;
		ShaderHelper.useShader(ShaderHelper.halo);
		tes.startDrawingQuads();
		tes.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.5F);
		tes.addVertexWithUV(-0.85, 0, -0.85, 0, 0);
		tes.addVertexWithUV(-0.85, 0, 0.85, 0, 1);
		tes.addVertexWithUV(0.85, 0, 0.85, 1, 1);
		tes.addVertexWithUV(0.85, 0, -0.85, 1, 0);
		tes.draw();
		ShaderHelper.releaseShader();
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glEnable(GL11.GL_CULL_FACE);
	}

}
