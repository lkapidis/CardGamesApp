package org.leonidas.CardGames.bl;
import java.util.List;

import org.leonidas.CardGames.*;

public class GameEngine {
	
	List<TexasPlayer> players;
	CardHolder tableHand;
	
	public GameEngine(List<TexasPlayer> players,CardHolder tableHand) {
		super();
		this.players = players;
		this.tableHand = tableHand;
	}


	public void round(int turn) {
	
	}
	
}
