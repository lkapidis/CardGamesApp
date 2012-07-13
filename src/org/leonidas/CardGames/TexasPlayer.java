package org.leonidas.CardGames;

/**
 * A specific player for Texas with info whether he is active or in game, his
 * table spot and his cards.
 * 
 * @author kapidis
 * 
 */
public class TexasPlayer extends Player {

	private boolean isActive = false;
	private boolean isInGame = true;
	private int tableSpot;
	private CardHolder cards = new PlayerHand();

	/**
	 * Creation of a Texas Player
	 * 
	 * @param isActive
	 * @param tableSpot
	 * @param distanceFromChif
	 * @param cards
	 */
	public TexasPlayer(String name, ChipStack cs, int tableSpot) {
		super(name, cs);
		this.isActive = true;
		this.tableSpot = tableSpot;
	}

	/**
	 * Creation a default Texas player with only parameter his table spot
	 * 
	 * @param tableSpot
	 */
	public TexasPlayer(int tableSpot) {
		super();
		this.isActive = true;
		this.tableSpot = tableSpot;
	}

	/**
	 * Sets if the player is active, not folded
	 * 
	 * @param val
	 */
	public void setActive(boolean val) {
		this.isActive = val;
	}

	/**
	 * 
	 * @return if the player is active
	 */
	public boolean isActive() {
		return this.isActive;
	}

	/**
	 * Sets the player in game or not
	 * 
	 * @param val
	 */
	public void setIsInGame(boolean val) {
		this.isInGame = val;
	}

	/**
	 * 
	 * @return if a player is in game
	 */
	public boolean isInGame() {
		return this.isInGame;
	}

	/**
	 * @return the tableSpot
	 */
	public int getTableSpot() {
		return tableSpot;
	}

	/**
	 * @return the distanceFromChif
	 */
	public int getDistanceFromChif() {
		System.out.println("player " + this.getName() + " thesi "
				+ this.tableSpot);
		return tableSpot - TexasGame.chiefSpot;
	}

	/**
	 * returns the players cards.
	 */
	public CardHolder getPlayerHand() {
		return cards;
	}
}
