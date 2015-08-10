package kaaass.coffeecraft.eventhandler;

import kaaass.coffeecraft.caffeine.Caffeine;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class EventPlayerInteract {
	@SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.action == Action.RIGHT_CLICK_BLOCK){
            if(event.world.getBlock(event.x, event.y, event.z) == Blocks.bed){
            	if(Caffeine.getCaffeineFromPlayer(event.entityPlayer) >= Caffeine.sleepCaffeineValue){
            		event.setCanceled(true);
                	event.entityPlayer.addChatMessage(new ChatComponentTranslation("coffeecraft.chat.tomuchcaffeine"));
            	}
            }
        }
    }
}
