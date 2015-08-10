package kaaass.coffeecraft.caffeine;

import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import kaaass.coffeecraft.CoffeeDamageSource;

public class CaffeineHurt extends TimerTask{
	private EntityPlayer player;
	
	public CaffeineHurt(EntityPlayer player){
		this.player = player;
	}
	
	@Override
	public void run() {
		player.attackEntityFrom(CoffeeDamageSource.toMuchCaffeine, 0.5F);
	}

}
