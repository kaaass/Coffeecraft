package kaaass.coffeecraft.init;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public abstract class IInits {
	public static String initType;
	
	public IInits(){
		Init.initList.add(this);
		System.out.println("Successful init " + initType + ".");
	}
	
	public abstract void preLoad(FMLPreInitializationEvent event);
	
	public abstract void load(FMLInitializationEvent event);
	
	public abstract void postInit(FMLPostInitializationEvent event);
}