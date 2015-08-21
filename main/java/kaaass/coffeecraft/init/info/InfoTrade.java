package kaaass.coffeecraft.init.info;

import java.util.ArrayList;
import java.util.List;

import kaaass.coffeecraft.init.Items;
import kaaass.coffeecraft.init.TradeRegistry;
import kaaass.coffeecraft.util.NBTUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class InfoTrade {
	private static final int[] level = {1, 4, 8, 14, 20, 26, 34, 42, 50};
	
	private static final String NBT_ROOT = "CoffeeTradeInfo";
	private static final String NBT_TRADE = "Trade";
	
	private Item get;
	private int[] cost = new int[2];
	private int exp = 0;
	private int damage = 0;
	
	public InfoTrade(Item get){
		this(get, 1, 10, 1);
	}
	
	public InfoTrade(Item get, int cost){
		this(get, cost, 10, 1);
	}
	
	public InfoTrade(Item get, int cost, int exp){
		this(get, cost, exp, 1);
	}
	
	public InfoTrade(Item get, int cost, int exp, int expGet){
		this.get = get;
		this.cost[0] = cost;
		this.cost[1] = exp;
		this.exp = expGet;
	}
	
	public InfoTrade(Item get, int damage, int cost, int exp, int expGet){
		this.get = get;
		this.cost[0] = cost;
		this.cost[1] = exp;
		this.exp = expGet;
		this.damage = damage;
	}
	
	public ItemStack getOut(){
		return new ItemStack(get, 1, damage);
	}
	
	public Item getOutItem(){
		return get;
	}
	
	public int[] getCost(){
		return cost;
	}
	
	public String getInfo(){
		return "Coin:" + cost[0] + " Exp:" + cost[1];
	}
	
	public String getTexture(){
		return this.get.getIconFromDamage(damage).getIconName();
	}
	
	public static List<InfoTrade> readTrade(EntityPlayer player){
		NBTTagCompound persisted = NBTUtils.getPersistedFromPlayer(player);
		List<InfoTrade> result = new ArrayList();
		int[] a;
		if (persisted.hasKey(NBT_ROOT)){
			a = persisted.getCompoundTag(NBT_ROOT).getIntArray(NBT_TRADE);
	        for(int i = 0; i < a.length; i++){
	        	result.add(TradeRegistry.getTradeById(a[i]));
	        }
        }
		return null;
	}
	
	public static void writeTrade(EntityPlayer player, List<InfoTrade> trade){
		NBTTagCompound persisted = NBTUtils.getPersistedFromPlayer(player);
		int[] result = new int[trade.size()];
		if (!persisted.hasKey(NBT_ROOT)){
			persisted.setTag(NBT_ROOT, new NBTTagCompound());
        }
		for(int i = 0; i < trade.size(); i++){
			result[i] = TradeRegistry.getIdByTrade(trade.get(i));
        }
		persisted.getCompoundTag(NBT_ROOT).setIntArray(NBT_TRADE, result);
	}
	
	public static int getLevelFromTrade(int times){
		for(int i = 1; i <= level.length; i++){
			if(times < level[i - 1]){
				return i;
			}
		}
		return 10 + (int) Math.floor((times - 50) / 10);
	}
	
	public static boolean isUpLevel(int times){
		for(int i = 0; i < level.length; i++){
			if(times == level[i]){
				return true;
			}
		}
		return (times - 50) % 10 == 0;
	}
	
	public boolean equals(InfoTrade a){
		return a == null ? a == this : this.get == a.get;
	}
}