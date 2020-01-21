package me.specifies.core.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;

public class AddPlayerStateMove implements Listener {

	private FloatingCore plugin;
	public AddPlayerStateMove(FloatingCore instance) {
		this.plugin = instance;
	}
	
	
	@EventHandler
	public void move(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		
		if(!plugin.storedPlayers.containsKey(p)) {
			plugin.storedPlayers.put(p, new GamePlayer(p));
		}
		
	}
	
}
