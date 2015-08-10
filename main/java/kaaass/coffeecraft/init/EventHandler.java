package kaaass.coffeecraft.init;


import net.minecraftforge.common.MinecraftForge;
import kaaass.coffeecraft.CoffeecraftMain;
import kaaass.coffeecraft.eventhandler.EventPlayer;
import kaaass.coffeecraft.eventhandler.EventPlayerInteract;
import kaaass.coffeecraft.network.PacketMain;
import kaaass.coffeecraft.network.packet.PacketCaffeineInfo;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class EventHandler extends IInits{
	public static SimpleNetworkWrapper networkHandler;
	
	public EventHandler(){
		super("EventHandler");
	}
	
	@Override
	public void preLoad() {
		
	}

	@Override
	public void load() {
		networkHandler = NetworkRegistry.INSTANCE.newSimpleChannel(CoffeecraftMain.MODID);
		PacketMain.registerPacket(PacketCaffeineInfo.class);
		
		MinecraftForge.EVENT_BUS.register(new EventPlayerInteract());
		FMLCommonHandler.instance().bus().register(new EventPlayer());
	}

	@Override
	public void postInit() {
		
	}
}
