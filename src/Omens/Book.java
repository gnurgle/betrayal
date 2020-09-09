package Omens;

import actors.Player;
import game.Omens;

public class Book extends Omens{

	public Book()
	{
	}
	
	public void activate(Player player)
	{
		name = "BOOK";
		intro = "A diary or labnotes? Ancient script or modern ravings?";
		result = "You gain 2 Knowledge";
		setUseable(false);
		
		player.getCharacter().incrementKnowledge();
		player.getCharacter().incrementKnowledge();
		
	}
}
