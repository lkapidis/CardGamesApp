package org.leonidas.CardGames;

import java.util.List;

/**
 * This is the game phase named flop. Is the second phase of Texas poker game.
 * 
 * @author kapidis
 * 
 */
public class Flop implements GamePhase {

	List<TexasPlayer> players;
	CardHolder tableHand;
	GameActions action = new TexasActions();
	boolean endOfRound = false;

	/**
	 * Constructor
	 * 
	 * @param players
	 *            is a list of Texas players
	 * @param tableHand
	 *            is the hand of table
	 */
	public Flop(List<TexasPlayer> players, CardHolder tableHand) {
		this.players = players;
		this.tableHand = tableHand;
	}

	/**
	 * Overrides the given method from the interface. Actually starts the phase.
	 */
	@Override
	public boolean phase() {

		this.flopGame();
		return true;
	}

	/**
	 * Flop game method invoked from phase() Uncover the first 3 cards from the
	 * table. Prints the hands and starts the game betting process
	 */
	private void flopGame() {
		System.out.println("FLOP PHAZE");
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
	 * Prints the hards
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
