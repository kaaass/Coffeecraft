package kaaass.coffeecraft.init;

import kaaass.coffeecraft.block.BlockCoffeeBaker;
import kaaass.coffeecraft.block.BlockCoffeeTreeFruit;
import kaaass.coffeecraft.block.BlockCoffeeTreeLeave;
import kaaass.coffeecraft.block.BlockCoffeeTreeSapling;
import kaaass.coffeecraft.block.BlockFactorOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks extends IInits{
	public static Block coffeeBaker;
	
	public static Block coffeeTreeFruitBlock;
	public static Block coffeeTreeLeaveBlock;
	public static Block coffeeTreeSaplingBlock;
	public static Block factorOre;
	
	public Blocks(){
		super("Blocks");
	}
	
	@Override
	public void preLoad() {
		coffeeBaker = new BlockCoffeeBaker();
		
		coffeeTreeFruitBlock = new BlockCoffeeTreeFruit();
		coffeeTreeLeaveBlock = new BlockCoffeeTreeLeave();
		coffeeTreeSaplingBlock = new BlockCoffeeTreeSapling();
		factorOre = new BlockFactorOre();
		
		GameRegistry.registerBlock(coffeeBaker, "coffeeBaker");
		
		GameRegistry.registerBlock(coffeeTreeFruitBlock, "coffeeTreeFruitBlock");
		GameRegistry.registerBlock(coffeeTreeLeaveBlock, "coffeeTreeLeaveBlock");
		GameRegistry.registerBlock(coffeeTreeSaplingBlock, "coffeeTreeSaplingBlock");
		GameRegistry.registerBlock(factorOre, "factorOre");
	}

	@Override
	public void load() {
		
	}

	@Override
	public void postInit() {
		
	}

}
