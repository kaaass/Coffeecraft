package kaaass.coffeecraft.caffeine;

import kaaass.coffeecraft.network.PacketMain;
import kaaass.coffeecraft.network.packet.PacketCaffeineInfo;
import kaaass.coffeecraft.util.NBTUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class CaffeinePlayerInfo {
	private static final String NBT_ROOT = "CaffeinePlayerInfo";
	private static final String NBT_CAFFEINE = "Caffeine";
	
	public static int read(EntityPlayer player){
		NBTTagCompound persisted = NBTUtils.getPersistedFromPlayer(player);
        if (persisted.hasKey(NBT_ROOT)){
        	return read(persisted);
        }
        return 0;
    }
	
	public static int read(NBTTagCompound tagCompound){
		int caffeine = 0;
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        caffeine = root.getInteger(NBT_CAFFEINE);
        return caffeine;
    }
	
	public static void write(EntityPlayer player, int caffeine){
        NBTTagCompound persisted = NBTUtils.getPersistedFromPlayer(player);
        write(persisted, caffeine);
    }

    public static void write(NBTTagCompound tagCompound, int caffeine){
        if (!tagCompound.hasKey(NBT_ROOT)){
        	tagCompound.setTag(NBT_ROOT, new NBTTagCompound());
        }
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        root.setInteger(NBT_CAFFEINE, caffeine);
    }
    
    public static void onLogin(EntityPlayer player){
    	PacketMain.sendToPlayer(new PacketCaffeineInfo(read(player)), player);
    	Caffeine.update(player.worldObj, player);
    }
    
    public static void onLogout(EntityPlayer player, int caffeine){
    	write(player, caffeine);
    	PacketMain.sendToPlayer(new PacketCaffeineInfo(Caffeine.getCaffeineFromPlayer(player)), player);
    }
    
    public static void onUse(EntityPlayer player, int caffeine){
    	onLogout(player, caffeine);
    }
}
