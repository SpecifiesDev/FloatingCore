package me.specifies.core.PvP.Misc;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;
import me.specifies.core.Utilities.Utils;

public class PreventFly implements Listener {
	
	
	private Utils util = new Utils();
	private FloatingCore plugin;
	
	public PreventFly(FloatingCore instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equalsIgnoreCase("pvp")) {
			
			if(!p.hasPermission("floatingcore.pvp.fly")) {
				
				GamePlayer stored = plugin.storedPlayers.get(p);
				
				if(p.isFlying()) {
					
					if(!stored.getFlyWarning()) {
						p.sendMessage(util.color("&c&lSorry but you are not permitted to fly in the PvP Arena!"));
						stored.setFlyWarning(true);
					}
					
					util.dispatchCommand("fly " + p.getName());
					
				}
				
				if(p.getGameMode().toString().equalsIgnoreCase("creative")) {
					
					if(!stored.getCreativeWarning()) {
						p.sendMessage(util.color("&c&lSorry but you are not permitted to be in creative in the PvP Arena!"));
						stored.setCreativeWarning(true);
					}
					
					p.setGameMode(GameMode.SURVIVAL);
				}
				
			}
			
		}
		
	}
	

}
