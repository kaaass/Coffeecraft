package kaaass.coffeecraft.init;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.gui.GuiHandler;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Gui extends IInits{
	public static final int COFFEE_BAKER_ID = 124501;
	
	public Gui(){
		super("Gui");
	}
	
	@Override
	public void preLoad() {
		GameRegistry.registerTileEntity(TileEntityCoffeeBaker.class, "TileEntityCoffeeBaker");
		
		NetworkRegistry.INSTANCE.registerGuiHandler(CoffeecraftMain.instance, new GuiHandler());
	}

	@Override
	public void load() {
		
	}

	@Override
	public void postInit() {
		
	}
}
