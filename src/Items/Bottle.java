package Items;

import actors.Player;
import game.Items;

public class Bottle extends Items{

	public Bottle()
	{
	}
	
	public void activate(Player player)
	{
		name = "BOTTLE";
		intro = "An opaque vial containing a black liquid";
		result = "Once per turn after the haunt, you can take a drink from the bottle";
		use (player);
		result = effects;
		setUseable(true);
		setDiscardOnUse(true);
		setWeapon(false);
	}
	
	public void use(Player player)
	{
		int roll = player.getCharacter().traitRoll(3);
		switch (roll)
		{
		case 0:
			effects = "Lose 2 in every trait";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementSpeed();
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementSpeed();
			break;
		case 1:
			effects = "Lose 2 Might and 2 Speed.";
			player.getCharacter().decrementMight();
			player.getCharacter().decrementMight();
			player.getCharacter().decrementSpeed();
			player.getCharacter().decrementSpeed();
			break;
		case 2:
			effects = "Lose 2 Knowledge and 2 Sanity";
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementKnowledge();
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementSanity();
			break;
		case 3:
			effects = "Gain 1 Knowledge and lose 1 Might";
			player.getCharacter().incrementKnowledge();
			player.getCharacter().decrementMight();
			break;
		case 4:
			effects = "Gain 2 Knowledge and 2 Sanity";
			player.getCharacter().incrementKnowledge();
			player.getCharacter().incrementKnowledge();
			player.getCharacter().incrementSanity();
			player.getCharacter().incrementSanity();
			break;
		case 5:
			effects = "Gain 2 Might and 2 Speed";
			player.getCharacter().incrementMight();
			player.getCharacter().incrementMight();
			player.getCharacter().incrementSpeed();
			player.getCharacter().incrementSpeed();
			break;
		case 6:
			effects = "Gain 2 in every stat.";
			player.getCharacter().incrementKnowledge();
			player.getCharacter().incrementKnowledge();
			player.getCharacter().incrementSanity();
			player.getCharacter().incrementSanity();
			player.getCharacter().incrementMight();
			player.getCharacter().incrementMight();
			player.getCharacter().incrementSpeed();
			player.getCharacter().incrementSpeed();
			break;
		default:
			effects = "Nothing happens";
			break;
		}
	}
}
