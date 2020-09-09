package Events;
import actors.Player;
import game.Events;

public class EmptyEvent extends Events{
	
	public EmptyEvent()
	{
	}
	
	public void activate(Player player)
	{
		this.name = "EMPTY";
		this.intro = "Nothing Happens";
		//Get result ready
		this.result = "You continue your journey";
	}
}
