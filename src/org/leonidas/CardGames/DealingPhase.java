package org.leonidas.CardGames;

import java.util.List;

/**
 * The first phase of Texas game. This phase deals cards and places blinds and
 * bets
 * 
 * @author kapidis
 * 
 */
public class DealingPhase implements GamePhase {

	Deck deck = Deck.getInstance();
	List<TexasPlayer> players;
	Dealing dealer = new DealOnePerTime(deck);
	CardHolder tableHand;

	public DealingPhase(List<TexasPlayer> players, CardHolder tableHand) {
		this.players = players;
		this.tableHand = tableHand;
	}

	/**
	 * Overrides the phase method
	 */
	@Override
	public boolean phase() {

		this.dealCards();
		this.printPF();

		return true;
	}

	/**
	 * Deals cards to players.One card a time to each player and then 5 cards to
	 * table.
	 */
	private void dealCards() {

		int turn = TexasGame.chiefSpot + 1;

		for (int i = 0; i < players.size() * 2; i++) {
			if (players.get(turn).getName().equals("dummy")
					|| !(players.get(turn).isInGame())
					|| !(players.get(turn).isActive())) {

			} else {
				dealer.deal(players.get(turn).getPlayerHand());
				// players.get(turn).getPlayerHand().getHand().get(0)
				// .setCardID(turn);
			}
			turn++;
			if (turn == players.size()) {
				turn = 0;
			}
		}

		for (int i = 0; i < 5; i++) {
			
			dealer.deal(tableHand);
		}
	}

	/**
	 * Prints the hands
	 */
	private void printPF() {
		for (int i = 0; i < players.size(); i++) {
			if (!players.get(i).getName().equals("dummy")
					&& players.get(i).isInGame()) {
				System.out.println("The cards of " + players.get(i).getName()
						+ " are "
						+ players.get(i).getPlayerHand().getHand().toString());
			} else {

			}
		}
		System.out.println("Table has : " + tableHand.getHand().toString());
	}
	
}
