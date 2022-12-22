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
			player.get(i).setPlayerPath(order, i); // assign path
		}

		// board.printBoard();
		Dice dice = new Dice();
		int value = 0, turn = 0;

		while (choice != 9) {
			board.printBoard();

			showPosition(player, players, pathMap, order);
			System.out.println("Turn: player " + (turn + 1));

			System.out.print("Press 1 to roll the dice \nPress 9 to exit.");
			choice = in.nextInt();
			if (choice == 1) {
				value = dice.rollDice();
				System.out.println("Dice value: " + value);

				System.out.print("Select the token you want to move[");
				Integer position[] = player.get(turn).getPositions();
				Boolean[] movable = { false, false, false, false };
				Boolean hasMovable = false;
				for (int i = 0; i < 4; i++) {
					if (player.get(turn).isAtHome(i) && value == 6) {
						movable[i] = true;
						hasMovable = true;
					} else if (player.get(turn).isAtHome(i) == false && (position[i] + value) < 44) {
						movable[i] = true;
						hasMovable = true;
					}
				}

				for (int i = 0; i < 4; i++) {
					if (movable[i])
						System.out.print(" " + (i + 1));
				}
				System.out.println(" ]:");

				if (hasMovable) {
					Integer token = in.nextInt();
					while (token<=0 || token>4 || !movable[token-1]) {
						System.out.println("Invalid selection!");
						token = in.nextInt();
					}
					player.get(turn).setPosition((token-1), value);
				}


			} else if (choice == 9) {
				System.out.println("Quitting...");
				return;
			} else
				System.out.println("Incorrect Option.");

			// rest of the logic goes here

			if (value != 6) { // selecting the next player's turn
				if (turn == players - 1)
					turn = 0;
				else
					turn++;
			}
		}

	}

	private void showPosition(ArrayList<PlayerToken> player, Integer players, String[] pathMap, String[][] order) {
		for (int i = 0; i < players; i++) { // displaying the player location
			Integer temp[] = player.get(i).getPositions();
			System.out.print("Player " + (i + 1) + "{");
			for (int j = 0; j < 4; j++) {
				if (temp[j] == -1) // position when the token/pieces are at home
					System.out.print(" " + pathMap[j + (i * 4)]);
				else // pieces are on the move
					System.out.print(" " + order[i][temp[j]]);
			}
			System.out.println(" }");
		}
		System.out.println();
	}
}