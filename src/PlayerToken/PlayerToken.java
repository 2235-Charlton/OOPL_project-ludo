package playerToken;

public class PlayerToken {
//	  private String name;
	  private Integer[] position = new Integer[4];
	  private boolean isAtHome[]= new boolean[4];
	  private String home[] = new String[4];

	  public PlayerToken(String[] location, int player) {
		for(int i=0;i<4;i++){
	    	this.isAtHome[i] = true;
			this.home[i] = location[i+(player*4)];
			System.out.println(player+" "+(i+(player*4)));

		}
	    
	  }

//	  public String getName() {
//	    return this.name;
//	  }

	  public int getPosition() {
	    return this.position[0];
	  }

	  public void setPosition(int piece, int position) {
		  
		this.position[piece] = position;
	  }

	  public boolean isAtHome(int piece) {
	    return this.isAtHome[piece];
	  }

	  public void setAtHome(boolean atHome, int piece) {
	    this.isAtHome[piece] = atHome;
	  }
	  
	//   private void setHome(String location) {		   
	// 	  this.position[0] = location;
	// 	  this.position[1] = location;
	// 	  this.position[2] = location;
	// 	  this.position[3] = location;
	//   }

	//   public void setPlayerPath(String path[][]){
	// 	this.path=path;
	//   }
	}

