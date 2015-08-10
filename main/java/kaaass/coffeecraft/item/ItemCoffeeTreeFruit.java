package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.caffeine.Caffeine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCoffeeTreeFruit extends ItemFood {
	public ItemCoffeeTreeFruit(){
		super(1, 0.1F, false);
		setTextureName(CoffeecraftMain.MODID+":coffeeTreeFruit");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeeTreeFruit");
	}
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
	    if (!world.isRemote){
	    	Caffeine.addCaffeine(player, 10);
	    	if(world.rand.nextInt(5) == 0){
	    		if(world.rand.nextInt(4) == 0){
	    			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 600, 0));
	    		}else{
	    			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 200, 0));
	    		}
	    	}
	    }
	}
}
