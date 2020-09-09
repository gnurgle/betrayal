package Omens;

import actors.Player;
import game.Omens;

public class Spear extends Omens{

	public Spear()
	{
	}
	
	public void activate(Player player)
	{
		name = "SPEAR";
		intro = "A weapon pulsing with power.";
		result = "You gain Might";
		setUseable(false);
		
		player.getCharacter().incrementMight();
		player.getCharacter().incrementMight();
		
	}
}
