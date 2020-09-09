package Omens;

import actors.Player;
import game.Omens;

public class Mask extends Omens{

	public Mask()
	{
	}
	
	public void activate(Player player)
	{
		name = "MASK";
		intro = "A somber mask to hide your intentions";
		
		int roll = player.getCharacter().traitRoll(1);
		
		if (roll == 0)
		{
			result = "You gain Knowledge but lose Sanity";
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementSanity();
			player.getCharacter().incrementKnowledge();
			player.getCharacter().incrementKnowledge();
		}
		else
		{
			result = "You gain Sanity but lose Knowledge";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementKnowledge();
			player.getCharacter().incrementSanity();
			player.getCharacter().incrementSanity();
		}
		
		setUseable(false);
		
		player.getCharacter().incrementKnowledge();
		player.getCharacter().incrementKnowledge();
		
	}
}
