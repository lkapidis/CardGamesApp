package org.leonidas.CardGames;

import java.util.*;

/**
 * The Texas Game. Creates players, adds players, defines chief,pot and current
 * bet amount and controls the game's flow Implements the GameWithCards
 * interface
 * 
 * @author kapidis
 * 
 */
public class TexasGame implements GamesWithCards {

	TexasGameRegistration tgr;
	List<TexasPlayer> players = new ArrayList<TexasPlayer>();
	public final int MAX_PLAYERS = 9;
	GamePhase gf;
	EvaluatePhase eP;
	RankOfPlayerComparator rpc = new RankOfPlayerComparator();
	ValueComparator vc = new ValueComparator();
	TexasPlayerComparator pc = new TexasPlayerComparator();
	IntegerComparator ic = new IntegerComparator();
	ListComparator lc = new ListComparator();
	private int index = 0;
	Map<Card, Integer> sortedRanks = new TreeMap<Card, Integer>(vc);
	List<Map.Entry<Card, Integer>> sortedCardHandList = new ArrayList<Map.Entry<Card, Integer>>();
	List<Card> fullList = new ArrayList<Card>();
	List<EvaluatePhase> winner = new ArrayList<EvaluatePhase>();
	
	CardHolder tableHand = new TableHand();
	
	
	public static int chiefSpot = 0;
	public static int pot = 0;
	public static int currentBet = 0;

	public TexasGame(List<TexasPlayer> players) {
		/*
		 * TexasGameRegistration is a factory that creates and register players
		 * for Texas Poker Game
		 */
//		tgr = new TexasGameRegistration();
		this.players = players;
		
		this.startGame();
	}

	/**
	 * Implements the starGame() method from interface. Creates and adds players
	 * and controls the game phases. First adds dummy players to all spots and
	 * then adds the real ones.
	 */
	@Override
	public void startGame() {

		System.out.println("Dealing phaze.");
		gf = new DealingPhase(players, tableHand);
		gf.phase();
		gf = new PreFlop(players, tableHand);
		gf.phase();
		gf = new Flop(players, tableHand);
		gf.phase();
		gf = new Turn(players, tableHand);
		gf.phase();
		gf = new River(players, tableHand);
		gf.phase();
		
		/*
		 * Adds to the player's hand the table cards
		 */
		for (int i = 0; i < tableHand.getHand().size(); i++) {
			for (int j = 0; j < players.size(); j++) {
				if (players.get(j).getName().equals("dummy")
						|| !(players.get(j).isInGame())
						|| !(players.get(j).isActive())) {

				} else {
					players.get(j).getPlayerHand().getHand()
							.add(tableHand.getHand().get(i));
				}
			}
		}
		
		Stats st = new Stats();
		
		for (Player player : players) {
			if (player.getName().equals("dummy")) {

			} else {
				st.makeStats(player.getPlayerHand());
			}
		}
		for (Player player : players) {

			if (player.getName().equals("dummy")) {

			} else {

				for (index = 0; index < player.getPlayerHand().getHand().size(); index++) {
					sortedRanks.put(
							player.getPlayerHand().getHand().get(index),
							player.getPlayerHand()
									.getRankStats()
									.get(player.getPlayerHand().getHand()
											.get(index).getRank()));
				}

				fullList.addAll(player.getPlayerHand().getHand());
				sortedCardHandList.addAll(sortedRanks.entrySet());
				Collections.sort(sortedCardHandList, lc);
				System.out.println("---------------------");
				System.out.println("SORTED List" + sortedCardHandList);
				System.out.println("---------------------");
				

			
				System.out.println("eval "
						+ EvaluatePhase.of(sortedCardHandList, fullList));
				
					player.setEp(EvaluatePhase.of(sortedCardHandList, fullList));
				
				

			}
			sortedCardHandList.clear();
			sortedRanks.clear();
			fullList.clear();
			
		}
		//findWinner();
	}
	/**
	 * Finds the winner of the round and pays him.
	 */
	public List<TexasPlayer> findWinner(){
		List<TexasPlayer> winner = new ArrayList<TexasPlayer>();
		
		for (TexasPlayer pl : players) {
			if (pl.getName().equals("dummy")) {

			} else {
				winner.add(pl);
				
				for (int i = 0; i < pl.getPlayerHand().getStartingHand().size(); i++) {
					
					if(tableHand.getHand().contains(pl.getPlayerHand().getStartingHand().get(i))){
						pl.getPlayerHand().getStartingHand().remove(i);
						//System.out.println("Player: "+ pl.getName()+" has highcard is " + pl.getPlayerHand().getStartingHand().get(0));

					} else {
						//Collections.sort(pl.getPlayerHand().getStartingHand());
						if(pl.getPlayerHand().getStartingHand().size() == 2){
							Collections.sort(pl.getPlayerHand().getStartingHand());
							pl.getPlayerHand().getStartingHand().remove(1);
						}
					}
				}
				
			}
		}
		
		Collections.sort(winner,pc);
		System.out.println("SORTED PLAYERSs" + winner);
		winner.get(0).setChipStack(pot);
		System.out.println("The pot is at " + pot);
		System.out.println("The winner of this round is "+winner.get(0).getName()+ " and he has : "+ winner.get(0).getChipStack());
		
		return winner;
	}

}
