package Items;

import actors.Player;
import game.Items;

public class AmuletOfTheAges extends Items{

	public AmuletOfTheAges()
	{
	}
	
	public void activate(Player player)
	{
		name = "AMULET OF THE AGES";
		intro = "Ancient silver and inlaid gems, inscribed with blessings";
		result = "You gain Might, Speed, Knowledge, and Sanity";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(false);
		
		player.getCharacter().incrementMight();
		player.getCharacter().incrementSanity();
		player.getCharacter().incrementKnowledge();
		player.getCharacter().incrementSpeed();
		
		
	}
}
