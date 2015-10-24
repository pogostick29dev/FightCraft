package me.pogo.fightcraft;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Game {

	public enum GameState {
		WAITING, COUNTDOWN, ACTIVE
	}
	
	private Map map;
	private GameState state;
	private ArrayList<GamePlayer> players;
	
	public Game(Map map, ArrayList<GamePlayer> players) {
		this.map = map;
		this.state = GameState.WAITING;
		this.players = players;
	}
	
	public GameState getState() {
		return state;
	}
	
	public void addPlayer(GamePlayer p) {
		// Save state.
		// Modify state.
		players.add(p);
		
		if (players.size() >= map.getSpawnLocationCount() && state == GameState.WAITING) {
			state = GameState.COUNTDOWN;
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(
					Bukkit.getServer().getPluginManager().getPlugin("FightCraft"),
					new Countdown(this),
					0,
					20
			);
		}
	}
	
	public void removePlayer(GamePlayer p) {
		// Revert state.
		players.remove(p);
	}
	
	public boolean containsPlayer(GamePlayer p) {
		return players.contains(p);
	}
	
	public void broadcast(String message) {
		for (GamePlayer p : players) {
			p.getPlayer().sendMessage(message); // You could add a prefix.
		}
	}
	
	public void start() {
		this.state = GameState.ACTIVE;
		broadcast(ChatColor.GOLD + "Fight!");
	}
}