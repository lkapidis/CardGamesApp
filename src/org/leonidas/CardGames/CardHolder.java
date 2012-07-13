package org.leonidas.CardGames;

import java.util.List;
import java.util.Map;

/**
 * Ability to hold cards.
 * @author  kapidis
 */
public interface CardHolder {
	/**
	 * method that returns a List of Cards.
	 */
	public List<Card> getHand();
	public Map<Rank,Integer> getRankStats();
	public Map<Suit,Integer> getSuitStats();
	public Rank getMinRank();
	public Rank getMaxRank();
	public void setMinRank(Rank minRank);
	public void setMaxRank(Rank maxRank);
	public List<Card> getStartingHand();
}
