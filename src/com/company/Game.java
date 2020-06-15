package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final List<Player> players;
	private List<Bet> bets;

	public Game(List<Player> players) {
		this.players = players;
		bets = new ArrayList<>();
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
	 * @param betsString
	 */
	public void startDraw(List<String> betsString) {

		int result = this.generateRandomNumber();
		this.bets = setBets(betsString);

		for (Bet bet:this.bets) {
			bet.setOutcome(this.computeResult(result,bet));
		}

		this.printDrawResults(result);

	}

	/**
	 * set bets object
	 * @param betsString
	 * @return
	 */
	private List<Bet> setBets(List<String> betsString) {
		List<Bet> bets = new ArrayList<>();

		for(String betString: betsString) {
			String[] betArray = betString.split(" ");
			Player betPlayer = getPlayer(betArray[0]);

			if(betPlayer != null) {
				Bet bet = new Bet(betPlayer, Double.parseDouble(betArray[2]),betArray[1]);
				bets.add(bet);
			} else {
				System.out.println(betArray[0] + " Player not found");
			}
		}

		return bets;
	}

	/**
	 * get player by bets
	 * @param name
	 * @return
	 */
	private Player getPlayer(String name){
		Player foundPLayer = null;

		for (Player player: this.players) {
			String temp = player.getPlayerName().toLowerCase();
				if(temp.matches(name.toLowerCase()))
					foundPLayer = player;
		}

		return foundPLayer;
	}

	/**
	 * Check if play won or lost and return results
	 * @param luckyNumber
	 * @param bet
	 * @return
	 */
	private String computeResult(int luckyNumber,Bet bet) {
		String pBet = bet.getValue();
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

		bet.setWinnings(bet.getPrice() * winnings);

		return results;
	}

	/**
	 * Print single draw results
	 * @param luckyNumber
	 */
	private void printDrawResults(int luckyNumber) {
		String spacer = "       ";
		System.out.println("Results:"+ luckyNumber);
		System.out.println("Player     Bet     Outcome     Winning\n___\n");

		for (Bet bet : this.bets) {
			System.out.println(bet.getPlayer().getPlayerName()+spacer+
					bet.getValue()+spacer+
					bet.getOutcome()+ spacer+ bet.getWinnings());
		}

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
