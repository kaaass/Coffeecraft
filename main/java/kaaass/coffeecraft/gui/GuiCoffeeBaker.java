package kaaass.coffeecraft.gui;

import org.lwjgl.opengl.GL11;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiCoffeeBaker extends GuiContainer {
	private TileEntityCoffeeBaker tile;
	public GuiCoffeeBaker(InventoryPlayer inventory, TileEntityCoffeeBaker tile){
		super(new ContainerCoffeeBaker(inventory, tile));
		this.tile = tile;
		this.doesGuiPauseGame();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int arg0, int arg1) {
		 super.drawGuiContainerForegroundLayer(arg0, arg1);
		 fontRendererObj.drawString(StatCollector.translateToLocal("container.coffeeBaker"), 65, 6, 4210752);
		 fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
		 String str = ((this.tile.temperature + this.tile.getWorldObj().rand.nextInt(5)) / 10 + "¡ãC");
		 int a = this.fontRendererObj.getStringWidth(str);
		 fontRendererObj.drawString(str, 63 - a / 2, 66, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(CoffeecraftMain.MODID,"textures/gui/CoffeeBaker.png"));
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        //draw fire
        Block a = tile.getWorldObj().getBlock(tile.xCoord, tile.yCoord - 1, tile.zCoord);
        if(a == Blocks.fire){
        	this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 45, 176, 0, 14, 14);
        }
        //draw progress bar
        int b = tile.progressTime;
        float totalTime = 1000.0F;
        if(b > 0){
            this.drawTexturedModalRect(this.guiLeft + 79, this.guiTop + 28, 176, 15, (int)(24 * ((float)b / totalTime)), 17);
        }
	}
}
