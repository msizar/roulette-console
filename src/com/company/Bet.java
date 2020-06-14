package com.company;

public class Bet {

	private final Player player;
	private final double price;
	private final String value;
	private String outcome;
	private double winnings;

	public Bet(Player player, double price, String value) {
		this.player = player;
		this.price = price;
		this.value = value;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public void setWinnings(double winnings) {
		this.winnings = winnings;
	}

	public String getOutcome() {
		return outcome;
	}

	public double getWinnings() {
		return winnings;
	}

	public Player getPlayer() {
		return player;
	}

	public double getPrice() {
		return price;
	}

	public String getValue() {
		return value;
	}
}
