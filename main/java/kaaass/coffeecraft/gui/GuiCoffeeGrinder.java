package kaaass.coffeecraft.gui;

import org.lwjgl.opengl.GL11;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeGrinder;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiCoffeeGrinder extends GuiContainer {
	private TileEntityCoffeeGrinder tile;
	public GuiCoffeeGrinder(InventoryPlayer inventory, TileEntityCoffeeGrinder tileEntityCoffeeGrinder){
		super(new ContainerCoffeeGrinder(inventory, tileEntityCoffeeGrinder));
		this.tile = tileEntityCoffeeGrinder;
		this.doesGuiPauseGame();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int arg0, int arg1) {
		 super.drawGuiContainerForegroundLayer(arg0, arg1);
		 fontRendererObj.drawString(StatCollector.translateToLocal("container.coffeeGrinder"), 65, 6, 4210752);
		 fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(CoffeecraftMain.MODID,"textures/gui/CoffeeGrinder.png"));
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        //draw redstone
        if(tile.getWorldObj().isBlockIndirectlyGettingPowered(tile.xCoord, tile.yCoord, tile.zCoord)){
        	this.drawTexturedModalRect(this.guiLeft + 153, this.guiTop + 62, 176, 0, 16, 16);
        }
        //draw progress bar
        int b = tile.progressTime;
        float totalTime = 600.0F;
        if(b > 0){
            this.drawTexturedModalRect(this.guiLeft + 80, this.guiTop + 35, 176, 17, (int)(24 * ((float)b / totalTime)), 17);
        }
	}
}
