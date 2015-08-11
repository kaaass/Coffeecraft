package kaaass.coffeecraft.caffeine;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;

public class CaffeineReduce extends TimerTask{
	private EntityPlayer player;
	private Random rand;
	private Timer timer;
	
	public CaffeineReduce(EntityPlayer player, Timer timer){
		this.player = player;
		this.timer = timer;
		rand = player.worldObj.rand;
	}
	
	@Override
	public void run() {
		if(rand.nextInt(10) <= 2 && Caffeine.getCaffeineFromPlayer(player) > 0){
			Caffeine.reduceCaffeine(player, rand.nextInt(4) + 1);
			if(Caffeine.getCaffeineFromPlayer(player) < 0){
				Caffeine.setCaffeine(player, 0);
				timer.cancel();
			}
		}
	}

}
