package org.leonidas.CardGames;

import java.util.List;

/**
 * The final phase of Texas game. Uncover the last table card and places the
 * last bets TexasEvaluator will check everyones hands
 * 
 * @author kapidis
 * 
 */
public class Turn implements GamePhase {
	List<TexasPlayer> players;
	CardHolder tableHand;
	GameActions action = new TexasActions();
	boolean endOfRound = false;
	EvaluatePhase handEvaluator;

	public Turn(List<TexasPlayer> players, CardHolder tableHand) {
		this.players = players;
		this.tableHand = tableHand;
	}

	/**
	 * Implements the method given from the interface
	 */
	@Override
	public boolean phase() {
		System.out.println("PHAZE");
		this.turnGame();
		return true;
	}

	/**
	 * Makes the last actions, the evaluation and pays the winner.
	 */
	private void turnGame() {
		System.out.println("Turn PHAZE");
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
	 * Print hands
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
