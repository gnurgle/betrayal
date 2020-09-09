package Omens;

import actors.Player;
import game.Omens;

public class EmptyOmen extends Omens{

	public EmptyOmen()
	{
	}
	
	public void activate(Player player)
	{
		name = "EMPTY";
		intro = "There's nothing there";		
		result = "That's pretty spook bruh. ";
		
		setUseable(false);

		
	}
}
