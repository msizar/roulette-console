package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

	/**
	 * Read Files
	 * @return players
	 */
	public static List<String> getPlayersFromFile() {
		List<String> players = new ArrayList<>();

		try {
			File playersFile = new File("player.txt");
			Scanner myReader = new Scanner(playersFile);

			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				players.add(line);
			}

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return players;
	}
}
