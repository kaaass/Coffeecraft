package kaaass.coffeecraft.item;

import net.minecraft.item.Item;
import kaaass.coffeecraft.CoffeecraftMain;

public class ItemCoffeeCoin extends Item{
	public ItemCoffeeCoin(){
		super();
		setTextureName(CoffeecraftMain.MODID+":coffeeCoin");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeCoin");
	}
}
