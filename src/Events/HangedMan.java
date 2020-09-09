/*Roll for each trait, 2+ unaffected, 0-1 Lose 1 from trait
 * 
 * 
 */
package Events;

import actors.Player;
import game.Events;

public class HangedMan extends Events {

	public HangedMan()
	{
	}
	
	public void activate(Player player)
	{
		name = "HANGED MAN";
		intro = "A breeze chills the room. Before you three men hang from frayed ropes. They stare at you with cold, dead eyes. The trio swing silently, then fade into dust that falls to the ground. You start to choke.";
		//Get result ready
		result = "";
		
		boolean lostTrait = false;
		
		//Roll dice vs each trait
		if (player.getCharacter().traitRoll(player.getCharacter().getMight()) < 2)
		{
			player.getCharacter().decrementMight();
			lostTrait = true;
			result = result +"You lose Might.\n";
		}
		if (player.getCharacter().traitRoll(player.getCharacter().getSpeed()) < 2)
		{
			player.getCharacter().decrementSpeed();
			lostTrait = true;
			result = result +"You lose Speed.\n";
		}
		if (player.getCharacter().traitRoll(player.getCharacter().getSanity()) < 2)
		{
			player.getCharacter().decrementSanity();
			lostTrait = true;
			result = result +"You lose Sanity.\n";
		}
		if (player.getCharacter().traitRoll(player.getCharacter().getKnowledge()) < 2)
		{
			player.getCharacter().decrementKnowledge();
			lostTrait = true;
			result = result +"You lose Knowledge.\n";
		}
		
		if (!lostTrait)
		{
			result = "The sight doesn't phase you. You gain Sanity";
			player.getCharacter().incrementSanity();
		}
		
	}
}
