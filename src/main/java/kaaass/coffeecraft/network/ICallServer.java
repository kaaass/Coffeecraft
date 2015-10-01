package kaaass.coffeecraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.player.EntityPlayer;

public interface ICallServer {
	public IMessage handleServerSide(EntityPlayer player);
}
