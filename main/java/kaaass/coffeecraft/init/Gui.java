package kaaass.coffeecraft.init;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.gui.GuiHandler;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeGrinder;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Gui extends IInits{
	public static final int COFFEE_BAKER_ID = 1008601;
	public static final int COFFEE_GRINDER_ID = 1008602;
	
	public Gui(){
		super("Gui");
	}
	
	@Override
	public void preLoad() {
		GameRegistry.registerTileEntity(TileEntityCoffeeBaker.class, "TileEntityCoffeeBaker");
		GameRegistry.registerTileEntity(TileEntityCoffeeGrinder.class, "TileEntityCoffeeGrinder");
		
		NetworkRegistry.INSTANCE.registerGuiHandler(CoffeecraftMain.instance, new GuiHandler());
	}

	@Override
	public void load() {
		
	}

	@Override
	public void postInit() {
		
	}
}