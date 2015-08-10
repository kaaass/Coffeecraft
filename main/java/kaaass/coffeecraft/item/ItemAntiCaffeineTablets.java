package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.caffeine.Caffeine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAntiCaffeineTablets extends ItemFood {
	public ItemAntiCaffeineTablets(){
		super(1, 0.1F, false);
		setTextureName(CoffeecraftMain.MODID+":antiCaffeineTablets");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("antiCaffeineTablets");
	}
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
	    if (!world.isRemote){
	    	Caffeine.reduceCaffeine(player, 15);
	    }
	}
}
