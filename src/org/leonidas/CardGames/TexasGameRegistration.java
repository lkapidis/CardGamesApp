package org.leonidas.CardGames;

import java.util.ArrayList;
import java.util.List;

public class TexasGameRegistration {
	private List<TexasPlayer> players;
	public final int MAX_PLAYERS = 9;

	public TexasGameRegistration(List<TexasPlayer> players) {
		this.players = players;
		for (int i = 0; i < MAX_PLAYERS; i++) {
			players.add(new TexasPlayer("dummy", new ChipStack(1), i));
		}
	}
	/**
	 * Creates the players For Texas Poker Game
	 * 
	 * @return the list of players
	 */
//	public List<TexasPlayer> createPlayers() {
//		for (int i = 0; i < MAX_PLAYERS; i++) {
//			players.add(new TexasPlayer("dummy", new ChipStack(1), i));
//		}
//
//		return players;
//	}

	/**
	 * Creates and adds a player to a spot with an amount of chips
	 * 
	 * @param name
	 * @param chips
	 * @param tableSpot
	 */
	public void registerPlayer(String name, int chips, int tableSpot) {
		if(players.isEmpty()){
			System.out.println("ADEIOS");
		}
		if (players.get(tableSpot).getName().equals("dummy")) {
			players.remove(tableSpot);
			players.add(tableSpot, new TexasPlayer(name, new ChipStack(chips),tableSpot));
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
