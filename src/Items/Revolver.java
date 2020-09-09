package Items;

import actors.Player;
import game.Items;

public class Revolver extends Items{

	public Revolver()
	{
	}
	
	public void activate(Player player)
	{
		name = "REVOLVER";
		intro = "WEAPON. An old, potent looking weapon.";
		result = "You use your Speed to attack instead of your Might. Your Speed Increases";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(true);

		player.getCharacter().incrementSpeed();
	}
}
