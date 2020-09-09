package Omens;

import actors.Player;
import game.Omens;

public class Dog extends Omens{

	public Dog()
	{
	}
	
	public void activate(Player player)
	{
		name = "DOG";
		intro = "This mangy dog seems friendly. At least you hope it is.";
		result = "You gain 1 Might and 1 Sanity";
		setUseable(false);
		
		player.getCharacter().incrementMight();
		player.getCharacter().incrementSanity();
		
	}
}
