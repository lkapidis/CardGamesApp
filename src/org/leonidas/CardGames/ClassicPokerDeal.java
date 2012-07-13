package org.leonidas.CardGames;


/**
 * Takes the deck and deals one card.
 * @author kapidis
 *
 */
public class ClassicPokerDeal implements Dealing {

	private Deck deck;
	/**
	 * Takes the created deck
	 * @param deck
	 */
	public ClassicPokerDeal(Deck deck){
		this.deck = deck;
	}
	/**
	 * Draws one card from the deck and adds it to the list of cards that is taking as a parameter
	 *
	 */
	@Override
	public void deal(CardHolder cardHolder) {
		// TODO Auto-generated method stub
		
	}
}
