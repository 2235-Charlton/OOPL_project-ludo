package game;

import java.util.Scanner;

public class Game {
	public Game() {
		Scanner in = new Scanner(System.in);
		int choice=0, players=0;
		System.out.println("------------Ludo Game-----------");
		while( players >4 || players <2) {
			System.out.println("Enter the no. of players[2-4]:");
			players = in.nextInt();
		}
		
		while (choice !=9) {
			System.out.println("Press 1 to roll the dice \nPress 9 to exit.");
			choice = in.nextInt();
			
			if (choice == 1) {
				
			}
			else if (choice == 9) {
				System.out.println("Quitting...");
			}
			else 
				System.out.println("Incorrect Option.");
		}
		
		
		
	}
}