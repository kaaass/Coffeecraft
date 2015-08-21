package kaaass.coffeecraft.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Mouse;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.init.TradeRegistry;
import kaaass.coffeecraft.init.info.InfoTrade;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeExchangeCenter;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiCoffeeExchangeCenter extends GuiContainer {
	private TileEntityCoffeeExchangeCenter tile;
	public EntityPlayer player;
	public List<Integer> btnClick = new ArrayList();
	
	public GuiCoffeeExchangeCenter(InventoryPlayer inventory, TileEntityCoffeeExchangeCenter tileEntityCoffeeExchangeCenter, EntityPlayer player){
		super(new ContainerCoffeeExchangeCenter(inventory, tileEntityCoffeeExchangeCenter));
		this.tile = tileEntityCoffeeExchangeCenter;
		this.ySize = 193;
		this.player = player;
		this.doesGuiPauseGame();
		tile.tradeList = InfoTrade.readTrade(player);
		if(InfoTrade.readTrade(player) == null){
			List<InfoTrade> a = new ArrayList();
			a.add(TradeRegistry.getRandomTrade(tile.getWorldObj().rand));
			a.add(TradeRegistry.getRandomTrade(tile.getWorldObj().rand));
			a.add(TradeRegistry.getRandomTrade(tile.getWorldObj().rand));
			a.add(TradeRegistry.getRandomTrade(tile.getWorldObj().rand));
			a.add(TradeRegistry.getRandomTrade(tile.getWorldObj().rand));
			tile.tradeList = a;
			InfoTrade.writeTrade(player, a);
		}
		for(int i = 0; i <= tile.tradeList.size(); i++){
			btnClick.add(0);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int arg0, int arg1) {
		 super.drawGuiContainerForegroundLayer(arg0, arg1);
		 fontRendererObj.drawString(StatCollector.translateToLocal("container.coffeeExchangeCenter"), 65, 6, 4210752);
		 fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
		 if(tile.tradeList.size() * 25 > 78){
			 
		 }else{
			 for(int i = 0; i < tile.tradeList.size(); i++){
				 fontRendererObj.drawString(StatCollector.translateToLocal(tile.tradeList.get(i).getOutItem()
						 .getUnlocalizedName(tile.tradeList.get(i).getOut()) + ".name"), 65, 24 + 25 * i, 4210752);
				 fontRendererObj.drawString(tile.tradeList.get(i).getInfo(), 65, 33 + 25 * i, 4210752);
			 }
		 }
		 String str = "Exp:" + this.tile.exp;
		 int a = this.fontRendererObj.getStringWidth(str);
		 if(a > 36){
			 str = "Exp:...";
			 a = this.fontRendererObj.getStringWidth(str);
		 }
		 fontRendererObj.drawString(str, 22 - a / 2, 81, 4210752);
		 str = "Lv." + InfoTrade.getLevelFromTrade(this.tile.level);
		 a = this.fontRendererObj.getStringWidth(str);
		 if(a > 36){
			 str = "Lv...";
			 a = this.fontRendererObj.getStringWidth(str);
		 }
		 fontRendererObj.drawString(str, 22 - a / 2, 88, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(CoffeecraftMain.MODID,"textures/gui/CoffeeExchangeCenter.png"));
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        //list
        if(tile.tradeList.size() * 25 > 78){
        	int i = (int)Math.floor(tile.listTop / 25);
        	//(int)Math.floor((tile.listTop + 78) / 25)
        	int ii = 3 + i;
        	if(ii > tile.tradeList.size() - 1){
        		ii = tile.tradeList.size() - 1;
        	}
        	for(; i <= ii; i++){
        		if(i * 25 < tile.listTop){
        			int a = tile.listTop - i * 25;
        			drawTexturedModalRect(this.guiLeft + 41, this.guiTop + 21, 0, 193 + a, 106, 25 - a);
        			int b, c;
        			if(a < 4){
        				b = 4 - a;
        				c = 0;
        			}else{
        				b = 0;
        				c = a - 4;
        			}
            		if(btnClick.get(i + 1) == 1){
            			drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 21 + b, 126, 193 + c, 10, 15 - c);
            		}else{
            			drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 21 + b, 106, 193 + c, 10, 15 - c);
            		}
            		//drawTexturedModalRect(this.guiLeft + 45, this.guiTop + 25 + 25 * i, 0, 0, 16, 16);
        		}else if(i == ii){
        			int a = (i + 1) * 25 - tile.listTop + 78;
        			drawTexturedModalRect(this.guiLeft + 41, this.guiTop + 74 + a, 0, 193, 106, 25 - a);
        			int b;
        			if(a > 5){
        				b = a - 5;
        			}else{
        				b = 0;
        			}
        			if(a < 21){
        				if(btnClick.get(i + 1) == 1){
                			drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 25 + 25 * i, 126, 193, 10, 15 - b);
                		}else{
                			drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 25 + 25 * i, 106, 193, 10, 15 - b);
                		}
        			}
            		//drawTexturedModalRect(this.guiLeft + 45, this.guiTop + 25 + 25 * i, 0, 0, 16, 16);
        		}else{
        			drawTexturedModalRect(this.guiLeft + 41, this.guiTop + 21 + 25 * i - tile.listTop, 0, 193, 106, 25);
        			if(btnClick.get(i + 1) == 1){
        				drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 25 + 25 * i - tile.listTop, 126, 193, 10, 15);
        			}else{
        				drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 25 + 25 * i - tile.listTop, 106, 193, 10, 15);
        			}
        			//drawTexturedModalRect(this.guiLeft + 45, this.guiTop + 25 + 25 * i, 0, 0, 16, 16);
        		}
        	}
        }else{
        	for(int i = 0; i < tile.tradeList.size(); i++){
        		drawTexturedModalRect(this.guiLeft + 41, this.guiTop + 21 + 25 * i, 0, 193, 106, 25);
        		if(btnClick.get(i + 1) == 1){
        			drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 25 + 25 * i, 126, 193, 10, 15);
        		}else{
        			drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 25 + 25 * i, 106, 193, 10, 15);
        		}
        		//drawTexturedModalRect(this.guiLeft + 45, this.guiTop + 25 + 25 * i, 0, 0, 16, 16);
        	}
        }
        //scroll bar
        if(tile.tradeList.size() * 25 > 78){
        	if(btnClick.get(0) == 0){
        		drawTexturedModalRect(this.guiLeft + 154, this.guiTop + 20 + 
            			(int)((float)tile.listTop / (float)(tile.tradeList.size() * 25 - 78) * 63)
            			, 176, 0, 12, 15);
        	}else{
        		drawTexturedModalRect(this.guiLeft + 154, this.guiTop + 20 + 
            			(int)((float)tile.listTop / (float)(tile.tradeList.size() * 25 - 78) * 63)
            			, 188, 0, 12, 15);
        	}
        }
	}
	
	protected void mouseClicked(int x, int y, int index){
		if(index == 0){
			if(inCase(x, y, this.guiLeft + 154, this.guiTop + 20 + (int)((float)tile.listTop 
					/ (float)(tile.tradeList.size() * 25 - 78) * 63), 12, 15)){
				btnClick.add(0, 1);
			}
			if(tile.tradeList.size() * 25 > 78){
	        	int i = (int)Math.floor(tile.listTop / 25);
	        	int ii = 4 + (int)Math.floor(tile.listTop / 25);
	        	for(; i <= ii; i++){
	        		if(i * 25 < tile.listTop){
	        			int a = tile.listTop - i * 25;
	        			int b, c;
	        			if(a < 4){
	        				b = 4 - a;
	        				c = 0;
	        			}else{
	        				b = 0;
	        				c = a - 4;
	        			}
	        			if(inCase(x, y, this.guiLeft + 132, this.guiTop + 21 + b, 10, 15 - c)){
	        				btnClick.add(i + 1, 1);
	        			}        		
	        		}else if(i * 25 - 78 < tile.listTop){
	        			//down
	        		}else{
	        			if(inCase(x, y, this.guiLeft + 132, this.guiTop + 25 + 25 * i - tile.listTop, 10, 15)){
							btnClick.add(i + 1, 1);
						}
	        		}
	        	}
	        }else{
	        	for(int i = 0; i < tile.tradeList.size(); i++){
					if(inCase(x, y, this.guiLeft + 132, this.guiTop + 25 + 25 * i, 10, 15)){
						btnClick.add(i + 1, 1);
					}
				}
	        }
		}
		super.mouseClicked(x, y, index);
	}
	
	protected void mouseMovedOrUp(int x, int y, int index){
		if(index == 0){
			btnClick.clear();
			for(int i = 0; i <= tile.tradeList.size(); i++){
				btnClick.add(0);
			}
		}
		super.mouseMovedOrUp(x, y, index);
	}
	
	public void handleMouseInput(){
	    super.handleMouseInput();
	    int i = Mouse.getEventDWheel();
	    if(i != 0 && tile.tradeList.size() * 25 > 78){
	    	 if (i > 0) {
	    		 i = -1;
	    	 }else if (i < 0) {
	    		 i = 1;
	    	 }
	    	 tile.listTop += i * 10;
	    	 if(tile.listTop < 0){
	    		 tile.listTop = 0;
	    	 }else if(tile.listTop + 78 > tile.tradeList.size() * 25){
	    		 tile.listTop = tile.tradeList.size() * 25 - 78;
	    	 }
	    }
	}
	
	protected void mouseClickMove(int x, int y, int index, long time){
		if(index == 0 && tile.tradeList.size() * 25 > 78){
			if(inCase(x, y, this.guiLeft + 154, this.guiTop + 27, 12, 63)){
				tile.listTop = (int)((float)(y - this.guiTop - 27) / (float)63 * 
						(tile.tradeList.size() * 25 - 78));
			}	
		}
	}
	
	private boolean inCase(int x, int y, int x1, int y1, int w, int h){
		return x >= x1 && x <= x1 + w && y >= y1 && y <= y1 + h;
	}
}
