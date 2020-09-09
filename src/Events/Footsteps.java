package Events;
import actors.Player;
import game.Events;

public class Footsteps extends Events{
	
	public Footsteps()
	{
	}
	
	public void activate(Player player)
	{
		name = "FOOTSTEPS";
		intro = "The floorboards slowly creak. Dust rises. Footprints appear on the dirty floor. And then, as they reach you, they are gone.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(2);
		if (roll > 1)
		{
			result = "You gain Might";
			player.getCharacter().incrementMight();
		}
		else if (roll == 0)
		{
			result = "You lose Speed.";
			player.getCharacter().decrementSpeed();
		}
		else
		{
			result = "You Lose Sanity";
			player.getCharacter().decrementSanity();
		}
	}
}
