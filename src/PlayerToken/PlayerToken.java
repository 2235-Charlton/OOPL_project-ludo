package playerToken;

public class PlayerToken {
	private Integer[] position = { -1, -1, -1, -1 };
	private boolean isAtHome[] = new boolean[4];
	private String home[] = new String[4];
	private String path[] = new String[43];

	public PlayerToken(String[] location, int player) {
		for (int i = 0; i < 4; i++) {
			this.isAtHome[i] = true;
			this.home[i] = location[i + (player * 4)];
		}

	}

	public Integer[] getPositions(){ //returns all the piece location 
	return this.position;
	}

	public void setPosition(int piece, int value) {
		if (isAtHome(piece) && value == 6) //get out of the house
			this.position[piece] = 0;
		else if(value==0) //go back home
			this.position[piece] = -1;
		else //move forward
			this.position[piece] += value;

	}

	public boolean isAtHome(int piece) {
		return this.isAtHome[piece];
	}

	public void setAtHome(boolean atHome, int piece) {
		this.isAtHome[piece] = atHome;
	}

	public void setPlayerPath(String path[][], Integer player) {
		for (int i = 0; i < 43; i++)
			this.path[i] = path[player][i];
	}
}
