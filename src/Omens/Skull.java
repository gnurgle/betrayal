package Omens;

import actors.Player;
import game.Omens;

public class Skull extends Omens{

	public Skull()
	{
	}
	
	public void activate(Player player)
	{
		name = "SKULL";
		intro = "A skull, cracked and missing teeth";
		result = "You gain Might, but lose Sanity";
		setUseable(false);
		
		player.getCharacter().incrementMight();
		player.getCharacter().decrementSanity();
		
	}
}
