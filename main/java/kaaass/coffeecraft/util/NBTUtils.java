package kaaass.coffeecraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class NBTUtils {
	public static NBTTagCompound getPersistedFromPlayer(EntityPlayer player){
    	NBTTagCompound tagCompound = player.getEntityData();
    	if (!tagCompound.hasKey(EntityPlayer.PERSISTED_NBT_TAG)){
			tagCompound.setTag(EntityPlayer.PERSISTED_NBT_TAG, new NBTTagCompound());
        }
		return tagCompound.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
    }
	
	public static int readIntFromPlayer(EntityPlayer player, String[] compound, String tag){
		NBTTagCompound persisted = NBTUtils.getPersistedFromPlayer(player);
		for(String a: compound){
			if (persisted.hasKey(a)){
				persisted = persisted.getCompoundTag(a);
	        }else{
	        	return -1;
	        }
		}
		return persisted.getInteger(tag);
	}
	
	public static void writeIntToPlayer(EntityPlayer player, String[] compound, String tag, int value){
		NBTTagCompound persisted = NBTUtils.getPersistedFromPlayer(player);
		for(String a: compound){
			if (persisted.hasKey(a)){
				persisted = persisted.getCompoundTag(a);
	        }else{
	        	persisted.setTag(a, new NBTTagCompound());
	        	persisted = persisted.getCompoundTag(a);
	        }
		}
		persisted.setInteger(tag, value);
	}
}
