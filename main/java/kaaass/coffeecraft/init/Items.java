package kaaass.coffeecraft.init;

import kaaass.coffeecraft.item.ItemAntiCaffeine;
import kaaass.coffeecraft.item.ItemAntiCaffeineTablets;
import kaaass.coffeecraft.item.ItemCaffeine;
import kaaass.coffeecraft.item.ItemCaffeineTablets;
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
	
	public static Item caffeine;
	public static Item antiCaffeine;
	public static Item caffeineTablets;
	public static Item antiCaffeineTablets;
	
	public Items(){
		super("Items");
	}
	
	public void preLoad() {
		coffeeTreeFruit = new ItemCoffeeTreeFruit();
		coffeeBean = new ItemCoffeeBean();
		coffeeCoin = new ItemCoffeeCoin();
		
		caffeine = new ItemCaffeine();
		antiCaffeine = new ItemAntiCaffeine();
		caffeineTablets = new ItemCaffeineTablets();
		antiCaffeineTablets = new ItemAntiCaffeineTablets();
		
		GameRegistry.registerItem(coffeeTreeFruit, "coffeeTreeFruit");
		GameRegistry.registerItem(coffeeBean, "coffeeBean");
		GameRegistry.registerItem(coffeeCoin, "coffeeCoin");
		
		GameRegistry.registerItem(caffeine, "caffeine");
		GameRegistry.registerItem(antiCaffeine, "antiCaffeine");
		GameRegistry.registerItem(caffeineTablets, "caffeineTablets");
		GameRegistry.registerItem(antiCaffeineTablets, "antiCaffeineTablets");
	}

	public void load() {
		
	}

	public void postInit() {
		
	}

}
