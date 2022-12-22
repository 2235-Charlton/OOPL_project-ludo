package game;

import java.util.ArrayList;
import java.util.Scanner;

import board.Board;
import dice.Dice;
import playerToken.PlayerToken;

public class Game {
	public Game() {
		Scanner in = new Scanner(System.in);
		int choice = 0, players = 0;
		System.out.println("------------Ludo Game-----------");
		while (players > 4 || players < 2) {
			System.out.println("Enter the no. of players[2-4]:");
			players = in.nextInt();
		}

		Board board = new Board();
		String[] pathMap = board.getBlockNames();
		String[][] order = board.getOrder();

		ArrayList<PlayerToken> player = new ArrayList<PlayerToken>();

		for (int i = 0; i < players; i++) {
			player.add(new PlayerToken(pathMap, i)); // assign home
			player.get(i).setPlayerPath(order, i);// assign path
		}

		// board.printBoard();
		Dice dice = new Dice();
		int value = 0, turn = 0;

		while (choice != 9) {
			board.printBoard();
			
			System.out.println("Turn: player " + (turn + 1));

			System.out.print("Press 1 to roll the dice \nPress 9 to exit.");
			choice = in.nextInt();

			if (choice == 1) {
				value = dice.rollDice();
				System.out.println("Dice value: " + value);
			} else if (choice == 9) {
				System.out.println("Quitting...");
				return;
			} else
				System.out.println("Incorrect Option.");


			for (int i = 0; i < players; i++) { // displaying the player location
				Integer temp[] = player.get(i).getPositions();
				System.out.print("Player " + (i + 1) + "{");
				for (int j = 0; j < 4; j++) {
					if (temp[j] == -1)
						System.out.print(" " + pathMap[i + (j * 4)]);
					else
						System.out.print(" " + order[i][j]);
				}
				System.out.println(" }");
			}
			System.out.println();

			// rest of the logic goes here

			if (value != 6) { // selecting the next player's turn
				if (turn == players - 1)
					turn = 0;
				else
					turn++;
			}
		}

	}
}