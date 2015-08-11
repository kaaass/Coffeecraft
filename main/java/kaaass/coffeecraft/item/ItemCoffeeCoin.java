package kaaass.coffeecraft.item;

import net.minecraft.item.Item;
import kaaass.coffeecraft.CoffeecraftMain;

public class ItemCoffeeCoin extends Item{
	public ItemCoffeeCoin(){
		setTextureName(CoffeecraftMain.MODID+":coffeeCoin");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeCoin");
		setMaxStackSize(16);
	}
}
