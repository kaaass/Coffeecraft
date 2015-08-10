package kaaass.coffeecraft.item;

import net.minecraft.item.Item;
import kaaass.coffeecraft.CoffeecraftMain;

public class ItemCaffeine extends Item{
	public ItemCaffeine(){
		super();
		setTextureName(CoffeecraftMain.MODID+":caffeine");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("caffeine");
	}
}
