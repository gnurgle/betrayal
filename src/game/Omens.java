/**
 * 
 * Abstract class for Omens
 * 
 */

package game;

import actors.Player;

public abstract class Omens {

	protected String name;
	protected String intro;
	protected String result;
	protected boolean useable;
	
	
	
	public Omens()
	{
	}
	
	public void activate(Player player)
	{
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isUseable() {
		return useable;
	}

	public void setUseable(boolean useable) {
		this.useable = useable;
	}
	
	
}
