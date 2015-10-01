package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;

public class ItemFilterNet extends Item{
	public ItemFilterNet(){
		setTextureName(CoffeecraftMain.MODID+":filterNet");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("filterNet");
	}
}
