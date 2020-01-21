package me.specifies.core.PvP.BlockPlace.Events;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;

public class ArenaBlockBreak implements Listener {
	
	private FloatingCore plugin;
	public ArenaBlockBreak(FloatingCore instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		
		
		if(p.getWorld().getName().equalsIgnoreCase("pvp")) {
			
			GamePlayer player = plugin.storedPlayers.get(p);
			Block b = e.getBlock();
			
			ArrayList<Block> storedBlocks = player.getPlacedBlocks();
			
			if(storedBlocks.contains(b)) {
				
				b.setType(Material.AIR);
				
				storedBlocks.remove(b);
				
				player.setPlacedBlocks(storedBlocks);
				
			}
			
		}
		
		
	}
	

}
