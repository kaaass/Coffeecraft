package kaaass.coffeecraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import kaaass.coffeecraft.CoffeecraftMain;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketMain {
	private static final SimpleNetworkWrapper networkHandler = NetworkRegistry.INSTANCE.newSimpleChannel(CoffeecraftMain.MODID);
	
	public static void sendToServer(AbstractPacket packet){
        networkHandler.sendToServer(packet);
    }

    public static void sendToPlayer(AbstractPacket packet, EntityPlayer player){
        networkHandler.sendTo(packet, (EntityPlayerMP)player);
    }

    public static void sendToPlayer(AbstractPacket packet, EntityPlayerMP player){
        networkHandler.sendTo(packet, player);
    }

    public static void sendToAllInDimension(AbstractPacket packet, int dimId){
        networkHandler.sendToDimension(packet, dimId);
    }

    public static void sendToAllAround(AbstractPacket packet, double X, double Y, double Z, int range, int dimensionId){
        NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(dimensionId, X, Y, Z, range);
        networkHandler.sendToAllAround(packet, targetPoint);
    }
    
    public static void sendPacketToAllPlayers(AbstractPacket packet){
        networkHandler.sendToAll(packet);
    }
}
