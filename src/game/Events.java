/**
 * 
 * Abstract class for Events
 * 
 */

package game;

import javax.swing.JPanel;

import actors.Player;

public abstract class Events {

	protected String name;
	protected String intro;
	protected String result;
	protected JPanel panel;
	
	
	public Events()
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
	
	
}
