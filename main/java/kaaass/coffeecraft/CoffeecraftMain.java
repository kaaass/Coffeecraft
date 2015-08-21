package kaaass.coffeecraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import kaaass.coffeecraft.command.CommandCaffeine;
import kaaass.coffeecraft.gui.GuiHandler;
import kaaass.coffeecraft.init.IInits;
import kaaass.coffeecraft.init.Init;
import kaaass.coffeecraft.item.ItemCoffeeBean;
import kaaass.coffeecraft.item.ItemCoffeeCoin;
import kaaass.coffeecraft.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CoffeecraftMain.MODID, name = CoffeecraftMain.NAME, version = CoffeecraftMain.Version)

public class CoffeecraftMain {
	public static final String MODID = "coffeecraft";
	public static final String NAME = "	CoffeeCraft";
	public static final String Version = "1.1.7.1508_Alpha";
	
	@Instance(MODID)
	public static CoffeecraftMain instance;
	
	private static Init init = new Init();
	
	public static final CreativeTabs creativeTab = new CoffeeCreativeTab("coffeecraft");
	
	@SidedProxy(clientSide="kaaass.coffeecraft.proxy.ClientProxy",serverSide="kaaass.coffeecraft.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		init.preLoad();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		init.load();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		init.postInit();
	}
	
	@Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandCaffeine());
    }
}
