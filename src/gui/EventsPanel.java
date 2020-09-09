/*
 * 
 * Panel that displays to output of the Event
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

import game.Events;
import game.ResourceLoad;

public class EventsPanel extends PopupPanel{

	public JButton btn_event_confirm;
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private ResourceLoad loadstuff = new ResourceLoad();
	
	public EventsPanel(Events events)
	{
		//Initialize
		super();
		this.setSize(icon.getIconWidth(),icon.getIconHeight());
		this.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
		this.setOpaque(false);
		loadstuff.LoadResources();
		
		//Initialize buttons
		btn_event_confirm = new ImageButton("confirm").getButton();
		
		//==draw stuff to panel==
		this.setLayout(gridbag);
		c.weightx=1;
		c.weighty=1;
		c.ipadx = 450;
		c.gridx = 0;
		c.gridy = 0;
		//c.fill = c.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		
		
		//Event Name
		JLabel blank = new JLabel(new ImageIcon(getClass().getResource("/res/objects/blank_600.png")));
		blank.setOpaque(false);
		
		this.add(blank,c);
		c.gridy++;
		
		JLabel name = new JLabel(events.getName(), SwingConstants.CENTER);
		name.setFont(new Font("Letter Gothic", Font.BOLD, 38));
		name.setForeground(Color.WHITE);
		
		this.add(name, c);
		c.gridy++;
		
		//Event Intro
		JLabel intro = new JLabel();
		intro.setFont(new Font("Letter Gothic", Font.BOLD, 22));
		intro.setForeground(Color.WHITE);
		intro.setText("<html><div style='text-align: center;'>" + events.getIntro() + "</div></html>");
		intro.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(intro, c);
		c.gridy++;
		
		c.anchor = GridBagConstraints.CENTER;
		
		//Event Outcome
		JLabel result = new JLabel();
		result.setFont(new Font("Letter Gothic", Font.PLAIN, 21));
		result.setForeground(Color.WHITE);
		result.setText("<html><div style='text-align: center;'>" + events.getResult() + "</div></html>");
		result.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(result, c);
		c.gridy++;
		
		//Event Confirm button
		c.ipady = 30;
		this.add(btn_event_confirm, c);
	}
}
