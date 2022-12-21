package PlayerToken;

public class PlayerToken {
	  private String name;
	  private int position;
	  private boolean isAtHome;

	  public PlayerToken(String name) {
	    this.name = name;
	    this.position = 0;
	    this.isAtHome = true;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public int getPosition() {
	    return this.position;
	  }

	  public boolean isAtHome() {
	    return this.isAtHome;
	  }

	  public void setPosition(int position) {
	    this.position = position;
	  }

	  public void setAtHome(boolean atHome) {
	    this.isAtHome = atHome;
	  }
	}

