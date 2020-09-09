/*
 * 
 * Darws Panel that displays PlayerStats
 * 
 */

package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import actors.Characters;
import game.ResourceLoad;

public class PlayerStatsPanel extends JPanel{

	ImageIcon icon = new ImageIcon(getClass().getResource("/res/gui/playerslot.png"));
	Characters player;
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private ResourceLoad loadstuff = new ResourceLoad();
	
	
	PlayerStatsPanel(Characters player)
	{
		this.player = player;
		
		loadstuff.LoadResources();
		this.setLayout(gridbag);
		this.setOpaque(false);
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
		this.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		
		if(!player.getfName().contentEquals("Blank"))
		{
		c.gridx = 0;
		
		
		c.gridy=0;
		this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/blank_150.png"))));
		c.gridx = 1;
		//this.add(new JLabel(new ImageIcon(getClass().getResource("/res/objects/blank_150.png"))));
		c.gridx=0;
		
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridy = 1;
		c.ipady = 30;
		this.add(textbox(player.getfName() + " " + player.getlName(), 26),c);
		c.ipady = 0;
		c.gridwidth=GridBagConstraints.RELATIVE;
		
		c.gridy = 2;
		this.add(textbox("Age:  " + player.getAge(), 14),c);
		
		
		c.gridx = 1;
		this.add(textbox("Height:  " + inchesToFeet(player.getHeight()), 14),c);
		
		c.gridy = 3;
		this.add(textbox("Birthday:  " + player.getbDay(), 14),c);
		
		c.gridx = 0;
		this.add(textbox("Weight:  " + player.getWeight() + "lbs", 14),c);
		
		c.gridy = 4;
		this.add(textbox("Hobbies:   ", 14),c);
	
		c.anchor=GridBagConstraints.LINE_END;
		c.gridx = 1;
		this.add(textbox(player.getHobby1(), 14),c);
		
		c.gridy = 5;
		this.add(textbox(player.getHobby2(), 14),c);
		
		c.gridy = 6;
		if (player.getHobby3().equals(""))
		{
			c.ipady = 14;
			this.add(new JLabel(),c);
			c.ipady = 0;
		}
		else
			this.add(textbox(player.getHobby3(), 14),c);
		c.gridy = 7;
		
		c.ipady = 20;
		this.add(new JLabel(),c);
		c.ipady = 0;
		c.gridy = 9;
		
		this.add(textbox("Might:  " + player.getMight(), 22),c);
		c.gridy = 10;
		
		this.add(textbox("Speed:  " + player.getSpeed(), 22),c);
		c.gridy = 11;
		
		this.add(textbox("Sanity:  " + player.getSanity(), 22),c);
		c.gridy = 12;
	
		this.add(textbox("Knowledge:  " + player.getKnowledge(), 22),c);
		c.gridy = 13;
		this.add(textbox("", 22),c);
		c.gridx = 0;
		c.gridy=6;
		c.anchor=GridBagConstraints.LINE_START;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=8;
		
		this.add(new JLabel(player.getImageIcon()),c);
		c.gridwidth=GridBagConstraints.RELATIVE;
		}
	}
	
	private JLabel textbox(String str, int size)
	{
		JLabel text = new JLabel();
		text.setFont(new Font("Letter Gothic", Font.PLAIN, size));
		text.setForeground(Color.WHITE);
		text.setText("<html><div style='text-align: right;'>" + str + "</div></html>");
		
		return text;
	}
	
	//convert inches int to string of ft and inches
	private String inchesToFeet(int num)
	{
		String str = "";
		int feet;
		int inches;
		
		feet = num/12;
		inches = num%12;
		
		str = feet + "\' " + inches +"\"";
		
		return str;
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(icon.getImage(), 800, 240, null);
	        
	}
}
