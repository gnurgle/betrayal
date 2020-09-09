package Items;

import actors.Player;
import game.Items;

public class LuckyStone extends Items{

	public LuckyStone()
	{
	}
	
	public void activate(Player player)
	{
		name = "LUCKY STONE";
		intro = "A smooth, ordinary-looking rock, you sense it will bring you good fortune.";
		result = "You gain in each stat.";
		
		setUseable(false);
		setDiscardOnUse(false);
		setWeapon(false);

		player.getCharacter().incrementKnowledge();
		player.getCharacter().incrementMight();
		player.getCharacter().incrementSanity();
		player.getCharacter().incrementSpeed();
	}
}
