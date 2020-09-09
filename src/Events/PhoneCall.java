package Events;
import actors.Player;
import game.Events;

public class PhoneCall extends Events{

	public PhoneCall()
	{
	}
	
	public void activate(Player player)
	{
		name = "PHONE CALL";
		intro = "A phone rings in the room. You feel compelled to answer it. A sweet granny voice says:";
		//Get result ready
		result = "";
		
		int roll = player.getCharacter().traitRoll(2);
		if (roll > 3)
		{
			result = "\"Tea and cakes! Tea and cakes! You were always my favorite!\" You gain Sanity.";
			player.getCharacter().incrementSanity();
		}
		else if (roll == 3)
		{
			result = "\"I'm always here for you Pattycakes. Watching... You\" You gain Knowledge.";
			player.getCharacter().incrementKnowledge();
		}
		else if (roll == 0)
		{
			result = "\"Bad little children must be punished!\" You lose Might and Speed.";
			player.getCharacter().decrementSpeed();
			player.getCharacter().decrementMight();
		}
		else
		{
			result = "\" I'm here, Sweetums! Give us a kiss!\" You lose Sanity.";
			player.getCharacter().decrementSanity();
		}
	}
}
