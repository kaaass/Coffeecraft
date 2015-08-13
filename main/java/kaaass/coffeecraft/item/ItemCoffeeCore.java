package kaaass.coffeecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCoffeeCore extends Item{
	public ItemCoffeeCore(){
		setTextureName(CoffeecraftMain.MODID+":coffeeCore");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeCore");
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack){
	    return true;
	}
}
