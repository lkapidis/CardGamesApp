package org.leonidas.CardGames;

/**
 * This is the card.The card has rank and suit.Also has info wheather a card is
 * discarded or covered. It also has an ID.
 * 
 * @author kapidis
 * 
 */
public class Card implements Comparable<Card> {

	private final Rank rank;
	private final Suit suit;
	private boolean iscovered;

	/**
	 * Constructor of Card Takes rank and suit and sets discarded to false and
	 * is covered to true as their default values
	 * 
	 * @param r
	 * @param s
	 */
	public Card(Rank r, Suit s) {
		super();
		this.rank = r;
		this.suit = s;

		this.iscovered = true;

	}

	/**
	 * 
	 * @return the rank of a card
	 */
	public Rank getRank() {
		return this.rank;
	}

	/**
	 * 
	 * @return the suit of a card
	 */
	public Suit getSuit() {
		return this.suit;
	}

	/**
	 * Override toString method so we have a better looking print
	 */
	public String toString() {

		return this.rank + " of " + this.suit;

	}

	/**
	 * 
	 * @return if the card is covered
	 */
	public boolean isCovered() {
		return this.iscovered;
	}

	/**
	 * uncovers a card
	 */
	public void unCovereCard() {
		this.iscovered = false;
	}

	/**
	 * Compares cards with their rank value.
	 */
	@Override
	public int compareTo(Card card) {
		return rank.compareTo(card.getRank());
	}

	/**
	 * Overrides equal
	 */
	public boolean equals(Object o) {
		if ((o instanceof Card) && (((Card) o)).getRank() == this.rank) {
			return true;
		} else {
			return false;
		}
	}
}
