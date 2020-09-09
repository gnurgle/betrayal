/**
 * 
 * This manages the haunt for the game. This could be expanded to contain more types
 * 
 */
package game;

public class Haunt {

	private boolean heart = false;
	private boolean brain = false;
	private boolean furnace = false;
	private int numDead = 0;
	
	public Haunt() 
	{
		
		
	}
	
	//Check state conditions
	public String checkConditions(int numPlayers)
	{
		String output = "";
		
		if (heart && brain && furnace)
			output = "Win";
		else if (numDead >= numPlayers-1)
			output = "Lose";
		else
			output = "Running";
		return output;
	}
	
	public boolean isHeart() {
		return heart;
	}

	public void setHeart(boolean heart) {
		this.heart = heart;
	}

	public boolean isBrain() {
		return brain;
	}

	public void setBrain(boolean brain) {
		this.brain = brain;
	}

	public boolean isFurnace() {
		return furnace;
	}

	public void setFurnace(boolean furnace) {
		this.furnace = furnace;
	}

	public int getNumDead() {
		return numDead;
	}
	
	public void increaseDead() {
		numDead++;
	}
	
	
}
