package org.leonidas.CardGames.bl;

import java.util.List;

import org.leonidas.CardGames.TexasGameRegistration;
import org.leonidas.CardGames.TexasPlayer;

public class InitGame {

	static int counter = 0;
	
	public TexasPlayer registerPlayers(List<TexasPlayer> players, String name, int chips, int spot) {

		TexasGameRegistration tgr = new TexasGameRegistration(players);
		TexasPlayer tp;
		tp = tgr.registerPlayer(name, chips, spot);
		if( tp != null ) {
			System.out.println("Counter :" + counter++);
		}
		
		return tp;
	}
	public boolean startGame() {
		if (counter == 3) {
			return true;
		}
		return false;
	}
}
