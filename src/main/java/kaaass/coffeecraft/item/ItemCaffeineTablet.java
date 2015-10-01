package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.caffeine.Caffeine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCaffeineTablet extends ItemFood {
	public ItemCaffeineTablet(){
		super(1, 0.1F, false);
		setTextureName(CoffeecraftMain.MODID+":caffeineTablet");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("caffeineTablet");
	}
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
	    if (!world.isRemote){
	    	Caffeine.addCaffeine(player, 35);
	    }
	}
}
