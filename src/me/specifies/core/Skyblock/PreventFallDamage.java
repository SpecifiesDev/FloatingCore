package me.specifies.core.Skyblock;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;

public class PreventFallDamage implements Listener {
	
	private FloatingCore plugin;
	public PreventFallDamage(FloatingCore instance) {
		this.plugin = instance;
	}
	
	@EventHandler 
	public void damageEvent(EntityDamageEvent e) {
		
		if(e.getEntity() instanceof Player) {
			
			Player p = (Player) e.getEntity();
			
			if(p.getWorld().getName().equalsIgnoreCase("askyblock")) {
				
				GamePlayer player = plugin.storedPlayers.get(p);
				
				if(player.getImmuneTp()) {
					e.setCancelled(true);
					player.setImmuneTp(false);
				}
				
			}
			
		}
		
	}

}
