package org.leonidas.CardGames.bl;

import org.leonidas.CardGames.*;

import java.util.List;

public class Phase implements GamePhase {

	List<TexasPlayer> players;
	CardHolder tableHand;
	GameActions actions = new TexasActions();
	boolean endOfRound = false;
	
	public Phase(List<TexasPlayer> players, CardHolder tableHand) {
		this.players = players;
		this.tableHand = tableHand;
	}
	
	@Override
	public boolean phase() {
		this.printPF();
		return true;
	}

	public void doAction (String action, int amount, int turn) {
		
		if(action.equals("call")) {
			actions.call(players.get(turn));
		} else if (action.equals("raise")) {
			actions.raise(players.get(turn),amount);
		} else if (action.equals("fold")) {
			actions.fold(players.get(turn));
		} else if (action.equals("check")) {
			actions.check(players.get(turn));
		}
	
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
