package kaaass.coffeecraft.eventhandler;

import kaaass.coffeecraft.caffeine.Caffeine;
import kaaass.coffeecraft.caffeine.CaffeinePlayerInfo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventPlayer {
	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
		Caffeine.addPlayer(event.player, CaffeinePlayerInfo.read(event.player));
		CaffeinePlayerInfo.onLogin(event.player);
		System.out.println("Caffeine data is saved.");
    }

    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event){
    	CaffeinePlayerInfo.onLogout(event.player, Caffeine.getCaffeineFromPlayer(event.player));
    	Caffeine.removePlayer(event.player);
		System.out.println("Caffeine data is removed.");
    }
}
