package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;

public class ItemCocoaPowder extends Item {
	public ItemCocoaPowder(){
		setTextureName(CoffeecraftMain.MODID+":cocoaPowder");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("cocoaPowder");
	}
}
