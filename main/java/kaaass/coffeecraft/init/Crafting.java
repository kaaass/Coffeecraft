package kaaass.coffeecraft.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting extends IInits {
	public Crafting(){
		super("Crafting");
	}
	
	@Override
	public void preLoad() {
		
	}

	@Override
	public void load() {
		GameRegistry.addRecipe(new ItemStack(Items.coffeePill, 1), new Object[]{
			" A ", 
			"ABA",
			" A ",
			'A', Items.fat, 'B', Items.coffeePowder});
		GameRegistry.addRecipe(new ItemStack(Items.coffeeCoin, 1), new Object[]{
			"AAA", 
			"ABA",
			"AAA",
			'A', net.minecraft.init.Items.gold_ingot, 'B', Items.coffeeBean});
		GameRegistry.addRecipe(new ItemStack(Items.caffeineTablet, 1), new Object[]{
			"AA", 
			"AA", 
			'A', Items.caffeine});
		GameRegistry.addRecipe(new ItemStack(Items.antiCaffeineTablet, 1), new Object[]{
			"AA", 
			"AA", 
			'A', Items.antiCaffeine});
		GameRegistry.addRecipe(new ItemStack(Items.extractionFactor, 1, 2), new Object[]{
			"AAA", 
			"ABA",
			"AAA",
			'A', Items.fat, 'B', new ItemStack(Items.extractionFactor, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Items.extractionFactor, 1, 3), new Object[]{
			"AAA", 
			"ABA",
			"AAA",
			'A', Items.caffeine, 'B', new ItemStack(Items.extractionFactor, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Items.extractionFactor, 1, 4), new Object[]{
			"AAA", 
			"ABA",
			"AAA",
			'A', Items.caffeine, 'B', new ItemStack(Items.extractionFactor, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Items.filterNet, 1), new Object[]{
			"BAB", 
			"ABA",
			"BAB",
			'A', net.minecraft.init.Items.paper, 'B', net.minecraft.init.Items.string});
		GameRegistry.addRecipe(new ItemStack(Items.filter, 1), new Object[]{
			"AAA", 
			"ABA",
			"AAA",
			'A', net.minecraft.init.Items.stick, 'B', Items.filterNet});
		GameRegistry.addRecipe(new ItemStack(Items.dirtIngot, 1, 0), new Object[]{
			"AAA", 
			'A', net.minecraft.init.Blocks.dirt});
		GameRegistry.addRecipe(new ItemStack(Items.coffeeCup, 1), new Object[]{
			"A A", 
			" A ", 
			'A', new ItemStack(Items.dirtIngot, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Blocks.coffeeBaker, 1), new Object[]{
			"DED", 
			"CBC",
			"DAD",
			'A', net.minecraft.init.Blocks.furnace, 'B', Items.coffeeCore, 
			'C', net.minecraft.init.Items.diamond, 'D', net.minecraft.init.Blocks.obsidian,
			'E', net.minecraft.init.Items.water_bucket});
		GameRegistry.addRecipe(new ItemStack(Blocks.coffeeGrinder, 1), new Object[]{
			"ACA", 
			"BDB",
			"AEA",
			'A', net.minecraft.init.Blocks.iron_block, 'B', net.minecraft.init.Items.diamond, 
			'C', net.minecraft.init.Blocks.piston, 'D', Items.coffeeCore,
			'E', net.minecraft.init.Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(Blocks.extractingMachine, 1), new Object[]{
			"ACA", 
			"BDB",
			"BEB",
			'A', net.minecraft.init.Items.redstone, 'B', net.minecraft.init.Items.iron_ingot, 
			'C', Items.coffeeCore, 'D', new ItemStack(Items.extractionFactor, 1, 0),
			'E', new ItemStack(Items.extractionFactor, 1, 1)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.extractionFactor, 1, 1), new Object[]{new ItemStack(Items.extractionFactor, 1, 0), net.minecraft.init.Items.fermented_spider_eye});
		
		GameRegistry.addSmelting(Blocks.factorOre, new ItemStack(Items.extractionFactor, 1, 0), 2F);
		
		OreDictionary.registerOre("factorOre", new ItemStack(Blocks.factorOre));
		
		this.tradeInit();
	}

	@Override
	public void postInit() {
		
	}

	private void tradeInit(){
		TradeRegistry.addTrade(new ItemStack(Items.coffee, 1, 0), 2, 15, 5);
		TradeRegistry.addTrade(new ItemStack(Items.coffee, 1, 1), 4, 20, 7);
		TradeRegistry.addTrade(new ItemStack(Items.coffee, 1, 2), 7, 30, 11);
		TradeRegistry.addTrade(new ItemStack(Items.coffee, 1, 3), 7, 30, 13);
		TradeRegistry.addTrade(new ItemStack(Items.coffee, 1, 4), 6, 25, 9);
		TradeRegistry.addTrade(new ItemStack(Items.coffee, 1, 5), 7, 30, 13);
		TradeRegistry.addTrade(Items.cocoaPowder, 1, 8, 1);
		TradeRegistry.addTrade(Items.cocoaPowder, 2, 8, 1);
		TradeRegistry.addTrade(Items.cocoaPowder, 2, 7, 2);
		TradeRegistry.addTrade(Items.cocoaPowder, 3, 8, 1);
		TradeRegistry.addTrade(Items.coffeeCore, 8, 233333, 102);
		TradeRegistry.addTrade(Items.coffeeCore, 9, 233333, 110);
		TradeRegistry.addTrade(Items.coffeeCore, 9, 233333, 100);
		TradeRegistry.addTrade(Items.coffeeCore, 9, 233333, 110);
		TradeRegistry.addTrade(Items.coffeeCore, 9, 233333, 103);
		TradeRegistry.addTrade(Items.coffeeCore, 9, 912450, 150);
		TradeRegistry.addTrade(Items.coffeeCore, 10, 233333, 113);
		TradeRegistry.addTrade(Items.coffeePill, 1, 12, 3);
		TradeRegistry.addTrade(Items.coffeePill, 1, 11, 2);
		TradeRegistry.addTrade(Items.coffeePill, 2, 13, 1);
		TradeRegistry.addTrade(Items.coffeePill, 2, 12, 3);
		TradeRegistry.addTrade(Items.coffeeCup, 2, 45, 12);
		TradeRegistry.addTrade(Items.caffeineTablet, 2, 28, 18);
		TradeRegistry.addTrade(Items.antiCaffeineTablet, 3, 36, 21);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 121, 7);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 124, 7);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 123, 5);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 124, 6);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 120, 7);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 123, 1);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 123, 7);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 150, 7);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 146, 4);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 135, 5);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 132, 7);
		TradeRegistry.addTrade(Items.coffeeCoin, 2, 122, 21);
		TradeRegistry.addTrade(Items.coffeeCoin, 3, 97, 6);
		TradeRegistry.addTrade(Item.getItemFromBlock(net.minecraft.init.Blocks.bedrock), 23333333, 10086110, 0);
		TradeRegistry.addTrade(Item.getItemFromBlock(net.minecraft.init.Blocks.glowstone), 2, 35, 26);
		for(int i = 0; i < 4; i++){
			TradeRegistry.addTrade(Item.getItemFromBlock(net.minecraft.init.Blocks.obsidian), 7, 72 + i, 43 - i);
			TradeRegistry.addTrade(Item.getItemFromBlock(net.minecraft.init.Blocks.ice), 2, 32 + i, 9 - i);
			TradeRegistry.addTrade(Item.getItemFromBlock(net.minecraft.init.Blocks.netherrack), 3, 45 + i, 26 - i);
			TradeRegistry.addTrade(Item.getItemFromBlock(net.minecraft.init.Blocks.soul_sand), 5, 64 + i, 36 - i);
		}
		for(int i = 0; i < 3; i++){
			TradeRegistry.addTrade(net.minecraft.init.Items.iron_ingot, 2, 42 + i, 13 - i);
			TradeRegistry.addTrade(net.minecraft.init.Items.golden_apple, 2, 42 + i, 13 - i);
			TradeRegistry.addTrade(net.minecraft.init.Items.book, 1, 53 + i, 21 - i);
			TradeRegistry.addTrade(Item.getItemById(387), 3, 22 + i, 9 - i);
		}
		TradeRegistry.addTrade(new ItemStack(net.minecraft.init.Items.golden_apple, 1, 1), 2, 82, 23);
		TradeRegistry.addTrade(net.minecraft.init.Items.apple, 1, 22, 20);
	}
}
