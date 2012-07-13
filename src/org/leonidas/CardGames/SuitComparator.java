package org.leonidas.CardGames;

import java.util.Comparator;


public class SuitComparator implements Comparator<Card> {

	@Override
	public int compare(Card arg0, Card arg1) {
		
		return arg0.getSuit().compareTo(arg1.getSuit());
	}

	

}
