package org.leonidas.CardGames;

import java.util.*;

public class PlayerHand implements CardHolder {

	/**
	 * Defined that a player is a Card holder. Creates an ArrayList and returns
	 * it
	 */
	public List<Card> startingHand = new ArrayList<Card>();
	private List<Card> playerHand = new ArrayList<Card>();
	private Map<Rank, Integer> rankStats = new TreeMap<Rank, Integer>();
	private Map<Suit, Integer> suitStats = new TreeMap<Suit, Integer>();
	private Rank minRank = Rank.ACE;
	private Rank maxRank = Rank.TWO;

	/**
	 * Implements the interface method
	 */
	@Override
	public List<Card> getHand() {

		return playerHand;
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
