package me.specifies.core.PvP.BlockPlace.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;
import me.specifies.core.Utilities.Utils;

public class RemoveOnDisconnect implements Listener {
	
	private FloatingCore plugin;
	private Utils util = new Utils();
	
	public RemoveOnDisconnect(FloatingCore instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void quit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		
		GamePlayer player = plugin.storedPlayers.get(p);
		
		if(!player.getPlacedBlocks().isEmpty()) {
			util.spawnNewBlockTask(player, "", false);
		}
		
	}
	

}
