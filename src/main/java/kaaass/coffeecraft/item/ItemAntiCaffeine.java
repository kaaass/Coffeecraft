package kaaass.coffeecraft.item;

import net.minecraft.item.Item;
import kaaass.coffeecraft.CoffeecraftMain;

public class ItemAntiCaffeine extends Item{
	public ItemAntiCaffeine(){
		super();
		setTextureName(CoffeecraftMain.MODID+":antiCaffeine");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("antiCaffeine");
	}
}
