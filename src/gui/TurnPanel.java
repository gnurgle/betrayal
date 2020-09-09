package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import game.Omens;
import game.ResourceLoad;

public class TurnPanel extends PopupPanel{

	public JButton btn_turn_confirm;
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	
	private ResourceLoad loadstuff = new ResourceLoad();
	
	public TurnPanel(String str)
	{
		//Initalize
		super();
		this.setSize(icon.getIconWidth(),icon.getIconHeight());
		this.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
		this.setOpaque(false);
		loadstuff.LoadResources();
		
		//Initialize buttons
		btn_turn_confirm = new ImageButton("confirm").getButton();
		
		//==draw stuff to panel==
		this.setLayout(gridbag);
		c.weightx=1;
		c.weighty=1;
		c.ipadx = 450;
		c.gridx = 0;
		c.gridy = 0;
		//c.fill = c.BOTH;
		c.anchor = c.CENTER;
		
		
		//Player turn name
		JLabel blank = new JLabel(new ImageIcon(getClass().getResource("/res/objects/blank_600.png")));
		blank.setOpaque(false);
		
		this.add(blank,c);
		c.gridy++;
		
		JLabel name = new JLabel((str + "'s Turn."), SwingConstants.CENTER);
		name.setFont(new Font("Letter Gothic", Font.BOLD, 50));
		name.setForeground(Color.WHITE);
		
		this.add(name, c);
		c.gridy++;
		
		//Omen Confirm button
		c.ipady = 30;
		this.add(btn_turn_confirm, c);
	}
}
