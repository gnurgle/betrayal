/**
 * 
 * This is the base class for characters and other entities
 * It modifies base stats and tracks a few common essential stats
 */

package actors;



public class Actors {

	//Actor Stats
	protected int speed;
	protected int might;
	protected int sanity;
	protected int knowledge;
	protected boolean injured = false;
	protected boolean healed = false;
	//Per turn information
	protected int movement;		//How much movement is left
	protected boolean attacked;	//If actor has attacked this turn
	protected boolean discover;	//If actor can discover rooms
	
	//Get methods for stats
	public int getSpeed()
	{
		return speed;
	}
	
	public int getMight()
	{
		return might;
	}
	
	public int getSanity()
	{
		return sanity;
	}
	
	public int getKnowledge()
	{
		return knowledge;
	}
	
	//Increment and Decrement methods for stats
	
	public void incrementSpeed()
	{
		if (speed < 8)
			speed++;
		healed = true;
	}
	
	public void incrementMight()
	{
		if (might < 8)
			might++;
		healed = true;
	}
	
	public void incrementSanity()
	{
		if (sanity < 8)
			sanity++;
		healed = true;
	}
	
	public void incrementKnowledge()
	{
		if (knowledge < 8)
			knowledge++;
		healed = true;
	}
	
	public void decrementSpeed()
	{
		if (speed > 0)
			speed--;
		injured = true;
	}
	
	public void decrementMight()
	{
		if (might > 0)
			might--;
		injured = true;
	}
	
	public void decrementSanity()
	{
		if (sanity > 0)
			sanity--;
		injured = true;
	}
	
	public void decrementKnowledge()
	{
		if (knowledge > 0)
			knowledge--;
		injured = true;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public void setSpeed(int speed) {
		if (speed < getSpeed())
			setInjured(true);
		if (speed > getSpeed())
			setHealed(true);
		this.speed = speed;
	}

	public void setMight(int might) {
		if (might < getMight())
			setInjured(true);
		if (might > getMight())
			setHealed(true);
		this.might = might;
	}

	public void setSanity(int sanity) {
		if (sanity < getSanity())
			setInjured(true);
		if (sanity > getSanity())
			setHealed(true);
		this.sanity = sanity;
	}

	public void setKnowledge(int knowledge) {
		if (knowledge < getKnowledge())
			setInjured(true);
		if (knowledge > getKnowledge())
			setHealed(true);
		this.knowledge = knowledge;
	}

	public boolean isInjured() {
		return injured;
	}

	public void setInjured(boolean injured) {
		this.injured = injured;
	}

	public boolean isHealed() {
		return healed;
	}

	public void setHealed(boolean healed) {
		this.healed = healed;
	}
	
	
}
