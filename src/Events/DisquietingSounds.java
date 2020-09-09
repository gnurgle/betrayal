package Events;
import actors.Player;
import game.Events;

public class DisquietingSounds extends Events{
	
	public DisquietingSounds()
	{
	}
	
	public void activate(Player player)
	{
		name = "DISQUIETING SOUNDS";
		intro = "A baby's cry, lost and abandoned. A scream. The crack of breaking glass. Then silence.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(6);
		if (roll > 4)
		{
			result = "You gain Sanity";
			player.getCharacter().incrementSanity();
		}
		else
		{
			result = "You Lose Sanity";
			player.getCharacter().decrementSanity();
		}
	}
}
