package me.specifies.core.Skyblock;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;
import me.specifies.core.Utilities.Utils;

public class AutoTpVoid implements Listener {

	private FloatingCore plugin;
	private Utils util = new Utils();
	
	public AutoTpVoid(FloatingCore instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void move(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		
		GamePlayer player = plugin.storedPlayers.get(p);
		
		if(p.getWorld().getName().equalsIgnoreCase("askyblock")) {
			
			Location loc = p.getLocation();
			
			if(loc.getBlockY() < 25 && !player.getImmuneTp()) {
				
				player.setImmuneTp(true);
				util.dispatchCommand("sudo " + p.getName() + " is");
				
			}
			
		}
		
	}
	
}
