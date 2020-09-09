package Events;
import actors.Player;
import game.Events;

public class Debris extends Events{
	
	public Debris()
	{
	}
	
	public void activate(Player player)
	{
		name = "DEBRIS";
		intro = "Plaster falls from the walls and ceiling.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSpeed());
		if (roll > 2)
		{
			result = "You dodge the plaster. You gain Speed";
			player.getCharacter().incrementSpeed();
		}
		else if (roll == 0)
		{
			result = "You lose Might and Speed";
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSpeed();
		}
		else
		{
			result = "You Lose Speed";
			player.getCharacter().decrementSpeed();
		}
	}
}
