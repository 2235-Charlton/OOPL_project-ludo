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

		ArrayList<PlayerToken> player = new ArrayList<PlayerToken>();

		for (int i = 0; i < players; i++)
			player.add(new PlayerToken(pathMap, i));

		// board.printBoard();
		Dice dice = new Dice();
		int value, turn = 0;

		while (choice != 9) {
			System.out.println("Turn: player " + (turn + 1));

			System.out.print("Press 1 to roll the dice \nPress 9 to exit.");
			choice = in.nextInt();
			
			if (choice == 1) {
				value = dice.rollDice();
				System.out.println("Dice value: " + value);
			} else if (choice == 9) {
				System.out.println("Quitting...");
			} else
				System.out.println("Incorrect Option.");

			if (turn == players - 1)
				turn = 0;
			else
				turn++;

		}

	}
}