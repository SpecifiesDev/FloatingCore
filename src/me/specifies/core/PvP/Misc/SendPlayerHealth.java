package me.specifies.core.PvP.Misc;

import java.util.Arrays;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.specifies.core.Utilities.Utils;

public class SendPlayerHealth implements Listener {
	
	private Utils util = new Utils();
	
	private EntityType[] noDamage = {EntityType.FISHING_HOOK, EntityType.SNOWBALL, EntityType.EGG};
	
	@EventHandler
	public void damage(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() instanceof Player) {
			
			Player damaged = (Player) e.getEntity();
			
			if(damaged.getWorld().getName().equalsIgnoreCase("pvp")) {
				
				
				if(e.getDamager() instanceof Projectile) {
					
					Projectile proj = (Projectile) e.getDamager();
					
					if(proj.getShooter() instanceof Player) {
						
						Player shooter = (Player) proj.getShooter();
						if(Arrays.asList(noDamage).contains(proj.getType())) {
							
							shooter.sendMessage(util.color("&b&l" + damaged.getName() + " &cis at &e&l" + damaged.getHealth() + " &cHP."));
							
						} else {
							
							double reducedDamage = util.getDamageReduced(damaged);
							
							double finalDamage = e.getDamage() - reducedDamage;
							
							shooter.sendMessage(util.color("&b&l" + damaged.getName() + " &cis at &e&l" + finalDamage + " &cHP."));
							
							
						}
						
					}
				
					
				}
				
				
			}
			
		}
		
		
	}
	

}
