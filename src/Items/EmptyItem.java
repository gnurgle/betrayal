package Items;

import actors.Player;
import game.Items;

public class EmptyItem extends Items{

	public EmptyItem()
	{
	}
	
	public void activate(Player player)
	{
		name = "EMPTY";
		intro = "It's nothing";
		result = "And yet, that makes you feel at ease";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(false);
		
		player.getCharacter().incrementSanity();

		
		
	}
}
