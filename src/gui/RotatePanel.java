/*
 * This sets the popup menu for the move menu.
 * It displays only the buttons that are 
 * relevant for the tile it's being called on
 * 
 * 
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actors.Token;
import game.ResourceLoad;
import tiles.Room.Direction;
import tiles.Room.Type;
import tiles.Tile;

public class RotatePanel extends JPanel{

	private ImageIcon icon = new ImageIcon(getClass().getResource("/res/gui/move_panel.png"));
	public JButton btn_rotate;
	public JButton btn_confirm_rotate;
	protected JPanel tileChoice;
	private TileRotatePanel tilerotatepanel;
	private ResourceLoad loadstuff = new ResourceLoad();
	
	
	public RotatePanel(TileGui tilegui, Direction dir)
	{
		
		loadstuff.LoadResources();
		
		this.setSize(icon.getIconWidth(),icon.getIconHeight());
		this.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
		this.setOpaque(false);
	
		
		
		//Initialize buttons
		btn_rotate = new ImageButton("rotate").getButton();
		btn_confirm_rotate = new ImageButton("confirm").getButton();

		
		//The button checks if the tile has the correct exit,
		//if the next room is empty or has an opposite exit,
		//and is within bounds
		JLabel header = new JLabel();
		header.setFont(new Font("Letter Gothic", Font.PLAIN, 16));
		header.setForeground(Color.WHITE);
		String input = "Select Room Orientation";
		header.setText("<html><div style='text-align: center;'>" + input + "</div></html>");
		this.add(header);

		this.add(btn_rotate);
		
		
		tilerotatepanel = new TileRotatePanel(tilegui, dir);
		
		this.add(tilerotatepanel.getCardPanel());
		
		this.add(btn_confirm_rotate);
	}
	
	
	public void nextCard()
	{
		tilerotatepanel.nextCard();
	}
	
	
	
	public TileRotatePanel getTileRotatePanel() {
		return tilerotatepanel;
	}






	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(icon.getImage(), 0, 0, null);
	}
}
