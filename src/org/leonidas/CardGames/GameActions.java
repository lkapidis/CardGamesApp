package org.leonidas.CardGames;

public interface GameActions {

	
	public void fold(Player player);
	public void leaveGame(Player player);
	public boolean call(Player player);
	public void raise(Player player, int raiseAmount);
	public void check(Player player);
	public void smallBlind(Player player);
	public void bigBlind(Player player);
}
