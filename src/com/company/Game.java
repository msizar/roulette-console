package com.company;

import java.util.List;

public class Game {

	private final List<Player> players;

	public Game(List<Player> players) {
		this.players = players;
	}

	/**
	 * Generate winning number
	 * @return
	 */
	private int generateRandomNumber() {
		int min = 0;
		int max = 36;

		return (int)(Math.random() * max + min+1);
	}

	/**
	 * Begin setup draw
	 * @param bet
	 */
	public void startDraw(String bet) {
		String[] betArray = bet.split(" ");
		boolean playerExist = false;

		int luckyNUmber = this.generateRandomNumber();

		for (Player player: this.players) {

			if(player.getPlayerName().matches(betArray[0])) {
				playerExist = true;
				player.setBet(betArray[1]);
				player.setPrice(Double.parseDouble(betArray[2]));
				player.setOutcome(computeResult(luckyNUmber, player));
				printDrawResults(luckyNUmber,player);
			}
		}

		if(!playerExist) {
			System.out.println("Player not found");
			return;
		}
	}

	/**
	 * Check if play won or lost and return results
	 * @param luckyNumber
	 * @param player
	 * @return
	 */
	private String computeResult(int luckyNumber,Player player) {
		String pBet = player.getBet();
		String results = "LOSE";
		double winnings = 0;

		if(isNumeric(pBet)) {
			if( Integer.parseInt(pBet) == luckyNumber){
				results = "WIN";
				winnings = 36;
			}

		}else {

			if(pBet.toUpperCase().matches("EVEN") && luckyNumber % 2 == 0)  {
				results = "WIN";
				winnings = 2;
			}

			if(pBet.toUpperCase().matches("ODD") && luckyNumber % 2 != 0)  {
				results = "WIN";
				winnings = 2;
			}

		}

		player.setWinnings(player.getPrice() * winnings);

		return results;
	}

	/**
	 * Print single draw results
	 * @param luckyNumber
	 * @param player
	 */
	private void printDrawResults(int luckyNumber,Player player) {
		String spacer = "    ";
		System.out.println("Results:"+ luckyNumber);
		System.out.println("Player     Bet     Outcome     Winning\n___\n");
		System.out.println(player.getPlayerName()+"   "+
				player.getBet()+spacer+
				player.getPrice()+spacer+
				player.getOutcome()+ spacer+ player.getWinnings());
	}

	/**
	 * Check if value is number
	 * @param str
	 * @return
	 */
	private boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * Print all bet info
	 */
	public void printSummary() {
		int result = generateRandomNumber();

		System.out.println("Results:"+ result);

		System.out.println("Player     Bet     Outcome     Winning\n___\n");
		for (Player player: players) {
			System.out.println(player.getPlayerName()+"   "+player.getBet()+
					"   "+player.getPrice());
		}
	}
}
