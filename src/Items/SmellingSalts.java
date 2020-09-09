package Items;

import actors.Player;
import game.Items;

public class SmellingSalts extends Items{

	public SmellingSalts()
	{
	}
	
	public void activate(Player player)
	{
		name = "SMELLING SALTS";
		intro = "Whew, that's a lungful";
		result = "You gain Knowledge and Sanity";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(false);

		player.getCharacter().incrementKnowledge();
		player.getCharacter().incrementSanity();
		
	}
}
