package kaaass.coffeecraft.caffeine;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import kaaass.coffeecraft.CoffeeDamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Caffeine {
	public final static int sleepCaffeineValue = 25;
	public final static int nightVCaffeineValue = 80;
	public final static int hurtCaffeineValue = 85;
	
	private static List<EntityPlayer> playerList = new ArrayList();
	private static List<String> nameList = new ArrayList();
	private static List<Integer> caffeineList = new ArrayList();
	
	private static Timer timer;
	private static Timer timer2;
	
	public static void addPlayer(EntityPlayer player){
		playerList.add(player);
		nameList.add(player.getDisplayName());
		caffeineList.add(0);
		CaffeinePlayerInfo.onUse(player, 0);
	}
	
	public static void addPlayer(EntityPlayer player, int caffeine){
		playerList.add(player);
		nameList.add(player.getDisplayName());
		caffeineList.add(caffeine);
		CaffeinePlayerInfo.onUse(player, caffeine);
	}
	
	public static void removePlayer(EntityPlayer player){
		int a = find(player);
		playerList.remove(a);
		nameList.remove(a);
		caffeineList.remove(a);
		CaffeinePlayerInfo.onUse(player, 0);
	}
	
	public static void addCaffeine(EntityPlayer player, int add){
		int a = find(player);
		if(a != -1){
			caffeineList.add(a, caffeineList.get(a) + add);
		}
		CaffeinePlayerInfo.onUse(player, caffeineList.get(a));
		update(player.worldObj, player);
	}
	
	public static void reduceCaffeine(EntityPlayer player, int reduce){
		int a = find(player);
		if(a != -1){
			caffeineList.add(a, caffeineList.get(a) - reduce);
		}
		CaffeinePlayerInfo.onUse(player, caffeineList.get(a));
		update(player.worldObj, player);
	}
	
	public static int setCaffeine(EntityPlayer player, int caffeine){
		int a = find(player);
		if(a != -1){
			caffeineList.add(a, caffeine);
			update(player.worldObj, player);
			CaffeinePlayerInfo.onUse(player, caffeine);
		}
		return a;
	}
	
	public static int setCaffeine(String name, int caffeine){
		int a = find(name);
		if(a != -1){
			caffeineList.add(a, caffeine);
			update(playerList.get(a).worldObj, playerList.get(a));
			CaffeinePlayerInfo.onUse(playerList.get(a), caffeine);
		}
		return a;
	}
	
	public static int getCaffeineFromPlayer(EntityPlayer player){
		int a = find(player);
		if(a != -1){
			return caffeineList.get(a);
		}else{
			return -1;
		}
	}
	
	public static int getCaffeineFromName(String name){
		int a = find(name);
		if(a != -1){
			return caffeineList.get(a);
		}else{
			return -1;
		}
	}
	
	private static int find(EntityPlayer player){
		for(int i = 0; i < playerList.size(); i++){
			if(playerList.get(i) == player){
				return i;
			}
		}
		return -1;
	}
	
	private static int find(String name){
		for(int i = 0; i < nameList.size(); i++){
			if(nameList.get(i) == name){
				return i;
			}
		}
		return -1;
	}
	
	public static void update(World world, EntityPlayer player){
		if(getCaffeineFromPlayer(player) >= hurtCaffeineValue){
			timer = new Timer();
			timer.scheduleAtFixedRate(new CaffeineHurt(player), 1 / 20, 1500);
			timer2 = new Timer();
			timer2.scheduleAtFixedRate(new CaffeineReduce(player, timer2), 1 / 20, 2000);
			player.addPotionEffect(new PotionEffect(Potion.weakness.id, 3600, 0));
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 1200, 0));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1800, 0));
		}else if(getCaffeineFromPlayer(player) >= nightVCaffeineValue){
			if(world.rand.nextInt(9) == 0){
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 600, 0));
			}else{
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 0));
			}
		}
	}
}
