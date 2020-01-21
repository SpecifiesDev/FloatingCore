package me.specifies.core.PvP.BlockPlace.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.specifies.core.FloatingCore;
import me.specifies.core.PlayerData.GamePlayer;
import me.specifies.core.Utilities.Utils;

public class TogglePlace implements CommandExecutor {

	
	private FloatingCore plugin;
	private Utils util = new Utils();
	
	public TogglePlace(FloatingCore instance) {
		this.plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(util.color("&cYou must be a player to use this command!"));
		} else {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("floatingcore.pvp.noplace")) {
				
				
				GamePlayer player = plugin.storedPlayers.get(p);
				
				if(player.getBlockToggle()) {
					p.sendMessage(util.color("&bYou have toggled the ability to place blocks in the PvP arena to&7: &c&lOFF&7."));
					player.setBlockToggle(false);
				} else if(!player.getBlockToggle()) {
					p.sendMessage(util.color("&bYou have toggled to ability to place blocks in the PvP arena to&7: &a&lON&7."));
					player.setBlockToggle(true);
				}
				
				
				
			} else {
				p.sendMessage(util.color("&cSorry, you don't have permission to toggle block placeability."));
			}
			
			
		}
		
		return true;
	}
}
