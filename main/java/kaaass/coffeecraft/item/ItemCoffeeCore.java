package kaaass.coffeecraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kaaass.coffeecraft.CoffeecraftMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

public class ItemCoffeeCore extends Item{
	public ItemCoffeeCore(){
		setTextureName(CoffeecraftMain.MODID+":coffeeCore");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeCore");
		setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack){
	    return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool){
		list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("info.coffeeCore"));
	}
}
