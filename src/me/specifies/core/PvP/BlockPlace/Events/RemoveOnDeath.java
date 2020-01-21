package me.specifies.core.PvP.BlockPlace.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;
import me.specifies.core.Utilities.Utils;

public class RemoveOnDeath implements Listener {
	
	private FloatingCore plugin;
	private Utils util = new Utils();
	
	public RemoveOnDeath(FloatingCore instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void death(PlayerDeathEvent e) {
		
		Player p = e.getEntity();
		
		
			
		GamePlayer player = plugin.storedPlayers.get(p);
			
		if(!player.getPlacedBlocks().isEmpty()) {
			util.spawnNewBlockTask(player, "&cYou have died. Any blocks placed in the PvP Arena will now be removed.", true);
		}
			
		
		
	}
	
	

}
