/**Manages two players attacking each other
 * 
 * 
 */

package game;

import actors.Player;

public class Attack {
	
	private String outcome = "";
	
	public Attack() {}
	
	public String playerattack(Player player1, Player player2)
	{
		int diff = 0;		//Difrerence between rolls
		int win = 0;		//Win type
		
		//roll for damages
		if (player1.isHasRevlover() || player2.isHasRevlover())
		{
			diff = player1.getCharacter().traitRoll(player1.getCharacter().getSpeed()) - player2.getCharacter().traitRoll(player2.getCharacter().getSpeed());
			win = 1;
			if (diff < 0)
			{
				win = 2;
				diff = player2.getCharacter().traitRoll(player2.getCharacter().getSpeed()) - player1.getCharacter().traitRoll(player1.getCharacter().getSpeed());
			}
		}
		else
		{
			diff = player1.getCharacter().traitRoll(player1.getCharacter().getMight()) - player2.getCharacter().traitRoll(player2.getCharacter().getMight());
			win = 1;
			if (diff < 0)
			{
				diff *= -1;
				win = 2;
			}
		}
		
		//Subtract Might and Speed alternating depending on who one the roll and by how much
		if (diff == 0)
		{
			outcome = "Both of you manage to stay unscathed";
			SoundEffect.CLICK.play();
			win = 0;
		}
		else
		{
			if (win == 1)
			{
				for (int i = 0; i < diff; ++i)
				{
					if (player2.getCharacter().getMightStat() > player2.getCharacter().getSpeedStat())
						player2.getCharacter().decrementMight();
					else
						player2.getCharacter().decrementSpeed();
				}
				outcome = player1.getCharacter().getfName() + "'s attack managed to connect and injure " + player2.getCharacter().getfName();
				SoundEffect.PUNCH.play();
		
			}
			else if (win == 2)
			{
				for (int i = 0; i < diff; ++i)	
				{
					if (player1.getCharacter().getMightStat() > player1.getCharacter().getSpeedStat())
						player1.getCharacter().decrementMight();
					else
						player1.getCharacter().decrementSpeed();
				}
				outcome = player2.getCharacter().getfName() + " deflected the attack and injured " + player1.getCharacter().getfName();
				SoundEffect.PUNCH.play();
			}
		}
		
	return outcome;
	}
}
