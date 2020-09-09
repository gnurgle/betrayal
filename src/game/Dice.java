/*
 * 
 * Method for randomly rolling dice. 
 * Each player has their own "set" of dice
 */

package game;

import java.util.Random;
import javax.swing.ImageIcon;


public class Dice {

	private int roll;
	private ImageIcon icon;
	private Random random;
	
	public Dice()
	{
		//seed random
		random = new Random();
		//Generate starting results
		this.roll();
	}
	
	//Roll a dice and set image to dice face
	public int roll()
	{
		roll = random.nextInt(3);
		icon = new ImageIcon(getClass().getResource("/res/objects/dice" + roll + ".png"));
		return roll;
	}
	
	//Get image of dice face
	public ImageIcon getIcon()
	{
		return icon;
	}
	
}
