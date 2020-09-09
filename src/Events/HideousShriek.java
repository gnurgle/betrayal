package Events;
import actors.Player;
import game.Events;

public class HideousShriek extends Events{

	public HideousShriek()
	{
	}
	
	public void activate(Player player)
	{
		name = "HIDEOUS SHRIEK";
		intro = "It starts like a whisper, but ends in a soul-rending shriek.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 3)
		{
			result = "You resist the sound. You gain Sanity.";
			player.getCharacter().incrementSanity();
		}
		else if (roll < 1)
		{
			result = "You lose Sanity and Knowledge";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementSanity();
		}
		else
		{
			result = "You lose Sanity";
			player.getCharacter().decrementSanity();
		}
	}
}
