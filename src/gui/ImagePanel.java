//This helper class initializes a panel buttons with a default,
//background image.
package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class ImagePanel extends JPanel
{
	
	private int width;
	private int height;
	private ImageIcon icon;
		
		
	public ImagePanel(ImageIcon icon)
	{
		//This definitions
		this.icon = icon;	
		this.width = icon.getIconWidth();
		this.height = icon.getIconHeight();
		this.setPreferredSize(new Dimension(width,height));
		setOpaque(false);
	}
		


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
	public ImageIcon getImageIcon() {
		return icon;
	}



	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(icon.getImage(), 0, 0, null);
	}
}

