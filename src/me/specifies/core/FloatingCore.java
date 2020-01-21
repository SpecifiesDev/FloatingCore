package me.specifies.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.specifies.core.ArmorStands.PreventBreak;
import me.specifies.core.ArmorStands.PreventItemTakeOff;
import me.specifies.core.Events.AddPlayerStateJoin;
import me.specifies.core.Events.AddPlayerStateMove;
import me.specifies.core.PlayerData.GamePlayer;
import me.specifies.core.PvP.BlockPlace.Commands.TogglePlace;
import me.specifies.core.PvP.BlockPlace.Events.ArenaBlockBreak;
import me.specifies.core.PvP.BlockPlace.Events.ArenaBlockPlace;
import me.specifies.core.PvP.BlockPlace.Events.RemoveOnDeath;
import me.specifies.core.PvP.BlockPlace.Events.RemoveOnDisconnect;
import me.specifies.core.PvP.BlockPlace.Events.RemoveOnTeleport;
import me.specifies.core.PvP.Misc.PreventFly;
import me.specifies.core.PvP.Misc.SendPlayerHealth;

public class FloatingCore extends JavaPlugin {
	
	public HashMap<Player, GamePlayer> storedPlayers = new HashMap<>();
	
	public void onEnable() {
		registerEvents();
		registerCommands();
	}
	
	public void onDisable() {
		
		for(Map.Entry<Player, GamePlayer> entry : storedPlayers.entrySet()) {
			
			GamePlayer p = entry.getValue();
			
			ArrayList<Block> stored = p.getPlacedBlocks();
			
			for(Block b : stored) {
				b.setType(Material.AIR);
			}
			
		}
		
		storedPlayers = new HashMap<>();
		

	}
	
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		
		// Armorstands
		pm.registerEvents(new PreventItemTakeOff(), this);
		pm.registerEvents(new PreventBreak(), this);
		
		// PvP - Misc
		pm.registerEvents(new SendPlayerHealth(), this);
		pm.registerEvents(new PreventFly(this), this);
		
		// PvP - BlockPlace
		pm.registerEvents(new ArenaBlockBreak(this), this);
		pm.registerEvents(new ArenaBlockPlace(this), this);
		pm.registerEvents(new RemoveOnDeath(this), this);
		pm.registerEvents(new RemoveOnDisconnect(this), this);
		pm.registerEvents(new RemoveOnTeleport(this), this);
		
		// Events
		pm.registerEvents(new AddPlayerStateJoin(this), this);
		pm.registerEvents(new AddPlayerStateMove(this), this);
	}
	
	private void registerCommands() {
		
		getCommand("toggleblocks").setExecutor(new TogglePlace(this));
		
	}

}
