package org.leonidas.CardGames;

import java.util.*;

public class TableHand implements CardHolder {

	/**
	 * Defined that a table is a Card holder. Creates an ArrayList and returns
	 * it
	 */
	private List<Card> tableHand = new ArrayList<Card>();
	/**
	 * Implements the interface method
	 */
	/**
	 * At dealing time keeps track of the hand's rank
	 */
	private Map<Rank, Integer> rankStats = new HashMap<Rank, Integer>();
	private Map<Suit, Integer> suitStats = new HashMap<Suit, Integer>();
	public List<Card> startingHand = new ArrayList<Card>();
	private Rank minRank = Rank.ACE;
	private Rank maxRank = Rank.TWO;

	@Override
	public List<Card> getHand() {

		return tableHand;
	}

	public Map<Rank, Integer> getRankStats() {
		return rankStats;
	}

	public Map<Suit, Integer> getSuitStats() {
		return suitStats;
	}

	/**
	 * @return the minRank
	 */
	public Rank getMinRank() {
		return minRank;
	}

	/**
	 * @return the maxRank
	 */
	public Rank getMaxRank() {
		return maxRank;
	}

	/**
	 * @param minRank
	 *            the minRank to set
	 */
	public void setMinRank(Rank minRank) {
		this.minRank = minRank;
	}

	/**
	 * @param maxRank
	 *            the maxRank to set
	 */
	public void setMaxRank(Rank maxRank) {
		this.maxRank = maxRank;
	}

	@Override
	public List<Card> getStartingHand() {
		
		return startingHand;
	}

	

}
