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
			'A', Item.getItemById(266), 'B', Items.coffeeBean});
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
			'A', Item.getItemById(339), 'B', Item.getItemById(287)});
		GameRegistry.addRecipe(new ItemStack(Items.filter, 1), new Object[]{
			"AAA", 
			"ABA",
			"AAA",
			'A', Item.getItemById(280), 'B', Items.filterNet});
		GameRegistry.addRecipe(new ItemStack(Items.dirtIngot, 1, 0), new Object[]{
			"AAA", 
			'A', Block.getBlockById(3)});
		GameRegistry.addRecipe(new ItemStack(Items.coffeeCup, 1), new Object[]{
			"A A", 
			" A ", 
			'A', new ItemStack(Items.dirtIngot, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Blocks.coffeeBaker, 1), new Object[]{
			"DED", 
			"CBC",
			"DAD",
			'A', Block.getBlockById(61), 'B', Items.coffeeCore, 
			'C', Item.getItemById(264), 'D', Block.getBlockById(49),
			'E', Item.getItemById(326)});
		GameRegistry.addRecipe(new ItemStack(Blocks.coffeeGrinder, 1), new Object[]{
			"ACA", 
			"BDB",
			"AEA",
			'A', Block.getBlockById(42), 'B', Item.getItemById(264), 
			'C', Block.getBlockById(33), 'D', Items.coffeeCore,
			'E', Block.getBlockById(152)});
		GameRegistry.addRecipe(new ItemStack(Blocks.extractingMachine, 1), new Object[]{
			"ACA", 
			"BDB",
			"BEB",
			'A', Item.getItemById(331), 'B', Item.getItemById(265), 
			'C', Items.coffeeCore, 'D', new ItemStack(Items.extractionFactor, 1, 0),
			'E', new ItemStack(Items.extractionFactor, 1, 1)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.extractionFactor, 1, 1), new Object[]{new ItemStack(Items.extractionFactor, 1, 0), Item.getItemById(376)});
		
		GameRegistry.addSmelting(Blocks.factorOre, new ItemStack(Items.extractionFactor, 1, 0), 2F);
		
		OreDictionary.registerOre("factorOre", new ItemStack(Blocks.factorOre));
	}

	@Override
	public void postInit() {
		
	}

}
