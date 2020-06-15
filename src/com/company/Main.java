package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

    	List<Player> players = getPlayersFromFile();
    	List<String> betsString = new ArrayList<>();
		Game game = null;
		Scanner sc = new Scanner(System.in);
		Timer timer = new Timer();
		final boolean[] betIsOpen = {true};

		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				betIsOpen[0] = false;
				sc.close();
				timer.cancel();
				System.out.println("time up....");

			}
		};

		timer.schedule(task, 10000);


		if(!players.isEmpty()){
			game = new Game(players);

			while (betIsOpen[0]) {
				System.out.println("Enter bet [name] [bets] [price]");
				String bet = sc.nextLine();
				betsString.add(bet);
			}

			//check if betting time is open
			if(!betIsOpen[0]) {

				if(!betsString.isEmpty()) {
					game.startDraw(betsString);
				} else {
					System.err.println("Empty bets not allowed");
				}
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
				String lineArr[] = line.split(",");

				double totalWin = lineArr.length > 1 ? Double.parseDouble(lineArr[1]) : 0;
				double totalBet = lineArr.length > 2 ? Double.parseDouble(lineArr[2]) : 0;

				Player player = new Player(lineArr[0],totalBet,totalWin);
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
