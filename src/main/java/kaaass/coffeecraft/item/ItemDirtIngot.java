package kaaass.coffeecraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import kaaass.coffeecraft.CoffeecraftMain;

public class ItemDirtIngot extends Item{
	private static String[] name = {"dirtIngot", "chinaIngot"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray = new IIcon[name.length];
	
	public ItemDirtIngot(){
		setTextureName(CoffeecraftMain.MODID+":dirtIngot");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("dirtIngot");
		setHasSubtypes(true);
	    setMaxDamage(0);
	    setMaxStackSize(16);
	}
	
	public String getUnlocalizedName(ItemStack stack){
	    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, name.length - 1);
	    return "item." + name[i];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTab, List list){
		for (int i = 0; i < name.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		for(int i = 0; i < iconArray.length; i++){
			iconArray[i] = register.registerIcon(CoffeecraftMain.MODID + ":dirtIngot_sub_" + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage){
	    int a = MathHelper.clamp_int(damage, 0, name.length - 1);
	    return iconArray[a];
	}
}
