package Items;

import actors.Player;
import game.Items;

public class Armor extends Items{

	public Armor()
	{
	}
	
	public void activate(Player player)
	{
		name = "ARMOR";
		intro = "It's just prop armor from a Renaissance fair, but it's still metal.";
		result = "You gain Might.";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(false);
		
		player.getCharacter().incrementMight();
		
	}
}
