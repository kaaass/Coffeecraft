package kaaass.coffeecraft.item;

import java.util.List;

import kaaass.coffeecraft.CoffeecraftMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class ItemExtractionFactor extends Item {
	private static String[] name = {"extractionFactor", "fatFactor", "caffeineFactor", "antiCaffeineFactor"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public ItemExtractionFactor(){
		setTextureName(CoffeecraftMain.MODID+":extractionFactor");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("extractionFactor");
		setHasSubtypes(true);
	    setMaxDamage(0);
	    setCreativeTab(CoffeecraftMain.creativeTab);
	}
	
	public String getUnlocalizedName(ItemStack stack){
	    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, name.length - 1);
	    return name[i];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTab, List list){
		for (int i = 0; i < name.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
	    iconArray = new IIcon[name.length];
	    for (int i = 0; i < name.length; i++) {
	    	iconArray[i] = register.registerIcon(getIconString() + "_sub_" + i);
	    }
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage){
	    int a = MathHelper.clamp_int(damage, 0, name.length - 1);
	    return iconArray[a];
	  }
}
