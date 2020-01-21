package me.specifies.core.Utilities;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.specifies.core.PlayerData.GamePlayer;

public class Utils {
	
	
	public String color(String m) {
		return ChatColor.translateAlternateColorCodes('&', m);
	}
	
	public void dispatchCommand(String command) {
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
	}
	
	public void spawnNewBlockTask(GamePlayer p, String message, boolean messageTrue) {
		
		ArrayList<Block> toRemove = p.getPlacedBlocks();
		
		boolean alreadyDone = false;
		
		if(messageTrue) p.getPlayer().sendMessage(color(message));
		try {
			
			for(Block b : toRemove) {
				
					
				b.setType(Material.AIR);
					
				for(int i = 0; i < 100; i++) {
					b.getWorld().playEffect(b.getLocation(), Effect.WITCH_MAGIC, 10);
				}
					
				if(!alreadyDone) {
					b.getWorld().playSound(b.getLocation(), Sound.GLASS, 10, 29);
					alreadyDone = true;
				}
					
				
			}
			p.resetBlocks();
		} catch(Exception e) {
			if(messageTrue) p.getPlayer().sendMessage("&c&lThere was an error in the process of removing blocks placed in the PvP Arena. Please contact a staff member.");
			// Possibly alert staff?
		}
		
		
		
	}
	
	public double getDamageReduced(Player player) {
        org.bukkit.inventory.PlayerInventory inv = player.getInventory();
        ItemStack boots = inv.getBoots();
        ItemStack helmet = inv.getHelmet();
        ItemStack chest = inv.getChestplate();
        ItemStack pants = inv.getLeggings();
        double red = 0.0;
        if(helmet == null) red += 0.0;
        else if(helmet.getType() == Material.LEATHER_HELMET) red +=  0.04;
        else if(helmet.getType() == Material.GOLD_HELMET) red +=  0.08;
        else if(helmet.getType() == Material.CHAINMAIL_HELMET) red +=  0.08;
        else if(helmet.getType() == Material.IRON_HELMET) red +=  0.08;
        else if(helmet.getType() == Material.DIAMOND_HELMET) red +=  0.12;
        //
        if(boots == null) red += 0.0;
        else if(boots.getType() == Material.LEATHER_BOOTS) red +=  0.04;
        else if(boots.getType() == Material.GOLD_BOOTS) red +=  0.04;
        else if(boots.getType() == Material.CHAINMAIL_BOOTS) red +=  0.04;
        else if(boots.getType() == Material.IRON_BOOTS) red +=  0.08;
        else if(boots.getType() == Material.DIAMOND_BOOTS) red +=  0.12;
        //
        if(pants == null) red += 0.0;
        else if(pants.getType() == Material.LEATHER_LEGGINGS) red +=  0.08;
        else if(pants.getType() == Material.GOLD_LEGGINGS) red +=  0.12;
        else if(pants.getType() == Material.CHAINMAIL_LEGGINGS) red +=  0.16;
        else if(pants.getType() == Material.IRON_LEGGINGS) red +=  0.20;
        else if(pants.getType() == Material.DIAMOND_LEGGINGS) red +=  0.24;
        //
        if(chest == null) red += 0.0;
        else if(chest.getType() == Material.LEATHER_CHESTPLATE) red +=  0.12;
        else if(chest.getType() == Material.GOLD_CHESTPLATE) red +=  0.20;
        else if(chest.getType() == Material.CHAINMAIL_CHESTPLATE) red +=  0.20;
        else if(chest.getType() == Material.IRON_CHESTPLATE) red +=  0.24;
        else if(chest.getType() == Material.DIAMOND_CHESTPLATE) red +=  0.32;
        return red;
    }
	
	public double roundDecimal(double value, int decimals) {
		int s = (int) Math.pow(10,  decimals);
		return (double) Math.round(value * s) / s;
	}
	

	

}
