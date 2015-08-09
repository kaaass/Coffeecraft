package kaaass.coffeecraft.init;


import net.minecraftforge.common.MinecraftForge;
import kaaass.coffeecraft.eventhandler.EventPlayerInteract;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class EventHandler extends IInits{
	public EventHandler(){
		super("EventHandler");
	}
	
	@Override
	public void preLoad() {
		
	}

	@Override
	public void load() {
		MinecraftForge.EVENT_BUS.register(new EventPlayerInteract());
	}

	@Override
	public void postInit() {
		
	}
}
