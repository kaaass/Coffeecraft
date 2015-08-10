package kaaass.coffeecraft.eventhandler;

import kaaass.coffeecraft.caffeine.Caffeine;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class EventEntityLiving {
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event){
		if(event.entity instanceof EntityPlayer){
			Caffeine.setCaffeine((EntityPlayer)event.entity, 0);
		}
	}
}
