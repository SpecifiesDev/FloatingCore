package me.specifies.core.ArmorStands;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PreventBreak implements Listener {
	
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		
		
		if(e.getDamager() instanceof Player) {
			
			Player p = (Player) e.getDamager();
			
			if(p.getWorld().getName().equalsIgnoreCase("spawn")) {
				if(e.getEntity().getType() == EntityType.ARMOR_STAND) {
					if(!p.hasPermission("floatingcore.armorstand.break")) {
						e.setCancelled(true);
					}
				}
			}
			
		}
		
		
	}
	
	

}
