package playerToken;

public class PlayerToken {
	private Integer[] position = new Integer[4];
	private boolean isAtHome[] = new boolean[4];
	private String home[] = new String[4];
	private String path[] = new String[44];

	public PlayerToken(String[] location, int player) {
		for (int i = 0; i < 4; i++) {
			this.position[i] = -1;
			this.isAtHome[i] = true;
			this.home[i] = location[i + (player * 4)];
		}

	}

	public Integer[] getPositions() { // returns all the piece location
		return this.position;
	}

	public void setPosition(Integer piece, Integer value) {
		if (isAtHome(piece) && value == 6) { // get out of the house
			this.position[piece] = 0;
			this.setAtHome(piece, false);
		} else if (value == 0) { // go home
			this.position[piece] = -1;
			this.setAtHome(piece, true);
		} else if (value <= 6) { // move forward
			Integer newVal = this.position[piece] + value;
			position[piece] = newVal;
		}
	}

	public boolean isAtHome(int piece) {
		return this.isAtHome[piece];
	}

	public void setAtHome(int piece, boolean atHome) {
		this.isAtHome[piece] = atHome;
	}

	public void setPlayerPath(String path[][], Integer player) {
		for (int i = 0; i < 44; i++)
			this.path[i] = path[player][i];
	}
}
