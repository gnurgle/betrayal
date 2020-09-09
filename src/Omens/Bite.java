package Omens;

import actors.Player;
import game.Omens;

public class Bite extends Omens{

	public Bite()
	{
	}
	
	public void activate(Player player)
	{
		name = "BITE";
		intro = "A growl, the scent of death. Pain. Darkness. Gone.";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getMight());
		int attack = player.getCharacter().traitRoll(4);
		int counter = attack - roll;
		
		result = "Something appears from the corner and bites you. ";
		
		if (counter >= 0)
			result = result + "Fortunately it seems to only have grazed the skin.";
		else
		{
			result = "You feel teeth sink into you. You lose " + (attack-roll) + " Might.";
			for (int i = 0; i < (attack-roll); ++i)
			{
				player.getCharacter().decrementMight();
			}
		}
		
		setUseable(false);

		
	}
}
