package Items;

import actors.Player;
import game.Items;

public class Axe extends Items{

	public Axe()
	{
	}
	
	public void activate(Player player)
	{
		name = "AXE";
		intro = "WEAPON. Very sharp.";
		result = "You gain Might with this weapon";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(true);
		
		player.getCharacter().incrementMight();

		
	}
}
