/**Speed roll. 4+ gain 1 speed. 1-3 lose 1 might. 0 lose 1 might and speed
 * 
 * 
 */ 
package Events;
import actors.Player;
import game.Events;

public class SomethingSlimy extends Events{

	public SomethingSlimy()
	{

	}
	
	public void activate(Player player)
	{
		name = "SOEMTHING SLIMY";
		intro = "What's that around your ankle? A bug? A tentacle? A dead hand crawling?";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSpeed());
		if (roll > 3)
		{
			result = "You break free. Gain Speed";
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
			result = "You lost Might";
			player.getCharacter().decrementMight();
		}
	}
	

}
