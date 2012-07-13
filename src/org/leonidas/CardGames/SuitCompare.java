package org.leonidas.CardGames;

import java.util.Comparator;

public class SuitCompare implements Comparator<Card> {

	@Override
	public int compare(Card card1, Card card2) {

		return card1.getSuit().compareTo(card2.getSuit());
	}

}
