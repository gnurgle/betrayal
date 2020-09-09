package Omens;

import actors.Player;
import game.Omens;

public class Madman extends Omens{

	public Madman()
	{
	}
	
	public void activate(Player player)
	{
		name = "MADMAN";
		intro = "A raving, frothing madman. He starts to follow you at a distance";
		result = "You gain Might, but lose Sanity";
		setUseable(false);
		
		player.getCharacter().incrementMight();
		player.getCharacter().incrementMight();
		player.getCharacter().decrementSanity();
		
	}
}
