package kaaass.coffeecraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.player.EntityPlayer;

public interface ICallClient {
	public IMessage handleClientSide(EntityPlayer player);
}
