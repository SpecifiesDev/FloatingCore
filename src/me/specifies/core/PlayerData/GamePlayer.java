package me.specifies.core.PlayerData;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class GamePlayer {
	
	private boolean warnedFly = false;
	private boolean warnedCreative = false;
	private boolean togglePlaceBlocks = false;
	private ArrayList<Block> placedBlocks = new ArrayList<Block>();
	private boolean tpImmune;
	private Player p;
	
	public GamePlayer(Player p) {
		this.p = p;
	}
	
	public boolean getFlyWarning() {
		return warnedFly;
	}
	
	public void setFlyWarning(boolean value) {
		warnedFly = value;
	}
	
	public boolean getCreativeWarning() {
		return warnedCreative;
	}
	
	public void setCreativeWarning(boolean value) {
		warnedCreative = value;
	}
	
	public boolean getBlockToggle() {
		return togglePlaceBlocks;
	}
	
	public void setBlockToggle(boolean value) {
		togglePlaceBlocks = value;
	}
	
	public Player getPlayer() {
		return p;
	}
	
	public ArrayList<Block> getPlacedBlocks() {
		return placedBlocks;
	}
	
	public void setPlacedBlocks(ArrayList<Block> value) {
		placedBlocks = value;
	}
	
	public void resetBlocks() {
		placedBlocks = new ArrayList<Block>();
	}
	
	public boolean getImmuneTp() {
		return tpImmune;
	}
	
	public void setImmuneTp(boolean value) {
		tpImmune = value;
	}
	
	

	
	

}
