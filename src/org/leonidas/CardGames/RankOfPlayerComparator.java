package org.leonidas.CardGames;

import java.util.Comparator;

public class RankOfPlayerComparator implements Comparator<TexasPlayer> {

	@Override
	public int compare(TexasPlayer o1, TexasPlayer o2) {
		
		return o2.getPlayerHand().getMaxRank().ordinal() - o1.getPlayerHand().getMaxRank().ordinal();
	}

	
}
