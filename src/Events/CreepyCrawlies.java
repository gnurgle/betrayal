package Events;
import actors.Player;
import game.Events;

public class CreepyCrawlies extends Events{
	
	public CreepyCrawlies()
	{
	}
	
	public void activate(Player player)
	{
		name = "CREEPY CRAWLIES";
		intro = "A thousand bugs spill out on your skin, under your clothes, and in your hair.";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(player.getCharacter().getSanity());
		if (roll > 5)
		{
			result = "You blink, and they're gone. You gain Sanity";
			player.getCharacter().incrementSanity();
		}
		else if (roll < 2)
		{
			result = "You lose Sanity";
			player.getCharacter().decrementSanity();
			player.getCharacter().decrementSanity();
		}
		else
		{
			result = "You lose Sanity.";
			player.getCharacter().decrementSanity();
		}
	}
}
