package kaaass.coffeecraft.block;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFactorOre extends Block {
	public BlockFactorOre(){
		super(Material.rock);
		setCreativeTab(CoffeecraftMain.creativeTab);
		setHardness(3.0F);
		setStepSound(soundTypeStone);
	}
}
