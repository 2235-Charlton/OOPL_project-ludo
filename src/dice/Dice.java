package dice;

import java.util.Random;

public class Dice {
	public Dice() {
		
	}
	
	public int rollDice() {
		Random r=new Random();
		return r.nextInt(6)+1;
	}
}
