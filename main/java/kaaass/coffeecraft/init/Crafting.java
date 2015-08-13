package kaaass.coffeecraft.init;

import java.util.ArrayList;
import java.util.List;

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
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.extractionFactor, 1, 1), new Object[]{new ItemStack(Items.extractionFactor, 1, 0), Item.getItemById(376)});
		
		GameRegistry.addSmelting(Blocks.factorOre, new ItemStack(Items.extractionFactor, 1, 0), 2F);
		
		OreDictionary.registerOre("factorOre", new ItemStack(Blocks.factorOre));
	}

	@Override
	public void postInit() {
		
	}

}
