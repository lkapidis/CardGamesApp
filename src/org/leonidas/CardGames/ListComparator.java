package org.leonidas.CardGames;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ListComparator implements Comparator<Map.Entry<Card, Integer>> {

	@Override
	public int compare(Entry<Card, Integer> arg0, Entry<Card, Integer> arg1) {
		
		return arg1.getValue()-arg0.getValue();
	}

}
