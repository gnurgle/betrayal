//This helper class initializes image buttons with a default,
//hover, and press image. Also removes the bounding box of the
//JButton. 
package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton{
	
	private JButton button;
	private int width;
	private int height;
	private ImageIcon btn_default;
	private ImageIcon btn_press;
	private ImageIcon btn_hover;
	
	public ImageButton(String name)
	{
		//Image Icon declarations
		btn_default = new ImageIcon(getClass().getResource("/res/gui/button/btn_" + name +"_default.png"));
		btn_press = new ImageIcon(getClass().getResource("/res/gui/button/btn_" + name + "_press.png"));
		btn_hover = new ImageIcon(getClass().getResource("/res/gui/button/btn_" + name + "_hover.png"));
		
		button = new JButton();
		button.setIcon(btn_default);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setRolloverIcon(btn_hover);
		button.setPressedIcon(btn_press);
		
		this.width = btn_default.getIconWidth();
		this.height = btn_default.getIconHeight();
	}
	
	public JButton getButton()
	{
		return button;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
