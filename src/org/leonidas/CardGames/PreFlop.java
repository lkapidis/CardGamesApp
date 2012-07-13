package org.leonidas.CardGames;

import java.util.List;
/**
 * The first phase of Texas game.
 * This phase deals cards and
 * places blinds and bets
 * @author kapidis
 *
 */
public class PreFlop implements GamePhase {


	List<TexasPlayer> players;
	CardHolder tableHand;
	GameActions action = new TexasActions();
	
	
	public PreFlop(List<TexasPlayer> players ,CardHolder tableHand){
		this.players= players;
		this.tableHand = tableHand;
	}
	
	/**
	 * Overrides the phase method
	 */
	@Override
	public boolean phase() {

		this.placeBlinds();
		this.preFlopGame();
		return true;
	}
	
	private void preFlopGame() {
		System.out.println("PREFLOP PHAZE");

		boolean result;

		int turn = TexasGame.chiefSpot + 3;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(turn).getName().equals("dummy")
					|| !(players.get(turn).isInGame())
					|| !(players.get(turn).isActive())) {

			} else {
				System.out.println("Player" +players.get(turn).getName() + " calls ");
				result = action.call(players.get(turn));

				if (result) {
					System.out.println("Call done.");
				} else {
					// action.fold(players.get(turn));
				}

			}
			turn++;
			if (turn == players.size()) {
				turn = 0;
			}
		}
		TexasGame.currentBet = 50;
	}
	
	
	/**
	 * Places the small and big blinds from the next to players from the chief
	 */
    private void placeBlinds(){
    	System.out.println("Blinds PHAZE");
    	int turn =TexasGame.chiefSpot + 1;
    	for (int i=0; i<players.size(); i++) {
			if(players.get(turn).getName().equals("dummy") || !(players.get(turn).isInGame()) || !(players.get(turn).isActive())){

			}else{
				action.smallBlind(players.get(turn));
				action.bigBlind(players.get(turn));
				System.out.println("Blinds done");
			}
			turn++;
			if(turn == players.size()){
				turn = 0;
			}	
    	}
    }
}
