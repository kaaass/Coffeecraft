package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;

public class ItemMixedPowder extends Item {
	public ItemMixedPowder(){
		setTextureName(CoffeecraftMain.MODID+":mixedPowder");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("mixedPowder");
	}
}
