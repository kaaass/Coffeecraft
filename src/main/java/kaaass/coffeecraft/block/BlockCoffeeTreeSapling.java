package kaaass.coffeecraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.init.Blocks;
import kaaass.coffeecraft.init.Items;
import kaaass.coffeecraft.world.gen.feature.WorldGenCoffeeTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockCoffeeTreeSapling extends BlockBush {
private IIcon icon;
	
	public BlockCoffeeTreeSapling(){
		super(Material.plants);
	    float f = 0.4F;
	    setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	    setBlockTextureName(CoffeecraftMain.MODID+":coffeeTreeSaplingBlock");
	}
	
	public void updateTick(World world, int x, int y, int z, Random rand){
		super.updateTick(world, x, y, z, rand);
	}
	
	public void treeGene(World world, int x, int y, int z, Random rand){
		if (!TerrainGen.saplingGrowTree(world, rand, x, y, z)){
			return;
		}
		int meta = world.getBlockMetadata(x, y, z) & 3;
		Object object = new WorldGenCoffeeTree();
		world.setBlockToAir(x, y, z);
		if (!((WorldGenerator)object).generate(world, rand, x, y, z)){
			world.setBlock(x, y, z, this, meta, 4);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister arg0){
		icon = arg0.registerIcon(CoffeecraftMain.MODID+":coffeeTreeSaplingBlock");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return icon;
	}
	
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z){
		return EnumPlantType.Plains;
	}
	
	public void dropBlockAsItemWithChance(World world, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_){
	    if ((!world.isRemote)){
	          dropBlockAsItem(world, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.coffeeTreeSapling, 1, 0));
	    }
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block arg0){
		return arg0 == Block.getBlockById(2) || arg0 == Block.getBlockById(3);
	}
	
	@Override
	public boolean canBlockStay(World arg0, int arg1, int arg2, int arg3){
		return canPlaceBlockOn(arg0.getBlock(arg1, arg2 - 1, arg3));
	}
}
