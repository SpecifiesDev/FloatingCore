package me.specifies.core.ArmorStands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class PreventItemTakeOff implements Listener {
	
	@EventHandler
	public void interact(PlayerInteractAtEntityEvent e) {
		

		if(e.getPlayer().getWorld().getName().equalsIgnoreCase("spawn")) {
			
			if(!e.getPlayer().hasPermission("floatingcore.armorstand.remove")) {
				e.setCancelled(true);
			}
			
		}
		
		
	}

}
