package kaaass.coffeecraft.item;

import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.caffeine.Caffeine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCoffeePill extends ItemFood {
	public ItemCoffeePill(){
		super(4, 3.5F, false);
		setTextureName(CoffeecraftMain.MODID+":coffeePill");
		setCreativeTab(CoffeecraftMain.creativeTab);
		setUnlocalizedName("coffeePill");
		setMaxStackSize(16);
	}
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
	    if (!world.isRemote){
	    	Caffeine.addCaffeine(player, 10 + world.rand.nextInt(5));
	    	player.setHealth(player.getHealth() + 4);
	    	if(world.rand.nextInt(7) <= 1){
	    		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600 + world.rand.nextInt(4) * 300, 0));
	    	}
	    }
	}
}