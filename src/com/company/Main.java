package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		List<Player> players = getPlayersFromFile();

		System.out.println(players);
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
