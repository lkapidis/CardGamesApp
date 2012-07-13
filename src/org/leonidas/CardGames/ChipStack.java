package org.leonidas.CardGames;
/**
 * The chips
 * @author kapidis
 *
 */
public class ChipStack {
	
	private int totalChips;
	public final int DEFAULT_CHIPS = 1000;
	/**
	 * Constructor of ChipStack. Setting the starting amount of chips that a player uses.
	 * @param totalChips
	 */
	public ChipStack(int totalChips) {
		super();
		this.totalChips = totalChips;
	}
	/**
	 * Constructor of ChipStack. Setting the default starting amount of chips that a player uses.
	 */
	public ChipStack() {
		super();
		this.totalChips = DEFAULT_CHIPS;
	}
	/**
	 * @return the totalChips
	 */
	public int getTotalChips() {
		return totalChips;
	}
	/**
	 * @param totalChips the totalChips to set
	 */
	public void setTotalChips(int totalChips) {
		this.totalChips = totalChips;
	}
	
	
}
