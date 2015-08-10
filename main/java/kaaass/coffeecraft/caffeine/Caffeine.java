package kaaass.coffeecraft.caffeine;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public class Caffeine {
	public final static int sleepCaffeineValue = 20;
	public final static int nightVCaffeineValue = 80;
	public final static int hurtCaffeineValue = 85;
	
	private static List<EntityPlayer> playerList = new ArrayList();
	private static List<Integer> caffeineList = new ArrayList();
	
	public static void addPlayer(EntityPlayer player){
		playerList.add(player);
		caffeineList.add(0);
	}
	
	public static void addPlayer(EntityPlayer player, int caffeine){
		playerList.add(player);
		caffeineList.add(caffeine);
	}
	
	public static void removePlayer(EntityPlayer player){
		int a = find(player);
		playerList.remove(a);
		caffeineList.remove(a);
	}
	
	public static void setCaffeine(EntityPlayer player, int caffeine){
		int a = find(player);
		if(a != -1){
			caffeineList.add(a, caffeine);
		}
	}
	
	public static void addCaffeine(EntityPlayer player, int add){
		int a = find(player);
		if(a != -1){
			caffeineList.add(a, caffeineList.get(a) + add);
		}
		CaffeinePlayerInfo.onUse(player, caffeineList.get(a));
	}
	
	public static int getCaffeineFromPlayer(EntityPlayer player){
		int a = find(player);
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
}
