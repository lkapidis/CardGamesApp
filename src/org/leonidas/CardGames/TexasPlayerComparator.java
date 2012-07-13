package org.leonidas.CardGames;

import java.util.Comparator;

public class TexasPlayerComparator implements Comparator<TexasPlayer> {


	@Override
	public int compare(TexasPlayer o1, TexasPlayer o2) {
		if(o1.getEp().ordinal() == o2.getEp().ordinal()){
			return (o1.getPlayerHand().getStartingHand().get(0).getRank().ordinal() - o2.getPlayerHand().getStartingHand().get(0).getRank().ordinal());
		}
		return o1.getEp().ordinal()-o2.getEp().ordinal();
	}

}
