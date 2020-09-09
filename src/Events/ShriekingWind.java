package Events;
import actors.Player;
import game.Events;

public class ShriekingWind extends Events{
	
	public ShriekingWind()
	{
	}
	
	public void activate(Player player)
	{
		name = "SHRIEKING WIND";
		intro = "It emerges from the slime on the wall next to you.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getMight());
		if (roll > 4)
		{
			result = "You keep your footing.";
		}
		else if (roll == 0)
		{
			result = "The wind knocks you down hard. You lose Speed and Might";
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSpeed();
		}
		else if (roll < 3)
		{
			result = "The wind chills your soul. You lose Sanity";
			player.getCharacter().decrementSanity();
		}
		else
		{
			result = "The wind knocks you down. You lose Speed";
			player.getCharacter().decrementSpeed();
		}
	}
}
