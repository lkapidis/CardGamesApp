package org.leonidas.CardGames;

import java.util.*;

/**
 * Evaluates if a current player has a winning hand and places the result in
 * player's Map
 * 
 * @author kapidis
 * 
 */
public enum EvaluatePhase {

	RoyalFlush {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {
			if (!StraightFlush.is(hand,fullList))
				return false;

			return hand.get(0).getKey().getRank().ordinal() == Rank.ACE
					.ordinal();
		}
	},
	StraightFlush {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {
			
			if(Straight.is(hand, fullList) && Flush.is(fiveHand, fullList)){
				return true;
			} else {
			return false;
			}

		}
	},
	FourOfAKind {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {

			return hand.get(0).getValue() == 4;
		}
	},
	FullHouse {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {
			if (hand.get(0).getValue() == 3
					&& hand.get(1).getValue() == 2) {
				return true;
			} else if (hand.get(0).getValue() == 3
					&& hand.get(1).getValue() == 3) {
				return true;
			} else {
				return false;
			}
		}
	},
	 Flush {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {
			int counter = 0;
			List<Card> flushCheck = new ArrayList<Card>();
			flushCheck.addAll(fullList);
			SuitComparator sc = new SuitComparator();
			Collections.sort(flushCheck,sc);
			
			for (int i = 0; i < hand.size()-1; i++) {
				if(flushCheck.get(i).getSuit() == flushCheck.get(i+1).getSuit()){
					counter++;
					
					if(counter==4){
						return true;
					} 
				} else {
					counter=0;
				}
			}
			return false;
		}
	},
	Straight {
		
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {
		List<Map.Entry<Card, Integer>> straightCheck = new ArrayList<Map.Entry<Card, Integer>>();
		
		
		straightCheck.addAll(hand);
		IntegerComparator ic = new IntegerComparator();
		Collections.sort(straightCheck,ic);

			for (int i = 0; i < straightCheck.size() - 4; i++) {
				if ((straightCheck.get(i+4).getKey().getRank().ordinal() - straightCheck.get(i).getKey().getRank().ordinal()) == 4) {
					for (int j = i; j < i+5; j++) {
						if(fiveHand.size()<5){
							fiveHand.add(straightCheck.get(j));
						}
					}
					
					return true;
				}
			}
			return false;
		}
	},
	ThreeOfAKind {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {

			return hand.get(0).getValue() == 3 && hand.get(1).getValue() == 1;
		}
	},
	TwoPair {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {
	
			return hand.get(0).getValue() == 2 && hand.get(1).getValue() == 2;
		}
	},
	OnePair {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {

			return hand.get(0).getValue() == 2 && hand.get(1).getValue() == 1;
		}
	},
	HighCard {
		public Boolean is(List<Map.Entry<Card, Integer>> hand, List<Card> fullList) {
			if (Straight.is(hand,fullList)) {
				return false;
			}
			return hand.iterator().next().getValue() == 1;
		}
	};
	public List<Map.Entry<Card, Integer>> fiveHand = new ArrayList<Map.Entry<Card, Integer>>(5);
	public abstract Boolean is(List<Map.Entry<Card, Integer>> hand,List<Card> fullList);
	

	static EvaluatePhase of(List<Map.Entry<Card, Integer>> hand,List<Card> fullList) {
		for (EvaluatePhase ph : EvaluatePhase.values()) {
			if (ph.is(hand,fullList))
				return ph;
		}
		return null;
	}

}
