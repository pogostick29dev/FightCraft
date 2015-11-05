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
			String plural = i == 1 ? "" : "s";
			if(i % 10 == 0 || i <= 5)
			    game.broadcast(ChatColor.GOLD + "The fight will begin in " + i + " second" + plural + ".");
			i--;
		}
	}
}
