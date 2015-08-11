package kaaass.coffeecraft.init;

import kaaass.coffeecraft.item.ItemAntiCaffeine;
import kaaass.coffeecraft.item.ItemAntiCaffeineTablet;
import kaaass.coffeecraft.item.ItemCaffeine;
import kaaass.coffeecraft.item.ItemCaffeineTablet;
import kaaass.coffeecraft.item.ItemCoffeeBean;
import kaaass.coffeecraft.item.ItemCoffeeCoin;
import kaaass.coffeecraft.item.ItemCoffeeCore;
import kaaass.coffeecraft.item.ItemCoffeePill;
import kaaass.coffeecraft.item.ItemCoffeePowder;
import kaaass.coffeecraft.item.ItemCoffeeTreeFruit;
import kaaass.coffeecraft.item.ItemCoffeeTreeSapling;
import kaaass.coffeecraft.item.ItemExtractionFactor;
import kaaass.coffeecraft.item.ItemFat;
import kaaass.coffeecraft.item.ItemFilter;
import kaaass.coffeecraft.item.ItemFilterNet;
import net.minecraft.item.Item;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Items extends IInits{
	public static Item coffeeTreeFruit;
	public static Item coffeeTreeSapling;
	public static Item coffeeBean;
	public static Item coffeePowder;
	public static Item coffeePill;
	public static Item coffeeCoin;
	public static Item coffeeCore;
	
	public static Item caffeine;
	public static Item antiCaffeine;
	public static Item caffeineTablet;
	public static Item antiCaffeineTablet;
	
	public static Item fat;
	public static Item extractionFactor;
	public static Item filterNet;
	public static Item filter;
	
	public Items(){
		super("Items");
	}
	
	public void preLoad() {
		coffeeTreeFruit = new ItemCoffeeTreeFruit();
		coffeeTreeSapling = new ItemCoffeeTreeSapling();
		coffeeBean = new ItemCoffeeBean();
		coffeePowder = new ItemCoffeePowder();
		coffeePill = new ItemCoffeePill();
		coffeeCoin = new ItemCoffeeCoin();
		coffeeCore = new ItemCoffeeCore();
		
		caffeine = new ItemCaffeine();
		antiCaffeine = new ItemAntiCaffeine();
		caffeineTablet = new ItemCaffeineTablet();
		antiCaffeineTablet = new ItemAntiCaffeineTablet();
		
		fat = new ItemFat();
		extractionFactor = new ItemExtractionFactor();
		filterNet = new ItemFilterNet();
		filter = new ItemFilter();
		
		GameRegistry.registerItem(coffeeTreeFruit, "coffeeTreeFruit");
		GameRegistry.registerItem(coffeeTreeSapling, "coffeeTreeSapling");
		GameRegistry.registerItem(coffeeBean, "coffeeBean");
		GameRegistry.registerItem(coffeePowder, "coffeePowder");
		GameRegistry.registerItem(coffeePill, "coffeePill");
		GameRegistry.registerItem(coffeeCoin, "coffeeCoin");
		GameRegistry.registerItem(coffeeCore, "coffeeCore");
		
		GameRegistry.registerItem(caffeine, "caffeine");
		GameRegistry.registerItem(antiCaffeine, "antiCaffeine");
		GameRegistry.registerItem(caffeineTablet, "caffeineTablet");
		GameRegistry.registerItem(antiCaffeineTablet, "antiCaffeineTablet");
		
		GameRegistry.registerItem(fat, "fat");
		GameRegistry.registerItem(extractionFactor, "extractionFactor");
		GameRegistry.registerItem(filterNet, "filterNet");
		GameRegistry.registerItem(filter, "filter");
	}

	public void load() {
		
	}

	public void postInit() {
		
	}

}
