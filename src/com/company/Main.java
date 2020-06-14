package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	List<Player> players = getPlayersFromFile();
		Game game = null;

		Scanner sc = new Scanner(System.in);

		if(!players.isEmpty()){
			game = new Game(players);

			System.out.println("Enter bet [name] [bets] [price]");
			String bet = sc.nextLine();

			if(!bet.isBlank()) {
				game.startDraw(bet);
			} else {
				System.err.println("Empty bet not allowed");
			}

		} else {
			System.err.println("No players found on file");
		}

    }

	/**
	 * Read Files
	 * @return players
	 */
	public static List<Player> getPlayersFromFile() {
		List<Player> players = new ArrayList<>();

		try {
			File playersFile = new File("src/players.txt");
			Scanner myReader = new Scanner(playersFile);

			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				Player player = new Player(line);
				players.add(player);
			}

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return players;
	}
}
