package Omens;

import actors.Player;
import game.Omens;

public class Idol extends Omens{

	public Idol()
	{
	}
	
	public void activate(Player player)
	{
		name = "IDOL";
		intro = "Perhaps it's chose you for some greater purpose. Like human sacrifice";
		result = "You gain Might and Speed, but you lose Sanity";
		setUseable(false);
		
		player.getCharacter().incrementMight();
		player.getCharacter().incrementSpeed();
		player.getCharacter().decrementSanity();
		
	}
}
