/**
 * 
 * Generic Text Popup
 * 
 */

package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import game.ResourceLoad;

public class TextPop extends PopupPanel{

	public JButton btn_text_confirm;
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	
	private ResourceLoad loadstuff = new ResourceLoad();
	
	public TextPop(String input)
	{
		//Initialize
		super();
		this.setSize(icon.getIconWidth(),icon.getIconHeight());
		this.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
		this.setOpaque(false);
		loadstuff.LoadResources();
		
		//Initialize buttons
		btn_text_confirm = new ImageButton("confirm").getButton();
		
		//==draw stuff to panel==
		this.setLayout(gridbag);
		c.weightx=1;
		c.weighty=1;
		c.ipadx = 450;
		c.gridx = 0;
		c.gridy = 0;
		//c.fill = c.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		
		
		//Omen Name
		JLabel blank = new JLabel(new ImageIcon(getClass().getResource("/res/objects/blank_600.png")));
		blank.setOpaque(false);
		
		this.add(blank,c);
		c.gridy++;
		
		
		//Omen Intro
		JLabel intro = new JLabel();
		intro.setFont(new Font("Letter Gothic", Font.PLAIN, 26));
		intro.setForeground(Color.WHITE);
		intro.setText("<html><div style='text-align: center;'>" + input + "</div></html>");
		intro.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(intro, c);
		c.gridy++;
		
		c.anchor = GridBagConstraints.BELOW_BASELINE;
		
		
		//Omen Confirm button
		c.ipady = 50;
		this.add(btn_text_confirm, c);
	}
}
