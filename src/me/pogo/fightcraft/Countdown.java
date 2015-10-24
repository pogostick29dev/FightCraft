package me.pogo.fightcraft;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

	private Game game;
	private int i;
	
	public Countdown(Game game) {
		this.game = game;
		this.i = 30;
	}
	
	@Override
	public void run() {
		if (i == 0) {
			cancel();
			game.start();
		}
		
		else {
			if (i == 30 || i == 15 || i == 10 || i == 5 || i == 4 || i == 3 || i == 2 || i == 1) {
				game.broadcast(ChatColor.GOLD + "The fight will begin in " + i + " seconds.");
			}
			
			i--;
		}
	}
}