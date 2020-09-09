/**
 * 
 * Fills in the panel with provided information
 * 
 */
package launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.ResourceLoad;

public class CharGuiPanel extends JPanel{

	private ResourceLoad loadstuff = new ResourceLoad();
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	
	public CharGuiPanel(ImageIcon icon, String name, int age, String height, int weight, String hobbies, String birth, String story)
	{
		loadstuff.LoadResources();
		this.setLayout(gridbag);
		this.setOpaque(false);
		this.setSize(1000, 1000);
		this.setPreferredSize(new Dimension(1000, 1000));
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = .8;
		c.weighty = 0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady = 20;
		c.gridwidth=GridBagConstraints.RELATIVE;
		c.gridx = 1;
		add(textbox(name, 32), c);
		
		c.gridy = 1;
		add(textbox("Age: " + age, 26), c);
		
		c.gridy = 2;
		add(textbox("Height: " + height, 26), c);
		
		c.gridy = 3;
		add(textbox("Weight: " + weight + " lbs", 26), c);
		
		c.gridy = 4;
		add(textbox("Hobbies: " + hobbies, 26), c);
		
		c.gridy = 5;
		add(textbox("Birthday: " + birth, 26), c);
		
		c.gridy = 6;
		c.gridx = 1;
		
		add(textbox(story, 26), c);
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor=GridBagConstraints.LINE_END;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=6;
		JLabel iconlbl = new JLabel(icon);
		this.add(iconlbl,c);
		
		
	}
	
	//generic textbox class
	private JLabel textbox(String str, int size) 
	{
		JLabel text = new JLabel();
		text.setFont(new Font("Letter Gothic", Font.PLAIN, size));
		text.setForeground(Color.WHITE);
		text.setText("<html><div style='text-align: left;'>" + str + "</div></html>");
		
		return text;
	}

}
