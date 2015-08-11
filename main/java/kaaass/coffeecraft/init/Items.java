package kaaass.coffeecraft.init;

import kaaass.coffeecraft.item.ItemAntiCaffeine;
import kaaass.coffeecraft.item.ItemAntiCaffeineTablets;
import kaaass.coffeecraft.item.ItemCaffeine;
import kaaass.coffeecraft.item.ItemCaffeineTablets;
import kaaass.coffeecraft.item.ItemCoffeeBean;
import kaaass.coffeecraft.item.ItemCoffeeCoin;
import kaaass.coffeecraft.item.ItemCoffeeTreeFruit;
import kaaass.coffeecraft.item.ItemCoffeeTreeSapling;
import kaaass.coffeecraft.item.ItemExtractionFactor;
import kaaass.coffeecraft.item.ItemFat;
import net.minecraft.item.Item;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Items extends IInits{
	public static Item coffeeTreeFruit;
	public static Item coffeeTreeSapling;
	public static Item coffeeBean;
	public static Item coffeeCoin;
	
	public static Item caffeine;
	public static Item antiCaffeine;
	public static Item caffeineTablets;
	public static Item antiCaffeineTablets;
	
	public static Item fat;
	public static Item extractionFactor;
	
	public Items(){
		super("Items");
	}
	
	public void preLoad() {
		coffeeTreeFruit = new ItemCoffeeTreeFruit();
		coffeeTreeSapling = new ItemCoffeeTreeSapling();
		coffeeBean = new ItemCoffeeBean();
		coffeeCoin = new ItemCoffeeCoin();
		
		caffeine = new ItemCaffeine();
		antiCaffeine = new ItemAntiCaffeine();
		caffeineTablets = new ItemCaffeineTablets();
		antiCaffeineTablets = new ItemAntiCaffeineTablets();
		
		fat = new ItemFat();
		extractionFactor = new ItemExtractionFactor();
		
		GameRegistry.registerItem(coffeeTreeFruit, "coffeeTreeFruit");
		GameRegistry.registerItem(coffeeTreeSapling, "coffeeTreeSapling");
		GameRegistry.registerItem(coffeeBean, "coffeeBean");
		GameRegistry.registerItem(coffeeCoin, "coffeeCoin");
		
		GameRegistry.registerItem(caffeine, "caffeine");
		GameRegistry.registerItem(antiCaffeine, "antiCaffeine");
		GameRegistry.registerItem(caffeineTablets, "caffeineTablets");
		GameRegistry.registerItem(antiCaffeineTablets, "antiCaffeineTablets");
		
		GameRegistry.registerItem(fat, "fat");
		GameRegistry.registerItem(extractionFactor, "extractionFactor");
	}

	public void load() {
		
	}

	public void postInit() {
		
	}

}
