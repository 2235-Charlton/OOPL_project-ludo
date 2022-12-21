package clientApp;

import board.Board;
import PlayerToken.PlayerToken;

public class ClientApp {

	public static void main(String[] args) {
		Board test= new Board();
		
		
//		PlayerToken token = new PlayerToken("Red");
//		System.out.println(token.getName()); // prints "Red"
//		System.out.println(token.getPosition()); // prints 0
//		System.out.println(token.isAtHome()); // prints true
//
//		token.setPosition(10);
//		System.out.println(token.getPosition()); // prints 10
//
//		token.setAtHome(false);
//		System.out.println(token.isAtHome()); // prints false
//
//		
		
		test.PrintBoard();
		
	}
}

