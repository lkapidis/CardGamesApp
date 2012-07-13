package org.leonidas.CardGames;

public class TexasActions implements GameActions {

	@Override
	public void fold(Player player) {
		player.setActive(false);

	}

	@Override
	public void leaveGame(Player player) {
		player.setIsInGame(false);
	}

	@Override
	public boolean call(Player player) {
		int tmp;
		System.out.println("Current bet is : " + TexasGame.currentBet);

		if (player.getDistanceFromChif() > 2
				|| player.getDistanceFromChif() == 0) {
			tmp = player.placeBet(TexasGame.currentBet);
			player.setBetAmount(TexasGame.currentBet);
			TexasGame.pot += tmp;
			System.out.println("Player " + player.getName() + " bets "
					+ TexasGame.currentBet + " and has : " + player.getChipStack());
			System.out.println("Pot is at : " + TexasGame.pot);
			return true;
		} else {
		
			if (player.getBetAmount() != TexasGame.currentBet) {
				tmp = player.placeBet(TexasGame.currentBet
						- player.getBetAmount());
				TexasGame.pot += tmp;
				player.setBetAmount(TexasGame.currentBet);
				System.out.println("Player " + player.getName()
						+ " bets " + TexasGame.currentBet
						+  " and has : "
						+ player.getChipStack());
				System.out.println("Pot is at : " + TexasGame.pot);
				player.setBetAmount(0);
				return true;
			} else {
				player.setBetAmount(0);
				return false;
			}
		}
	}

	@Override
	public void raise(Player player, int raiseAmount) {
		TexasGame.currentBet += raiseAmount;
		player.setRaised(true);
		
		
	}

	@Override
	public void check(Player player) {
		System.out.println("Player " + player.getName() + " checked ");

	}

	public void smallBlind(Player player) {
		System.out.println("DistanceFromChif: "
				+ player.getDistanceFromChif() + " chiefspot = "
				+ TexasGame.chiefSpot);
		if (player.getDistanceFromChif() == 1) {

			TexasGame.pot = player.placeBet(25);
			player.setBetAmount(25);
			TexasGame.currentBet = TexasGame.pot;
			System.out.println("Current bet is  IN SMALLBLINDS: "
					+ TexasGame.currentBet + " and player has : " + player.getChipStack());
		}
	}

	/**
	 * If the player is 2 spots after the chief, the player will place the big
	 * blind.
	 * 
	 * @param player
	 */
	public void bigBlind(Player player) {
		int tmp;
		if (player.getDistanceFromChif() == 2) {
			tmp = player.placeBet(50);
			TexasGame.pot += tmp;
			TexasGame.currentBet = tmp;
			player.setBetAmount(50);
			System.out.println("Current bet is  IN BIGBLINDS: "
					+ TexasGame.currentBet + " and player has : " + player.getChipStack());
		}
	}
}
