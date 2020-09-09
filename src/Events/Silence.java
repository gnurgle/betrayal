package Events;
import actors.Player;
import game.Events;

public class Silence extends Events{

	public Silence()
	{
	}
	
	public void activate(Player player)
	{
		name = "SILENCE";
		intro = "Everything goes silent. Even the sound of breathing is gone.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 4)
		{
			result = "You wait calmly for your hearing to return.";
		}
		else if (roll == 0)
		{
			result = "You freak out. You lose Sanity and Knowledge";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementSanity();
		}
		else
		{
			result = "You scream a silent scream. You lose Sanity";
			player.getCharacter().decrementSanity();
		}
	}
}
