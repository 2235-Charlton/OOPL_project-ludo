package board;

public class Board {
	String[][] board = new String[25][48];
	String[] letters= {"A","B","C","D","E","F","G","H","I","J","K"};
	Integer x=0;
	
	public Board() { // Initializing the board
		margins();
		home(4,7);
		home(4,35);
		home(18,7);
		home(18,35);
		grid();
		end(13,24);
		
		//starting point
		safe(5,30,'B');
		safe(11,10,'B');
		safe(15,42,'B');
		safe(21,22,'B');
		
		//safe zones
		safe(7,22,'S');
		safe(15,14,'S');
		safe(11,38,'S');
		safe(19,30,'S');		
	}
	
	private void home(Integer posX, Integer posY) { //generates the start/home box
		for (Integer i=posY+1;i<posY+8;i++)
			this.board[posX][i]="_";
		for (Integer i=0;i<4;i++)
			for (Integer j=0;j<9;j++) {
				if(j%4==0)
					this.board[posX+i+1][posY+j]="|";
				else if ((i+1)%2==0)
					this.board[posX+i+1][posY+j]="_";
				else
					this.board[posX+i+1][posY+j]=" ";
			}
	}
	
	private void grid() {
		Integer x=1;

		for (Integer i=20;i<31;i++)
			board[2][i] ="_"; 
			
		for (Integer i=3;i<25;i++) {	
			board[i][19]="|";
			for (Integer j=20;j<32;j++) {
				if (x++%4==0) {
					board[i][j] ="|";
					x=1;
				}
				else if (i%2==0)
					board[i][j] ="_"; 
			}
		}
		
		
		
		for (Integer j=4;j<47;j++)
			if (board[10][j] == " ")
				board[10][j] ="_";
		
		for (Integer i=11;i<17;i++) {
			board[i][3]="|";
			x=1;
			for (Integer j=4;j<48;j++) {
					if (x++%4==0) {
						board[i][j] ="|";
						x=1;
					}
					else if (i%2==0)
						board[i][j] ="_"; 
			}
		}
	}
	
	private void margins() {
		for(Integer i=0; i<25;i++)
			for(Integer j=0; j<48; j++) {
				if(j>1 && i==1 && j%4==0)  //Generating the x-axis characters A-K
					board[i][j] = letters[x++];
				else if(i>1 && j==0 && i%2 !=0) { //Generating the vales of the y-axis 1 - 11		
					String val = Integer.toString(i/2);
					if((i/2) == 10 || i/2 == 11) { // fix for home offset at pos 10 
						board[i][j++] =  "1"; 
						board[i][j] = "0";
						if(i/2==11)
							board[i][j] = "1";
					}
					else
						board[i][j] = val; 
				}
				else //Generating the empty space
					board[i][j] = " ";
			}
	}
		
	public void safe(Integer posX, Integer posY, Character legend){
		if (legend == 'B')
			board[posX][posY] = "B";
		else
			board[posX][posY] = "S";
	}
	
	public void end(Integer posX, Integer posY){
		board[posX][posY] = "E";
		board[posX][posY+1] = "N";
		board[posX][posY+2] = "D";
	}
	
	public void PrintBoard() { //Prints the board
		for(Integer i=1; i<25; i++) {
			for(Integer j=0; j<48; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
		
	public void update() {
		
	}
}