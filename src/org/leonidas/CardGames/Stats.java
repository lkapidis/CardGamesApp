package org.leonidas.CardGames;

public class Stats {

	public void makeStats(CardHolder ch) {
		Card cardForDeal;
		for (int i = 0; i < ch.getHand().size(); i++) {
			cardForDeal = ch.getHand().get(i);
			if (ch.getRankStats().get(cardForDeal.getRank()) == null) {
				ch.getRankStats().put(cardForDeal.getRank(), 0);
			}
			if (ch.getHand().contains(cardForDeal)) {
				ch.getRankStats().put(cardForDeal.getRank(),
						ch.getRankStats().get(cardForDeal.getRank()) + 1);
			} else {
				ch.getRankStats().put(cardForDeal.getRank(), 1);
			}
			if (ch.getMinRank().compareTo(cardForDeal.getRank()) < 0) {
				ch.setMinRank(cardForDeal.getRank());
			}
			if (ch.getMaxRank().compareTo(cardForDeal.getRank()) > 0) {
				ch.setMaxRank(cardForDeal.getRank());
			}
			
		}
		ch.getStartingHand().add(ch.getHand().get(0));
		ch.getStartingHand().add(ch.getHand().get(1));
	}
}
