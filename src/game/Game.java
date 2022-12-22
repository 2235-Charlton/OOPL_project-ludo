package game;

import java.util.Scanner;

import board.Board;
import dice.Dice;
import playerToken.PlayerToken;

public class Game {
	public Game() {
		Scanner in = new Scanner(System.in);
		int choice=0, players=0;
		System.out.println("------------Ludo Game-----------");
		while( players >4 || players <2) {
			System.out.println("Enter the no. of players[2-4]:");
			players = in.nextInt();
		}

		
		
		Board board = new Board();
		String[] pathMap =  board.getBlockNames();
		
		PlayerToken player1 = new PlayerToken(pathMap,0);
		PlayerToken player2 = new PlayerToken(pathMap,1);
		
		if(players<=4 && players>2){
			PlayerToken player3 = new PlayerToken(pathMap,2);
		}
		if(players==4){
			PlayerToken player4 = new PlayerToken(pathMap,3);
		}
		
		// board.printBoard();
		Dice dice = new Dice();
		int value;

		while (choice !=9) {
			System.out.println("Press 1 to roll the dice \nPress 9 to exit.");
			choice = in.nextInt();
			
			if (choice == 1) {
				value = dice.rollDice();
				System.out.println("Dice value: "+value);
			}
			else if (choice == 9) {
				System.out.println("Quitting...");
			}
			else 
				System.out.println("Incorrect Option.");
		}
		
		
		
	}
}