package org.leonidas.CardGames;

import java.util.List;

/**
 * The third phase of Taxas game Makes player's actions
 * 
 * @author kapidis
 * 
 */
public class River implements GamePhase {
	List<TexasPlayer> players;
	CardHolder tableHand;
	GameActions action = new TexasActions();
	boolean endOfRound = false;

	public River(List<TexasPlayer> players, CardHolder tableHand) {
		this.players = players;
		this.tableHand = tableHand;
	}

	@Override
	public boolean phase() {
		System.out.println("PHAZE");
		this.riverGame();
		return true;
	}

	/**
	 * uncover the third card of table and makes actions
	 */
	private void riverGame() {
		System.out.println("RIVER PHAZE");
		int actionCounter = 0;
		this.printPF();

		int turn = TexasGame.chiefSpot + 1;
		while (endOfRound == false) {

			if (players.get(turn).getName().equals("dummy")
					|| !(players.get(turn).isInGame())
					|| !(players.get(turn).isActive())) {

			} else {

				System.out.println("Player" + players.get(turn).getName()
						+ " calls ");
				action.call(players.get(turn));

			}
			actionCounter++;
			turn++;
			if (turn == players.size()) {
				turn = 0;
			}
			if (actionCounter == players.size()) {
				for (Player pl : players) {
					if (pl.getRaised()) {
						actionCounter = 0;
					} else {
						endOfRound = true;
					}
				}
			}
		}
		TexasGame.currentBet = 50;
	}

	/**
	 * Prints the hands
	 */
	private void printPF() {
		for (int i = 0; i < players.size(); i++) {
			if (!players.get(i).getName().equals("dummy")
					&& players.get(i).isInGame()) {
				System.out.println("Ta xartia tou " + players.get(i).getName()
						+ " einai "
						+ players.get(i).getPlayerHand().getHand().toString());
			} else {

			}
		}
		System.out.println("To trapezi exei : "
				+ tableHand.getHand().toString());
	}
}
