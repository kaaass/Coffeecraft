package kaaass.coffeecraft.network.packet;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import kaaass.coffeecraft.caffeine.CaffeinePlayerInfo;
import kaaass.coffeecraft.network.AbstractPacket;
import kaaass.coffeecraft.network.ICallClient;

public class PacketCaffeineInfo extends AbstractPacket implements ICallClient{
	private NBTTagCompound tagCompound;
	
	public PacketCaffeineInfo(){
		
	}
	
	public PacketCaffeineInfo(int a){
		tagCompound = new NBTTagCompound();
		CaffeinePlayerInfo.write(tagCompound, a);
	}
	
	@Override
	public IMessage handleClientSide(EntityPlayer player) {
		CaffeinePlayerInfo.write(player, CaffeinePlayerInfo.read(player));
		return null;
	}

	@Override
	public void encodeInto(ByteBuf buffer) {
		PacketBuffer packet = new PacketBuffer(buffer);
        try{
            packet.writeNBTTagCompoundToBuffer(tagCompound);
        }
        catch (IOException e){
            System.out.println("Warning: Failed to send NBT tag.");
        }
	}

	@Override
	public void decodeInto(ByteBuf buffer) {
		PacketBuffer packet = new PacketBuffer(buffer);
        try{
        	tagCompound = packet.readNBTTagCompoundFromBuffer();
        }
        catch (IOException e){
            System.out.println("Warning: Failed to receive NBT tag.");
        }
	}

}
