/*
 * 
 * Basic JPanel with popup background drawn.
 * 
 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;



public class PopupPanel extends JPanel{

	protected ImageIcon icon = new ImageIcon(getClass().getResource("/res/gui/popup.png"));
	
	public PopupPanel()
	{
		//super();
		this.setSize(620,310);
		this.setPreferredSize(new Dimension(620,310));
		
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(icon.getImage(), 0, 0, null);
	}
	
}
