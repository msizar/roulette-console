package com.company;

public class Player {

	private String playerName;
	private double totalBet;
	private double totalWin;

	public Player(String playerName, double totalBet, double totalWin) {
		this.playerName = playerName;
		this.totalBet = totalBet;
		this.totalWin = totalWin;
	}

	public Player(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setTotalBet(double totalBet) {
		this.totalBet = totalBet;
	}

	public void setTotalWin(double totalWin) {
		this.totalWin = totalWin;
	}

	public double getTotalWin() {
		return totalWin;
	}

	public double getTotalBet() {
		return totalBet;
	}
}
