package Events;
import actors.Player;
import game.Events;

public class BurningMan extends Events{
	
	public BurningMan()
	{
		
	}
	
	public void activate(Player player)
	{
		name = "BURNING MAN";
		intro = "A man on fire runs through the room. His skin bubbles and cracks, falling away from him and leaving a fiery skull that clatters to the ground, bounces, rolls, and disappears.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 5)
		{
			result = "You feel a little hot under the collar, but otherwise fine. You gain Sanity";
			player.getCharacter().incrementSanity();
		}
		else if (roll < 2)
		{
			result = "You burst into flames! You lose Might and Sanity as you put out the flames";
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementMight();
		}
		else
		{
			result = "Out, out, you must get out. You lose Speed as you stuggle to find the exit";
			player.getCharacter().decrementSpeed();
		}
	}
}
