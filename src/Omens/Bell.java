package Omens;

import actors.Player;
import game.Omens;

public class Bell extends Omens{

	public Bell()
	{
	}
	
	public void activate(Player player)
	{
		name = "BELL";
		intro = "A brass bell that makes a resonant clang.";
		result = "You gain Sanity.";
		setUseable(false);
		
		player.getCharacter().incrementSanity();
		
		
	}
}
