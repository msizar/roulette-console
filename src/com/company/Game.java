package com.company;

import java.util.List;

public class Game {

	private final List<Player> players;

	public Game(List<Player> players) {
		this.players = players;
	}


	private int generateRandomNumber() {
		int min = 0;
		int max = 36;
		int random = (int)(Math.random() * max + min+1);
		return random;
	}

	public void startDraw(String bet) {
		String[] betArray = bet.split(" ");
		boolean playerExist = false;

		for (Player player: this.players) {

			if(player.getPlayerName().matches(betArray[0])) {
				playerExist = true;
				player.setPrice(Double.parseDouble(betArray[2]));
				printDrawResults(player);
			}
		}

		if(!playerExist) {
			System.out.println("Player not found");
			return;
		}
	}

	private void printDrawResults(Player player) {
		int result = generateRandomNumber();

		System.out.println("Results:"+ result);

		System.out.println("Player   Bet   Outcome   Winning\n___\n");
			System.out.println(player.getPlayerName()+"   "+player.getBet().toString()+
					"   "+player.getPrice());
	}

	public void printSummary() {
		int result = generateRandomNumber();

		System.out.println("Results:"+ result);

		System.out.println("Player   Bet   Outcome   Winning\n___\n");
		for (Player player: players) {
			System.out.println(player.getPlayerName()+"   "+player.getBet().toString()+
					"   "+player.getPrice());
		}
	}
}
