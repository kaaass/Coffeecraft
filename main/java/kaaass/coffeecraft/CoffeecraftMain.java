package kaaass.coffeecraft;

import java.util.ArrayList;
import java.util.List;

import kaaass.coffeecraft.init.IInits;
import kaaass.coffeecraft.init.Init;
import kaaass.coffeecraft.proxy.CommonProxy;
import cn.BiochemistryCraft.GUI.BioGuiHandler;
import cn.BiochemistryCraft.Register.BCCEntityRegister;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cn.BiochemistryCraft.core.sick.SickCold;
import cn.BiochemistryCraft.core.sick.SickRegistry;
import cn.BiochemistryCraft.proxy.BCCcommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = CoffeecraftMain.MODID, name = CoffeecraftMain.NAME, version = CoffeecraftMain.Version)

public class CoffeecraftMain {
	public static final String MODID = "coffeecraft";
	public static final String NAME = MODID;
	public static final String Version="1.0.1.1508_base";
	
	private static Init init = new Init();
	
	@SidedProxy(clientSide="kaaass.coffeecraft.proxy.ClientProxy",serverSide="kaaass.coffeecraft.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		init.preLoad(event);
	}

	@EventHandler
	public void load(FMLInitializationEvent event){
		init.load(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		init.postInit(event);
	}
}
