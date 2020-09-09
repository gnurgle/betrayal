package Items;

import actors.Player;
import game.Items;

public class BloodDagger extends Items{

	public BloodDagger()
	{
	}
	
	public void activate(Player player)
	{
		name = "BLOOD DAGGER";
		intro = "WEAPON. A nasty weapon. Needles and tubes extend from the handle... and plunge right into your veins.";
		result = "You gain Might, but lose Speed and Sanity";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(true);
		
		player.getCharacter().incrementMight();
		player.getCharacter().incrementMight();
		player.getCharacter().decrementSpeed();
		player.getCharacter().decrementSanity();
		
	}
}
