/**Speed roll. 4+ gain 1 speed. 1-3 lose 1 might. 0 lose 1 might and speed
 * 
 * 
 */ 
package Events;
import actors.Player;
import game.Events;

public class Possesion extends Events{

	public Possesion()
	{
	}
	
	public void activate(Player player)
	{
		name = "POSSESSION";
		intro = "A shadow seperates from the wall. As you stand in shock, the shadow surrounds you and chills you to the core.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getMight());
		if (roll > 4)
		{
			result = "You resist the shadow's corruption, you gain Might";
			player.getCharacter().incrementMight();
		}
		else
		{
			result = "The shadow drains your energy. You lose all your Might.";
			player.getCharacter().setMight(1);
		}
	}
}
