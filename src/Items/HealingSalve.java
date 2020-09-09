package Items;

import actors.Player;
import game.Items;

public class HealingSalve extends Items{

	public HealingSalve()
	{
	}
	
	public void activate(Player player)
	{
		name = "HEALING SALVE";
		intro = "A sticky paste in a shallow bowl";
		result = "You gain Might and Speed";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(true);
		
		player.getCharacter().incrementMight();
		player.getCharacter().incrementSpeed();
		
	}
}
