package Events;
import actors.Player;
import game.Events;

public class AngryBeing extends Events{
	
	public AngryBeing()
	{
	}
	
	public void activate(Player player)
	{
		name = "ANGRY BEING";
		intro = "It emerges from the slime on the wall next to you.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSpeed());
		if (roll > 4)
		{
			result = "You get away. You gain Speed";
			player.getCharacter().incrementSpeed();
		}
		else if (roll < 2)
		{
			result = "You lose Knowledge and Speed";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementSpeed();
		}
		else
		{
			result = "You Lose Knowledge";
			player.getCharacter().decrementKnowledge();
		}
	}
}
