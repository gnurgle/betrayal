package Omens;

import actors.Player;
import game.Omens;

public class Medallion extends Omens{

	public Medallion()
	{
	}
	
	public void activate(Player player)
	{
		name = "MEDALLION";
		intro = "A medallion inscribed with a pentagram";
		result = "You are immune to the effects of the Pentagram Chamber, Crypt, and Graveyard";
		setUseable(false);
		
		player.setHasAmulet(true);
	}
}
