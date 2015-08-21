package kaaass.coffeecraft.gui;

import kaaass.coffeecraft.init.Gui;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeExchangeCenter;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeGrinder;
import kaaass.coffeecraft.tileentity.TileEntityExtractingMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			case Gui.COFFEE_BAKER_ID:
				return new GuiCoffeeBaker(player.inventory, (TileEntityCoffeeBaker)player.worldObj.getTileEntity(x, y, z));
			case Gui.COFFEE_GRINDER_ID:
				return new GuiCoffeeGrinder(player.inventory, (TileEntityCoffeeGrinder)player.worldObj.getTileEntity(x, y, z));
			case Gui.COFFEE_EXTRACT_ID:
				return new GuiExtractingMachine(player.inventory, (TileEntityExtractingMachine)player.worldObj.getTileEntity(x, y, z));
			case Gui.COFFEE_MAKER_ID:
				return null;
			case Gui.COFFEE_EXCHANGE_ID:
				return new GuiCoffeeExchangeCenter(player.inventory, (TileEntityCoffeeExchangeCenter)player.worldObj.getTileEntity(x, y, z), player);
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
			case Gui.COFFEE_BAKER_ID:
				return new ContainerCoffeeBaker(player.inventory, (TileEntityCoffeeBaker)player.worldObj.getTileEntity(x, y, z));
			case Gui.COFFEE_GRINDER_ID:
				return new ContainerCoffeeGrinder(player.inventory, (TileEntityCoffeeGrinder)player.worldObj.getTileEntity(x, y, z));
			case Gui.COFFEE_EXTRACT_ID:
				return new ContainerExtractingMachine(player.inventory, (TileEntityExtractingMachine)player.worldObj.getTileEntity(x, y, z));
			case Gui.COFFEE_MAKER_ID:
				return null;
			case Gui.COFFEE_EXCHANGE_ID:
				return new ContainerCoffeeExchangeCenter(player.inventory, (TileEntityCoffeeExchangeCenter)player.worldObj.getTileEntity(x, y, z));
	    }
	    return null;
	}
}
