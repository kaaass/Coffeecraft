package kaaass.coffeecraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.caffeine.Caffeine;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemCoffeeBean extends ItemFood {
	private static String[] name = {"steamed", "dried", "baked", "", "burnt"};
	private static String[] type = {"coffeeBean"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public ItemCoffeeBean(){
		super(1, 0.1F, false);
		setTextureName(CoffeecraftMain.MODID+":coffeeBean");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeBean");
		setHasSubtypes(true);
	    setMaxDamage(0);
	}
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
	    if (!world.isRemote){
	    	Caffeine.addCaffeine(player, 13 - stack.getItemDamage());
	    	if(stack.getItemDamage() <= 1 && world.rand.nextInt(4) == 0){
	    		player.addPotionEffect(new PotionEffect(Potion.hunger.id, 200, 0));
	    	}
	    	if(stack.getItemDamage() == 4){
	    		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 0));
	    	}
	    }
	}
	
	public String getUnlocalizedName(ItemStack stack){
	    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, name.length - 1);
	    if(i == 3){
	    	return "item." + type[0];
	    }else{
	    	return "item." + type[0] + "." + name[i];
	    }
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
	
	public static boolean canBake(double tem, int damage){
		switch(damage){
			case -1: //tree fruit
				return tem >= 135 && tem <= 145;
			case 0:
				return tem >= 150 && tem <= 180;
			case 1:
				return tem >= 180 && tem <= 210;
			case 2:
				return tem >= 210 && tem <= 225;
			default:
				return false;
		}
	}
}
