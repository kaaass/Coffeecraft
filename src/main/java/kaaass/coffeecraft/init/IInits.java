package kaaass.coffeecraft.init;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public abstract class IInits {	
	public IInits(String initType){
		Init.initList.add(this);
		System.out.println("Successful init " + initType + ".");
	}
	
	public abstract void preLoad();
	
	public abstract void load();
	
	public abstract void postInit();
}