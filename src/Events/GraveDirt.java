package Events;
import actors.Player;
import game.Events;

public class GraveDirt extends Events{
	
	public GraveDirt()
	{
	}
	
	public void activate(Player player)
	{
		name = "GRAVE DIRT";
		intro = "This room is covered in a thick layer of dirt. You cough as it gets on your skin and in your lungs.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getMight());
		if (roll > 4)
		{
			result = "You shake it off. You gain Might";
			player.getCharacter().incrementMight();
		}
		else
		{
			result = "Soemthing is wrong. You Lose Might and Speed";
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSpeed();
		}
	}
}
