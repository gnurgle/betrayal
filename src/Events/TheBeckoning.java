package Events;
import actors.Player;
import game.Events;

public class TheBeckoning extends Events{
	

	public TheBeckoning()
	{
	}
	
	public void activate(Player player)
	{
		name = "THE BECKONING";
		intro = "Outside. You must get outside. Fly to freedom!";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 2)
		{
			result = "You manage to calm yourself";
		
		}
		else
		{
			result = "You slam into the walls trying to escape. You lose Might";
			player.getCharacter().decrementMight();
		}
	}
}
