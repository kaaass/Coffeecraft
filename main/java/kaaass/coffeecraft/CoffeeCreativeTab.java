package kaaass.coffeecraft;

import kaaass.coffeecraft.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoffeeCreativeTab extends CreativeTabs {

	public CoffeeCreativeTab(String title) {
		super(title);
	}
	
	@Override
	public Item getTabIconItem() {
		return Items.coffeeBean;
	}
}