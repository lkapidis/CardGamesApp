package org.leonidas.CardGames;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class IntegerComparator implements Comparator<Map.Entry<Card, Integer>> {

	@Override
	public int compare(Entry<Card, Integer> arg0, Entry<Card, Integer> arg1) {
		
		return arg0.getKey().compareTo(arg1.getKey());
	}

	
}
