package org.leonidas.CardGames;

import java.util.ArrayList;
import java.util.List;

public class TexasGameRegistration {
	List<TexasPlayer> players = new ArrayList<TexasPlayer>();
	public final int MAX_PLAYERS = 9;

	/**
	 * Creates the players For Texas Poker Game
	 * 
	 * @return the list of players
	 */
	public List<TexasPlayer> createPlayers() {
		for (int i = 0; i < MAX_PLAYERS; i++) {
			players.add(new TexasPlayer("dummy", new ChipStack(1), i));
		}
		this.registerPlayer("Leonidas", 2000, 0);
		this.registerPlayer("George", 2000, 1);
		this.registerPlayer("Mixalis", 2000, 2);
		this.registerPlayer("Dimitris", 2000, 3);
		this.registerPlayer("Kostas", 2000, 4);
		this.registerPlayer("Giannis", 2000, 5);

		return players;
	}

	/**
	 * Creates and adds a player to a spot with an amount of chips
	 * 
	 * @param name
	 * @param chips
	 * @param tableSpot
	 */
	public void registerPlayer(String name, int chips, int tableSpot) {

		if (players.get(tableSpot).getName().equals("dummy")) {
			players.remove(tableSpot);
			players.add(tableSpot, new TexasPlayer(name, new ChipStack(chips),
					tableSpot));
			System.out.println("Player added in " + tableSpot + "position");
		} else {
			System.out.println("Seat is taken.. Choose an other one.");
		}
	}

	/**
	 * removes a player and in his place adds a dummy player.
	 * 
	 * @param player
	 */
	public void unRegisterPlayer(TexasPlayer player) {
		int tableSpot = player.getTableSpot();
		System.out.println("Player removed");
		players.remove(player);
		players.add(tableSpot, new TexasPlayer("dummy", new ChipStack(1),
				tableSpot));

	}
}
