package com.tlf.moreevents.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

@Cancelable
public class BlockAboutToPlaceEvent extends PlayerEvent
{	
	public final int x;
	public final int y;
	public final int z;
	public final int face;
	public final int metadata;
	
	public final World world;
	public final Block block;
	public final PlayerInteractEvent piEvent;
	
	public BlockAboutToPlaceEvent(PlayerInteractEvent piEvent, Block block, int metadata)
	{
		super(piEvent.entityPlayer);
		
		this.world = piEvent.world;
		this.piEvent = piEvent;
		this.face = piEvent.face;
		
		this.block = block;
		this.metadata = metadata;
		
		int x = piEvent.x;
		int y = piEvent.y;
		int z = piEvent.z;
		
		switch (piEvent.face) {
		case 0:
			y--;
			break;
		case 1:
			y++;
			break;
		case 2:
			z--;
			break;
		case 3:
			z++;
			break;
		case 4:
			x--;
			break;
		case 5:
			x++;
			break;
		}
		this.x = x;
		this.y = y;
		this.z = z;
	}
}