package kaaass.coffeecraft.init;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Init {
	public static List<IInits> initList = new ArrayList();
	
	private static IInits blocks;
	private static IInits items;
	private static IInits eventHandler;
	
	public Init(){
		//put init here
		blocks = new Blocks();
		items = new Items();
		eventHandler = new EventHandler();
	}
	
	public void preLoad(){
		for(int i = 0; i < initList.size(); i++){
			initList.get(i).preLoad();
		}
	}
	
	public void load(){
		for(int i = 0; i < initList.size(); i++){
			initList.get(i).load();
		}
	}
	
	public void postInit(){
		for(int i = 0; i < initList.size(); i++){
			initList.get(i).postInit();
		}
	}
}
