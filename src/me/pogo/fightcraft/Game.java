package me.pogo.fightcraft;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Game {

	public enum GameState {
		COUNTDOWN, ACTIVE
	}
	
	private Map map;
	private GameState state;
	private ArrayList<Player> players;
	
	public Game(Map map, ArrayList<Player> players) {
		this.map = map;
		this.state = GameState.COUNTDOWN;
		this.players = players;
	}
	
	public GameState getState() {
		return state;
	}
	
	public boolean containsPlayer(Player p) {
		return players.contains(p);
	}
	
	public void broadcast(String message) {
		for (Player p : players) {
			p.sendMessage(message); // You could add a prefix.
		}
	}
}