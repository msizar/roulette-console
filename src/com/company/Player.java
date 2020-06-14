package com.company;

import java.util.List;

public class Player {

	private String playerName;
	private String outcome;
	private double winnings;
	private List<String> bets;
	private double price;

	public Player(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public void setBet(List<String> bets) {
		this.bets = bets;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOutcome() {
		return outcome;
	}

	public List<String> getBet() {
		return bets;
	}

	public Double getWinnings() {
		return winnings;
	}

	public void setWinnings(Double winnings) {
		this.winnings = winnings;
	}

	public double getPrice() {
		return price;
	}
}
