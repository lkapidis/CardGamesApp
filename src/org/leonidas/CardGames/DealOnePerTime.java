package org.leonidas.CardGames;

/**
 * Takes the deck and deals one card.
 * @author kapidis
 *
 */
public class DealOnePerTime implements Dealing {

	private Deck deck;
	/**
	 * Takes the created deck
	 * @param deck
	 */
	public DealOnePerTime(Deck deck){
		this.deck = deck;
	}
	/**
	 * Draws one card from the deck and adds it to the list of cards that is taking as a parameter
	 *
	 */
	public void deal(CardHolder ch){
		Card cardForDeal;
		cardForDeal = deck.getCardFromDeck();
//		if(ch.getHand().contains(cardForDeal)){
		
//			ch.getRankStats().put(cardForDeal.getRank(), 0);
//			System.out.println("$$$$$$$$$ " + cardForDeal+" ####### "+ ch.getRankStats().get(cardForDeal.getRank()));
//		}else{
//			ch.getRankStats().put(cardForDeal.getRank(), 1);
//		}
//		if (ch.getMinRank().compareTo(cardForDeal.getRank()) < 0){
//			ch.setMinRank(cardForDeal.getRank());
//		}
//		if (ch.getMaxRank().compareTo(cardForDeal.getRank()) < 0){
//			ch.setMaxRank(cardForDeal.getRank());
//		}
//		//suit stats
//		if(ch.getHand().isEmpty()){
//			ch.getSuitStats().put(cardForDeal.getSuit(), 0);
//		}
//		if(!(ch.getHand().isEmpty()) && ch.getHand().get(0).getSuit().ordinal() == cardForDeal.getSuit().ordinal()){
//			ch.getSuitStats().put(cardForDeal.getSuit(), 0);
//		}else{
//			ch.getSuitStats().put(cardForDeal.getSuit(), 1);
//		}
		
		ch.getHand().add(cardForDeal);
	}
}
