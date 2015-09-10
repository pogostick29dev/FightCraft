package me.pogo.fightcraft;

import java.text.DecimalFormat;

import org.bukkit.entity.Player;

public class GamePlayer {

	private Player player;
	
	private int points;
	private int kills;
	private int deaths;
	
	public GamePlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void modifyPoints(int mod) {
		this.points += mod;
		// Update database.
	}
	
	public int getKills() {
		return kills;
	}
	
	public void addKill() {
		this.kills += 1;
		// Update database.
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	public void addDeath() {
		this.deaths += 1;
		// Update database.
	}
	
	public String getKDR() {
		double kdr = deaths > 0 ? kills / deaths : -1.0D;
		DecimalFormat df = new DecimalFormat("##.##");
		return df.format(kdr);
	}
}