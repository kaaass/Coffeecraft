package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;

public class ItemCoffeeCore extends Item{
	public ItemCoffeeCore(){
		setTextureName(CoffeecraftMain.MODID+":coffeeCore");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeCore");
	}
}
