package kaaass.coffeecraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemCoffee extends ItemFood {
	private static String[] name = {"blackCoffee", "milkCoffee", "latte", "mocha", "espresso", "cappuccino"};
	private static String[] type = {"coffee"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray = new IIcon[name.length];
	
	public ItemCoffee(){
		super(0, 0.0F, false);
		setTextureName(CoffeecraftMain.MODID+":coffeeCup");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffee");
		setHasSubtypes(true);
	    setMaxDamage(0);
		setMaxStackSize(32);
	}
	
	public String getUnlocalizedName(ItemStack stack){
	    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, name.length - 1);
	    return "item." + type[0] + "." + name[i];
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
			iconArray[i] = register.registerIcon(CoffeecraftMain.MODID + ":" + type[0] + "_sub_" + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage){
	    int a = MathHelper.clamp_int(damage, 0, name.length - 1);
	    return iconArray[a];
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack){
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack){
		return EnumAction.drink;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
}
