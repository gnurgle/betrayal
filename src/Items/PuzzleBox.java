package Items;

import actors.Player;
import game.Items;

public class PuzzleBox extends Items{

	public PuzzleBox()
	{
	}
	
	public void activate(Player player)
	{
		name = "PUZZLE BOX";
		intro = "There must be a way to open it";
		result = "Once during your turn you can attempt to open the box.";
		use(player);
		result = effects;
		setUseable(true);
		setDiscardOnUse(false);
		setWeapon(false);

		
	}
	
	public void use (Player player)
	{
		int roll = player.getCharacter().traitRoll(player.getCharacter().getKnowledge());
		if (roll > 5)
		{
			effects = "You manage to get it open. I gain 1 Knowledge and 1 Sanity.";
			player.getCharacter().incrementKnowledge();
			player.getCharacter().incrementSanity();
			setDiscardOnUse(true);
		}
		else
			effects = "You just can't get it open.";
	}
}
