package Events;
import actors.Player;
import game.Events;

public class Funeral extends Events{
	
	public Funeral()
	{
	}
	
	public void activate(Player player)
	{
		name = "FUNERAL";
		intro = "You see and open coffin. You're inside it.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 3)
		{
			result = "You blink, and it's gone. You gain Sanity";
			player.getCharacter().incrementSanity();
		}
		else if (roll < 2)
		{
			result = "You're really in that coffin. You lose Sanity and Might as you dig yourself out.";
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSanity();
		}
		else
		{
			result = "The vision disturbs you. You lose Sanity";
			player.getCharacter().decrementSanity();
		}
	}
}
