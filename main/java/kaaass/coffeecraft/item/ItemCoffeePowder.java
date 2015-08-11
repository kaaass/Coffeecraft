package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;

public class ItemCoffeePowder extends Item{
	public ItemCoffeePowder(){
		setTextureName(CoffeecraftMain.MODID+":coffeePowder");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeePowder");
	}
}
