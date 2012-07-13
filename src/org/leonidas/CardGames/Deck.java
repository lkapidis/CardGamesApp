package org.leonidas.CardGames;

/**
 * The creation of the deck.
 * 
 * @author kapidis
 * 
 */
public class Deck {
	
	private static Deck uniqueDeck = new Deck();
	final int MAX_CARDS = 52;
	private int cardsUsed = 0;
	Card[] deck = new Card[MAX_CARDS];

	/**
	 * Following the singleton pattern for creation an unique deck
	 * @return
	 */
	public static Deck getInstance(){
		
		return uniqueDeck;
	}
	/**
	 * Constructor of deck creates a unique and shuffles the deck. Deck is an array of 52
	 * defined from constant MAX_CARDS
	 */
	private Deck() {
		this.createDeck();
		this.shuffleDeck();
	}

	/**
	 * Creates the deck getting suits and ranks from enums.
	 */
	private void createDeck() {
		int tmp = 0;
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck[tmp] = new Card(r, s);
				++tmp;
			}
		}
	}

	/**
	 * prints the deck
	 */
	public void printDeck() {
		for (int i = 0; i < deck.length; i++) {
			System.out.println(deck[i].toString());
		}
	}

	/**
	 * Shuffles the deck by swapping card randomly
	 */
	private void shuffleDeck() {
		for (int i = 0; i < deck.length; i++) {
			int rand = (int) (Math.random() * MAX_CARDS);
			Card tmp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = tmp;
		}
	}

	/**
	 * 
	 * @return the first card from the deck and increases the value of cardsUsed
	 *         so the next card that will be got, wont me the same.
	 */
	public Card getCardFromDeck() {
		return deck[cardsUsed++];
	}
}
