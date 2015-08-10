package kaaass.coffeecraft.command;

import java.io.IOException;

import kaaass.coffeecraft.caffeine.Caffeine;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

public class CommandCaffeine extends CommandBase {

	@Override
	public String getCommandName() {
		return "caffeine";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "commands.caffeine.usage";
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] arg) {
		EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		try{
			if(arg[0].equals("set")){
				if(arg.length < 1){
					sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.tag"));
					return;
				}else if(arg.length == 3){
					if(!isPlayer(arg[1])){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.player"));
						return;
					}
					if(Caffeine.setCaffeine(arg[1], Integer.parseInt(arg[2])) == -1){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.player"));
						return;
					}
					sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.successSet"));
					return;
				}else{
					if(arg.length != 2){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.tag"));
						return;
					}
					if(Caffeine.setCaffeine(player, Integer.parseInt(arg[1])) == -1){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.player"));
						return;
					}
					sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.successSet"));
					return;
				}
			}else if(arg[0].equals("get")){
				if(arg.length < 1){
					sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.tag"));
					return;
				}else if(arg.length == 3){
					if(!isPlayer(arg[1])){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.player"));
						return;
					}
					int a = Caffeine.getCaffeineFromName(arg[1]);
					if(a == -1){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.player"));
						return;
					}else{
						func_152373_a(sender, this, "commands.caffeine.successGet", new Object[] {arg[1], String.valueOf(a)});
						return;
					}
				}else{
					if(arg.length != 2){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.tag"));
						return;
					}
					int a = Caffeine.getCaffeineFromPlayer(player);
					if(a == -1){
						sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.player"));
						return;
					}else{
						func_152373_a(sender, this, "commands.caffeine.successGet", new Object[] {player.getDisplayName(), String.valueOf(a)});
						return;
					}
				}
			}
			sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.unknown"));
		}
		catch(ArrayIndexOutOfBoundsException e){
			sender.addChatMessage(new ChatComponentTranslation("commands.caffeine.tagError.tag"));
			return;
		}
		catch(NullPointerException e){
			func_152373_a(sender, this, "commands.caffeine.tagError", new Object[] {e});
			return;
		}
	}
	
	private boolean isPlayer(String name){
		String[] nameA = MinecraftServer.getServer().getAllUsernames();
		for(String str: nameA){
			if(str.equals(name)){
				return true;
			}
		}
		return false;
	}
}
