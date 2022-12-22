package board;

import java.util.HashMap;
import java.util.Map;

import path.Path;

public class Board {
	private String[][] board = new String[25][48];
	private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };
	private Integer x = 0;
	private Integer[] posX = new Integer[73];
	private Integer[] posY = new Integer[73];
	private String[] blockName = {
			// home blocks
			"B2", "C2", "B3", "C3",
			"I2", "J2", "I3", "J3",
			"B9", "C9", "B10", "C10",
			"I9", "J9", "I10", "J10",
			// rest of the blocks
			"E1", "F1", "G1",
			"E2", "F2", "G2",
			"E3", "F3", "G3",
			"E4", "F4", "G4",
			"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5", "I5", "J5", "K5",
			"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6", "I6", "J6", "K6",
			"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7", "I7", "J7", "K7",
			"E8", "F8", "G8",
			"E9", "F9", "G9",
			"E10", "F10", "G10",
			"E11", "F11", "G11",
	};
	private Map<String, Path> blocks = new HashMap<String, Path>();
	private String movementOrder[][] = {
		{"B6","C5","D5","E5","E4","E3","E2","E1","F1","G1","G2","G3","G4","G5","H5","I5","J5","K5","K6","K7","J7","I7","H7","G7","G8","G9","G10","G11","F11","E11","E10","E9","E8","E7","D7","C7","B7","A7","A6","B6","C6","D6","E6","F6"},
		{"G2","G3","G4","G5","H5","I5","J5","K5","K6","K7","J7","I7","H7","G7","G8","G9","G10","G11","F11","E11","E10","E9","E8","E7","D7","C7","B7","A7","A6","A5","B5","C5","D5","E5","E4","E3","E2","E1","F1","F2","F3","F4","F5","F6"},
		{"J7","I7","H7","G7","G8","G9","G10","G11","F11","E11","E10","E9","E8","E7","D7","C7","B7","A7","A6","A5","B5","C5","D5","E5","E4","E3","E2","E1","F1","G1","G2","G3","G4","G5","H5","I5","J5","K5","K6","J6","I6","H6","G6","F6"},
		{"E10","E9","E8","E7","D7","C7","B7","A7","A6","A5","B5","C5","D5","E5","E4","E3","E2","E1","F1","G1","G2","G3","G4","G5","H5","I5","J5","K5","K6","K7","J7","I7","H7","G7","G8","G9","G10","G11","F11","F10","F9","F8","F7","F6"},
	};

	public Board() { // Initializing the board
		margins();
		grid();
		mapBoxes();
		home(4, 7);
		home(4, 35);
		home(18, 7);
		home(18, 35);

		end("F6");

		// starting point
		safe("G2", 'B');
		safe("B5", 'B');
		safe("J7", 'B');
		safe("E10", 'B');

		// safe zones
		safe("E3", 'S');
		safe("I5", 'S');
		safe("C7", 'S');
		safe("G9", 'S');

		// test
		// safe(blocks.get("G11").getxPos(), blocks.get("G11").getyPos(), 'B');
		// end test
	}

	private void home(Integer posX, Integer posY) { // generates the start/home box
		for (Integer i = posY + 1; i < posY + 8; i++)
			this.board[posX][i] = "_";
		for (Integer i = 0; i < 4; i++)
			for (Integer j = 0; j < 9; j++) {
				if (j % 4 == 0)
					this.board[posX + i + 1][posY + j] = "|";
				else if ((i + 1) % 2 == 0)
					this.board[posX + i + 1][posY + j] = "_";
				else
					this.board[posX + i + 1][posY + j] = " ";
			}
	}

	private void grid() {
		Integer x = 1;

		for (Integer i = 20; i < 31; i++)
			board[2][i] = "_";

		for (Integer i = 3; i < 25; i++) {
			board[i][19] = "|";
			for (Integer j = 20; j < 32; j++) {
				if (x++ % 4 == 0) {
					board[i][j] = "|";
					x = 1;
				} else if (i % 2 == 0)
					board[i][j] = "_";
			}
		}

		for (Integer j = 4; j < 47; j++)
			if (board[10][j] == " ")
				board[10][j] = "_";

		for (Integer i = 11; i < 17; i++) {
			board[i][3] = "|";
			x = 1;
			for (Integer j = 4; j < 48; j++) {
				if (x++ % 4 == 0) {
					board[i][j] = "|";
					x = 1;
				} else if (i % 2 == 0)
					board[i][j] = "_";
			}
		}
	}

	private void margins() {
		for (Integer i = 0; i < 25; i++)
			for (Integer j = 0; j < 48; j++) {
				if (j > 1 && i == 1 && j % 4 == 0) // Generating the x-axis characters A-K
					board[i][j] = letters[x++];
				else if (i > 1 && j == 0 && i % 2 != 0) { // Generating the vales of the y-axis 1 - 11
					String val = Integer.toString(i / 2);
					if ((i / 2) == 10 || i / 2 == 11) { // fix for home offset at pos 10
						board[i][j++] = "1";
						board[i][j] = "0";
						if (i / 2 == 11)
							board[i][j] = "1";
					} else
						board[i][j] = val;
				} else // Generating the empty space
					board[i][j] = " ";
			}
	}

	private void safe(String location, Character legend) {
		if (legend == 'B') // starting safe
			board[blocks.get(location).getxPos()][blocks.get(location).getyPos() + 2] = "B";
		else // stars
			board[blocks.get(location).getxPos()][blocks.get(location).getyPos() + 2] = "S";
	}

	private void end(String end) {
		Integer posX = blocks.get(end).getxPos(), posY = blocks.get(end).getyPos();
		board[posX][posY] = "E";
		board[posX][posY + 1] = "N";
		board[posX][posY + 2] = "D";
	}

	public void printBoard() { // Prints the board
		for (Integer i = 1; i < 25; i++) {
			for (Integer j = 0; j < 48; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private void pathGenRight(Integer x, Integer y, Integer i) {
		this.posX[i] = x;
		this.posY[i] = y + 4;
	}

	private void pathGenDown(Integer x, Integer y, Integer i) {
		this.posX[i] = x + 2;
		this.posY[i] = y;
	}

	private void mapBoxes() {
		for (int i = 0; i < blockName.length; i++) {
			// generating the homes
			if (i == 0) {
				posX[i] = 5;
				posY[i] = 8;
			} else if (i == 1)
				pathGenRight(posX[i - 1], posY[i - 1], i);
			else if (i == 2)
				pathGenDown(posX[i - 1], posY[i - 1] - 4, i);
			else if (i == 3)
				pathGenRight(posX[i - 1], posY[i - 1], i);

			else if (i == 4) {
				posX[i] = 5;
				posY[i] = 36;
			} else if (i == 5)
				pathGenRight(posX[i - 1], posY[i - 1], i);
			else if (i == 6)
				pathGenDown(posX[i - 1], posY[i - 1] - 4, i);
			else if (i == 7)
				pathGenRight(posX[i - 1], posY[i - 1], i);

			else if (i == 8) {
				posX[i] = 19;
				posY[i] = 8;
			} else if (i == 9)
				pathGenRight(posX[i - 1], posY[i - 1], i);
			else if (i == 10)
				pathGenDown(posX[i - 1], posY[i - 1] - 4, i);
			else if (i == 11)
				pathGenRight(posX[i - 1], posY[i - 1], i);

			else if (i == 12) {
				posX[i] = 19;
				posY[i] = 36;
			} else if (i == 13)
				pathGenRight(posX[i - 1], posY[i - 1], i);
			else if (i == 14)
				pathGenDown(posX[i - 1], posY[i - 1] - 4, i);
			else if (i == 15)
				pathGenRight(posX[i - 1], posY[i - 1], i);

			// rest of the board
			else if (i < 28) {
				if (i == 16) {
					posX[i] = 3;
					posY[i] = 20;
				} else if ((i - 1) % 3 == 0)
					pathGenDown(posX[i - 1], 20, i);
				else
					pathGenRight(posX[i - 1], posY[i - 1], i);
			} else if (i < 61) {
				if (i == 28) {
					posX[i] = 11;
					posY[i] = 4;
				} else if ((i - 6) % 11 == 0)
					pathGenDown(posX[i - 1], 4, i);
				else
					pathGenRight(posX[i - 1], posY[i - 1], i);
			} else {
				if (i == 61) {
					posX[i] = 17;
					posY[i] = 20;
				} else if ((i - 1) % 3 == 0 && i != 72)
					pathGenDown(posX[i - 1], 20, i);
				else
					pathGenRight(posX[i - 1], posY[i - 1], i);
			}
		}
		for (int i = 0; i < blockName.length; i++) {
			blocks.put(blockName[i], new Path(posX[i], posY[i]));
		}
	}

	public String[] getBlockNames() {
		return blockName;
	}
	
	public String[][] getOrder(){
		return movementOrder;
	}

	public void update() {
		
		printBoard();
	}
}