package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import kaaass.coffeecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemCoffeeTreeSapling extends Item implements IPlantable {
	public ItemCoffeeTreeSapling(){
		setTextureName(CoffeecraftMain.MODID+":coffeeTreeSapling");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeTreeSapling");
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		if (par7 != 1){
			return false;
		}else if (player.canPlayerEdit(par4, par5, par6, par7, stack) && player.canPlayerEdit(par4, par5 + 1, par6, par7, stack)){
            Block soil = world.getBlock(par4, par5, par6);
            if (soil != null && canPlaceBlockOn(soil) && world.isAirBlock(par4, par5 + 1, par6)) {
            	world.setBlock(par4, par5 + 1, par6, Blocks.coffeeTreeSaplingBlock);
                --stack.stackSize;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
	}
	
	private boolean canPlaceBlockOn(Block arg0){
		return arg0 == Block.getBlockById(2) || arg0 == Block.getBlockById(3);
	}

	@Override
	public Block getPlant(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return Blocks.coffeeTreeSaplingBlock;
	}

	@Override
	public int getPlantMetadata(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return 0;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return EnumPlantType.Crop;
	}
}
