package kaaass.coffeecraft.gui;

import kaaass.coffeecraft.init.Gui;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			case Gui.COFFEE_BAKER_ID:
				return new GuiCoffeeBaker(player.inventory, (TileEntityCoffeeBaker)player.worldObj.getTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
			case Gui.COFFEE_BAKER_ID:
				return new ContainerCoffeeBaker(player.inventory, (TileEntityCoffeeBaker)player.worldObj.getTileEntity(x, y, z));
	    }
	    return null;
	}
}
