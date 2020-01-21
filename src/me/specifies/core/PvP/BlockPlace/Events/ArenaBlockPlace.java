package me.specifies.core.PvP.BlockPlace.Events;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;

public class ArenaBlockPlace implements Listener {
	
	private FloatingCore plugin;
	
	public ArenaBlockPlace(FloatingCore instance) {
		this.plugin = instance;
	}
	
	
	@EventHandler
	public void place(BlockPlaceEvent e) {
		
		
		Player p = e.getPlayer();
		
		GamePlayer player = plugin.storedPlayers.get(p);
		
		Block b = e.getBlock();
		

		if(p.getWorld().getName().equalsIgnoreCase("pvp")) {
			
			if(!p.hasPermission("floatingcore.pvp.noplace")) {
				
				storeData(player, b);
				
			} else if(p.hasPermission("floatingcore.pvp.noplace")) {
				
				if(!player.getBlockToggle()) {
					storeData(player, b);
				}
				
			}
			
		}
		
		
	}
	
	private void storeData(GamePlayer player, Block b) {
		
		ArrayList<Block> stored = player.getPlacedBlocks();
		
		stored.add(b);
		
		player.setPlacedBlocks(stored);
		
	}

}
