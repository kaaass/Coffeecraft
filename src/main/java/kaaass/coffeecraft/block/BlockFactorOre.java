package kaaass.coffeecraft.block;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class BlockFactorOre extends Block {
	public BlockFactorOre(){
		super(Material.rock);
		setCreativeTab(CoffeecraftMain.creativeTab);
		setBlockName("factorOre");
		setBlockTextureName(CoffeecraftMain.MODID+":factorOre");
		setHardness(5.0F);
		setStepSound(soundTypeStone);
	}
	
	public boolean canHarvestBlock(EntityPlayer player, int meta){
		Item tool = player.inventory.getCurrentItem().getItem();
		if(tool instanceof ItemPickaxe){
			if(((ItemPickaxe)tool).func_150913_i().getHarvestLevel() > 1){
				return true;
			}
		}
	    return false;
	}
}
