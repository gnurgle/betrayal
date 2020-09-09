package Omens;

import actors.Player;
import game.Omens;

public class HolySymbol extends Omens{

	public HolySymbol()
	{
	}
	
	public void activate(Player player)
	{
		name = "HOLY SYMBOL";
		intro = "A symbol of calm in an unsettling world";
		result = "You gain Sanity";
		setUseable(false);
		
		player.getCharacter().getSanity();
		player.getCharacter().getSanity();
		
	}
}
