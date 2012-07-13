package org.leonidas.CardGames;

/**
 * The player class. A players has a name, chip stack and a Map with a winning
 * hand
 * 
 * @author kapidis
 * 
 */
public abstract class Player {

	private String name;
	private int chipStack;
	private ChipStack cs ;
	private int betAmount;
	private boolean raised = false;
	private EvaluatePhase ep;

	/**
	 * Creation of default player
	 */
	public Player() {
		this.name = "guest";
		this.chipStack = cs.DEFAULT_CHIPS;
	}

	/**
	 * Creation of player with name and amount of chips
	 * 
	 * @param name
	 * @param cs
	 */
	public Player(String name, ChipStack cs) {
		this.name = name;
		this.chipStack = cs.getTotalChips();
	}

	/**
	 * 
	 * @return the player's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Overrides toString for better presentation of a player giving info about
	 * his name and his amount of chips
	 */
	public String toString() {
		return "Player with name: " + this.name + " has: " + this.chipStack;
	}

	/**
	 * the process of taking chips from a player's stack and betting them
	 * 
	 * @param amount
	 * @return
	 */
	public int placeBet(int amount) {
		int value;
		value = this.chipStack - amount;
		if (value >= 0) {
			this.chipStack -= amount;
			return amount;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @return player's chip stack
	 */
	public int getChipStack() {
		return chipStack;
	}

	/**
	 * @param chipStack the chipStack to set
	 */
	public void setChipStack(int chipStack) {
		this.chipStack += chipStack;
	}

	/**
	 * Abstract class giving players hand
	 * 
	 * @return player's hand
	 */
	public abstract CardHolder getPlayerHand();

	/**
	 * 
	 * @return the amount of a bet
	 */
	public int getBetAmount() {
		return this.betAmount;
	}

	/**
	 * Setting the amount of a bet
	 * 
	 * @param betAmount
	 */
	public void setBetAmount(int betAmount) {
		this.betAmount = betAmount;
	}

	/**
	 * Check if a player is forced to bet. Under construction yet.
	 * 
	 * @return
	 */
	public boolean getRaised() {
		
		return this.raised;
	}

	/**
	 * Sets if a player has to bet
	 * 
	 * @param val
	 */
	public void setRaised(boolean val) {
		this.raised = val;
	}

	public abstract void setActive(boolean val);
	public abstract boolean isActive();
	public abstract void setIsInGame(boolean val);
	public abstract boolean isInGame();
	public abstract int getTableSpot();
	public abstract int getDistanceFromChif();

	/**
	 * @return the ep
	 */
	public EvaluatePhase getEp() {
		return ep;
	}

	/**
	 * @param ep the ep to set
	 */
	public void setEp(EvaluatePhase ep) {
		this.ep = ep;
	}
}
