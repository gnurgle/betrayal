package Omens;

import actors.Player;
import game.Omens;

public class Girl extends Omens{

	public Girl()
	{
	}
	
	public void activate(Player player)
	{
		name = "GIRL";
		intro = "A girl. Trapped. Alone. You free her!";
		result = "You gain Sanity and Knowledge";
		setUseable(false);
		
		player.getCharacter().incrementKnowledge();
		player.getCharacter().incrementSanity();
		
	}
}
