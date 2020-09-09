/**Speed roll. 4+ gain 1 speed. 1-3 lose 1 might. 0 lose 1 might and speed
 * 
 * 
 */ 
package Events;
import actors.Player;
import game.Events;

public class Rotten extends Events{
	
	public Rotten()
	{
	}
	
	public void activate(Player player)
	{
		name = "ROTTEN";
		intro = "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 4)
		{
			result = "Troubling odors, nothing more. You gain Sanity";
			player.getCharacter().incrementSanity();
		}
		else if (roll == 0)
		{
			result = "You double over with nausea. You lose Might, Speed, Knowledge, and Sanity";
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSpeed();
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementKnowledge();
		}
		else if (roll == 1)
		{
			result = "You lose Might and Speed";
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSpeed();
		}
		else
		{
			result = "You lose Might";
			player.getCharacter().decrementMight();
		}
	}
	

}
