package kaaass.coffeecraft.eventhandler;

import java.util.Random;

import kaaass.coffeecraft.caffeine.Caffeine;
import kaaass.coffeecraft.init.Items;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class EventEntityLiving {
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event){
		Entity entity = event.entity;
		World world = event.entity.worldObj;
		Random rand = world.rand;
		
		if(entity instanceof EntityPlayer){
			Caffeine.setCaffeine((EntityPlayer)entity, 0);
		}
		if(entity instanceof EntityPig || entity instanceof EntityCow){
			if(rand.nextInt(8) == 0){
				entity.dropItem(Items.fat, 1 + rand.nextInt(2));
			}
		}
	}
}
