package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;

public class ItemFilter extends Item{
	public ItemFilter(){
		setTextureName(CoffeecraftMain.MODID+":filter");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("filter");
	}
}
