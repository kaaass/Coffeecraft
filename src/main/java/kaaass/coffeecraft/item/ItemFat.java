package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;

public class ItemFat extends Item{
	public ItemFat(){
		setTextureName(CoffeecraftMain.MODID+":fat");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("fat");
	}
}
