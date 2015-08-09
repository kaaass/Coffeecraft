package kaaass.coffeecraft.init;

import kaaass.coffeecraft.item.ItemCoffeeBean;
import kaaass.coffeecraft.item.ItemCoffeeCoin;
import kaaass.coffeecraft.item.ItemCoffeeTreeFruit;
import net.minecraft.item.Item;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Items extends IInits{
	public static Item coffeeTreeFruit;
	public static Item coffeeBean;
	public static Item coffeeCoin;
	
	public Items(){
		super("Items");
	}
	
	public void preLoad() {
		coffeeTreeFruit = new ItemCoffeeTreeFruit();
		coffeeBean = new ItemCoffeeBean();
		coffeeCoin = new ItemCoffeeCoin();
		
		GameRegistry.registerItem(coffeeTreeFruit, "coffeeTreeFruit");
		GameRegistry.registerItem(coffeeBean, "coffeeBean");
		GameRegistry.registerItem(coffeeCoin, "coffeeCoin");
	}

	public void load() {
		
	}

	public void postInit() {
		
	}

}
