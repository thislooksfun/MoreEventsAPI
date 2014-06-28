package com.tlf.moreevents.common;

import net.minecraftforge.common.MinecraftForge;

import com.tlf.moreevents.event.BPEventHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MoreEventsAPI.MODID, name = MoreEventsAPI.NAME, version = MoreEventsAPI.VERSION)
public class MoreEventsAPI
{
	public static final String MODID = "moreeventsapi";
	public static final String NAME = "More Events API";
	public static final String VERSION = "1.0.0";
	
	
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {}
	
	@EventHandler
	public void onModInit(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new BPEventHandler());
	}
	
	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {}
}