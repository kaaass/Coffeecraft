package kaaass.coffeecraft.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import kaaass.coffeecraft.init.info.InfoTrade;

public class TradeRegistry {
	private static List<InfoTrade> trade = new ArrayList();
	
	public static void addTrade(Item get){
		addTrade(get, 1, 10, 1);
	}
	
	public static void addTrade(Item get, int cost){
		addTrade(get, cost, 10, 1);
	}
	
	public static void addTrade(Item get, int cost, int exp){
		addTrade(get, cost, exp, 1);
	}
	
	public static void addTrade(Item get, int cost, int exp, int expGet){
		addTrade(new ItemStack(get), cost, exp, expGet);
	}
	
	public static void addTrade(ItemStack get, int cost, int exp, int expGet){
		InfoTrade a = new InfoTrade(get.getItem(), get.getItemDamage(), cost, exp, expGet);
		trade.add(a);
	}
	
	public static InfoTrade getTradeById(int id){
		return trade.get(id);
	}
	
	public static int getIdByTrade(InfoTrade t){
		return trade.indexOf(t);
	}
	
	public static int getIdByItem(Item item){
		for(int i = 0; i < trade.size(); i++){
			if(trade.get(i).getOutItem() == item){
				return i;
			}
		}
		return 0;
	}
	
	public static InfoTrade getTradeByItem(Item item){
		return getTradeById(getIdByItem(item));
	}
	
	public static InfoTrade getRandomTrade(Random rand){
		return getTradeById(rand.nextInt(trade.size()));
	}
}
