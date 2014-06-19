package com.tlf.moreevents.event;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BPEventHandler
{	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void blockAboutToPlace(PlayerInteractEvent event)
	{
		if (event.action == Action.RIGHT_CLICK_BLOCK)
		{
			ItemStack stack = event.entityPlayer.getHeldItem();
			if (stack != null)
			{
				Item item = stack.getItem();
				if (item instanceof ItemBlock)
				{
					Block block = ((ItemBlock)item).field_150939_a;
					int metadata = stack.getItemDamage();
					
					BlockAboutToPlaceEvent bEvent = new BlockAboutToPlaceEvent(event, block, metadata);
					MinecraftForge.EVENT_BUS.post(bEvent);
					
					if (bEvent.isCanceled()) {
						event.setCanceled(true);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void test(BlockAboutToPlaceEvent event)
	{
		if (!event.world.isRemote) {
			if (event.world.getBlock(event.x, event.y-1, event.z) == Blocks.air) {
				event.setCanceled(true);
				
				EntityFallingBlock fBlock = new EntityFallingBlock(event.world, event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, event.block, event.metadata);
				event.world.spawnEntityInWorld(fBlock);
			}
		}
	}
}