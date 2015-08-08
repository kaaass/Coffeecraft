package kaaass.coffeecraft.init;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Init {
	public static List<IInits> initList = new ArrayList();
	
	public Init(){
		//put init here
	}
	
	public void preLoad(FMLPreInitializationEvent event){
		for(int i = 0; i < initList.size(); i++){
			initList.get(i).preLoad(event);
		}
	}
	
	public void load(FMLInitializationEvent event){
		for(int i = 0; i < initList.size(); i++){
			initList.get(i).load(event);
		}
	}
	
	public void postInit(FMLPostInitializationEvent event){
		for(int i = 0; i < initList.size(); i++){
			initList.get(i).postInit(event);
		}
	}
}
