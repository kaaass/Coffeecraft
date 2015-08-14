package kaaass.coffeecraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.init.Gui;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCoffeeBaker extends BlockContainer {
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public BlockCoffeeBaker(){
		super(Material.rock);
		setHardness(3.0F);
		setCreativeTab(CoffeecraftMain.creativeTab);
		setBlockName("coffeeBaker");
		setStepSound(soundTypeStone);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register){
		iconArray = new IIcon[2];
		iconArray[0] = register.registerIcon(CoffeecraftMain.MODID+":coffeeBaker");
		iconArray[1] = register.registerIcon(CoffeecraftMain.MODID+":back");
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int faceTo, int metadata){
		if(metadata == 0 && faceTo == 3){
			return iconArray[0];
		}
		if (faceTo != metadata) {
			return iconArray[1];
		}
		return iconArray[0];
    }
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack){
	    int i = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
	    if (i == 0){
	    	world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	    }
	    if (i == 1){
	    	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	    }
	    if (i == 2){
	    	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	    }
	    if (i == 3){
	    	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	    }
	}

	@Override
	public TileEntity createNewTileEntity(World world, int arg1) {
		return new TileEntityCoffeeBaker();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		player.openGui(CoffeecraftMain.instance, Gui.COFFEE_BAKER_ID, world, x, y, z);
		return true;
	}
}
