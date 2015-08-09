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
	private NBTTagCompound tagCompound = new NBTTagCompound();
	
	public PacketCaffeineInfo(){
		CaffeinePlayerInfo.write(tagCompound, CaffeinePlayerInfo.read(tagCompound));
	}
	
	@Override
	public IMessage handleClientSide(EntityPlayer player) {
		CaffeinePlayerInfo cpi = new CaffeinePlayerInfo();
		cpi.write(player, cpi.read(tagCompound));
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
