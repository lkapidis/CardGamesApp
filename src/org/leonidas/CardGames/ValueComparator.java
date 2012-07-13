package org.leonidas.CardGames;

import java.util.*;


public class ValueComparator implements Comparator<Card> {


	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return o1.getRank().compareTo(o2.getRank());
	}

	

	
}
