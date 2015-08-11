package kaaass.coffeecraft.init;

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
		GameRegistry.addRecipe(new ItemStack(Items.coffeeCoin, 1), new Object[]{
			"AAA", 
			"ABA",
			"AAA",
			'A', Item.getItemById(266), 'B', Items.coffeeBean});
		GameRegistry.addRecipe(new ItemStack(Items.caffeineTablets, 1), new Object[]{
			"AA", 
			"AA", 
			'A', Items.caffeine});
		GameRegistry.addRecipe(new ItemStack(Items.antiCaffeineTablets, 1), new Object[]{
			"AA", 
			"AA", 
			'A', Items.antiCaffeine});
		
		GameRegistry.addSmelting(Blocks.factorOre, new ItemStack(Items.extractionFactor, 1, 0), 2F);
		
		OreDictionary.registerOre("factorOre", new ItemStack(Blocks.factorOre));
	}

	@Override
	public void postInit() {
		
	}

}
