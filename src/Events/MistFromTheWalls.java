package Events;
import actors.Player;
import game.Events;

public class MistFromTheWalls extends Events{

	public MistFromTheWalls()
	{
	}
	
	public void activate(Player player)
	{
		name = "MIST FROM THE WALLS";
		intro = "Mists pour out from the walls. There are faces in the mist, human and ... inhuman";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 3)
		{
			result = "The faces are tricks of light and shadow. All is well.";
		}
		else if (roll == 0)
		{
			result = "You lose Knowledge and Sanity";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementSanity();
		}
		else
		{
			result = "You lose Knowledge and Sanity";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementSanity();
		}
	}
}
