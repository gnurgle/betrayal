/**Speed roll. 4+ gain 1 speed. 1-3 lose 1 might. 0 lose 1 might and speed
 * 
 * 
 */ 
package Events;
import actors.Player;
import game.Events;

public class NightView extends Events{

	public NightView()
	{
	}
	
	public void activate(Player player)
	{
		name = "NIGHT VIEW";
		intro = "You see a vision of a ghostly couple walking the grounds, silently strolling in their wedding best.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getKnowledge());
		if (roll > 4)
		{
			result = "You recognize the ghosts as former inhabitants of the house. You call their names, and they turn to you, whispering dark secrets of the house. You gain Knowledge";
			player.getCharacter().incrementKnowledge();
		}
		else
		{
			result = "You pull back in horror, unable to watch";
		}
	}
}
