/**
 * 
 * Panel for displaying Dice results
 * 
 */

package gui;


import game.Dice;
import game.ResourceLoad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class DicePanel extends PopupPanel{

	private Dice dice;		//Dice to roll
	private int num;		//Number of dice
	private int total;	//total of dice rolls
	
	public JButton btn_dice_confirm;
	public JButton btn_diceomen_confirm;
	private boolean haunt = false;
	
	//Font for 
	private ResourceLoad loadstuff = new ResourceLoad();

	public DicePanel(int num)
	{
		super();
		loadstuff.LoadResources();
		this.num = num;
		dice = new Dice();
		//total = rollDice(); 
		GridBagLayout gridbag = new GridBagLayout();
		
		this.setLayout(gridbag);
		GridBagConstraints c = new GridBagConstraints();
		
		
		//Set 
		c.gridx=8;
		
		c.weighty = 20;
		c.weightx = 0;
		
		c.fill=GridBagConstraints.NONE;
	
		c.gridy=2;
		for(int i = 0; i < 8; i++)
		{	
			c.gridx =  i+1;
			this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/blank_64.png"))),c);
		}
		
		c.gridy=3;
		
		total = 0;
		int val;
		for(int i = 0; i < 6; i++)
		{	
			val=dice.roll();
			total+=val;
			c.gridx = i+2;
			if(i == 0)
			{
				c.gridx = i+1;
				this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/block.png"))),c);
				c.gridx = i+2;
			}
			this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/dice"+val+".png"))),c);
		}
		
		c.gridx =0;
		c.gridy =0;
		c.gridwidth=GridBagConstraints.REMAINDER;
		
		JLabel text = new JLabel();
		text.setFont(new Font("Letter Gothic", Font.BOLD, 30));
		text.setForeground(Color.WHITE);
		String rolled = "You feel an uneasiness in the air.";
		text.setText("<html><div style='text-align: center;'>" + rolled + "</div></html>");
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		//this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/dice"+1+".png"))),BorderLayout.CENTER);
		this.add(text,c);
		
		c.gridy =4;
		c.gridwidth=GridBagConstraints.REMAINDER;
		
		JLabel text2 = new JLabel();
		text2.setFont(new Font("Letter Gothic", Font.BOLD, 24));
		text2.setForeground(Color.WHITE);
		String outcome = "";
		if (total < num)
		{
			outcome = "Your fears are justified. The Haunt begins.";
			haunt = true;
		}
		else
			outcome = "You feel safe. For now.";
		
		text2.setText("<html><div style='text-align: center;'>" + outcome + "</div></html>");
		text2.setHorizontalAlignment(JLabel.CENTER);
		text2.setVerticalAlignment(JLabel.CENTER);
		//this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/dice"+1+".png"))),BorderLayout.CENTER);
		this.add(text2,c);
		c.gridx =1;
		c.gridy =5;
		
		btn_dice_confirm = new ImageButton("confirm").getButton(); 
		btn_diceomen_confirm = new ImageButton("confirm").getButton();
		
		if (haunt)
			this.add(btn_diceomen_confirm, c);
		else
			this.add(btn_dice_confirm,c);
	
		
	}
	
	public int rollDice()
	{
		total = 0;
		int val;
		for(int i = 0; i < num; i++)
		{	
			val=dice.roll();
			total+=val;
			this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/dice"+val+".png"))),BorderLayout.CENTER);
		}
		return total;
	}
	public int getNum()
	{
		return num;
	}
	
	public int getTotal()
	{
		return total;
	}
}
