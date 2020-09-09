/*
 * 
 * Abstract class for Items
 * 
 */
package game;

import actors.Player;


public abstract class Items {

	protected String name;
	protected String intro;
	protected String result;
	protected String effects;
	protected boolean useable;
	protected boolean used;
	protected boolean discardOnUse;
	protected boolean weapon;
	
	
	
	public Items()
	{
	}
	
	public void activate(Player player)
	{
	}
	
	public void use(Player player)
	{
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return effects;
	}

	public void setEffect(String effect) {
		this.effects = effect;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
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

	public boolean isDiscardOnUse() {
		return discardOnUse;
	}

	public void setDiscardOnUse(boolean discardOnUse) {
		this.discardOnUse = discardOnUse;
	}

	public boolean isWeapon() {
		return weapon;
	}

	public void setWeapon(boolean weapon) {
		this.weapon = weapon;
	}
	
	
}
