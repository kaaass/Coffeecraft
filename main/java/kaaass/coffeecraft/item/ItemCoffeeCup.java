package kaaass.coffeecraft.item;

import net.minecraft.item.Item;
import kaaass.coffeecraft.CoffeecraftMain;

public class ItemCoffeeCup extends Item{
	public ItemCoffeeCup(){
		setTextureName(CoffeecraftMain.MODID+":coffeeCup");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeCup");
		setMaxStackSize(32);
	}
}
