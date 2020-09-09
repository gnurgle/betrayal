/*
 * This sets the popup menu for the move menu.
 * It displays only the buttons that are 
 * relevant for the tile it's being called on
 * 
 * 
 * 
 */
package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import actors.Token;
import tiles.Room.Direction;
import tiles.Room.Type;
import tiles.Tile;

public class MovePanel extends JPanel{

	private ImageIcon icon = new ImageIcon(getClass().getResource("/res/gui/move_panel.png"));
	
	public JButton btn_north;
	public JButton btn_south;
	public JButton btn_east;
	public JButton btn_west;
	public JButton btn_up;
	public JButton btn_down;
	public JButton btn_cancel;
	public JButton btn_blank;
	
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	
	public MovePanel(HouseMap housemap, Token token, TileGui tilegui)
	{
		
		this.setSize(icon.getIconWidth(),icon.getIconHeight());
		this.setPreferredSize(new Dimension(icon.getIconWidth()-30,icon.getIconHeight()));
		this.setBounds(0, 0, 300, 481);
		this.setOpaque(false);
		
		//Initialize buttons
		btn_north = new ImageButton("north").getButton();
		btn_south = new ImageButton("south").getButton();
		btn_east = new ImageButton("east").getButton();
		btn_west = new ImageButton("west").getButton();
		btn_up = new ImageButton("up").getButton();
		btn_down = new ImageButton("down").getButton();
		btn_cancel = new ImageButton("cancel").getButton();
		btn_blank = new ImageButton("blank").getButton();
		JButton btn_blank1 = new ImageButton("blank").getButton();
		JButton btn_blank2 = new ImageButton("blank").getButton();
		JButton btn_blank3 = new ImageButton("blank").getButton();
		JButton btn_blank4 = new ImageButton("blank").getButton();
		JButton btn_blank5 = new ImageButton("blank").getButton();
		this.setLayout(gridbag);
		
		c.gridx=0;
		c.gridy=0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady=10;
		
		//The button checks if the tile has the correct exit,
		//if the next room is empty or has an opposite exit,
		//and is within bounds
		
		if (tilegui.getTile().getRoom().getExits().contains(Direction.NORTH) && 
				(housemap.getTile(token.getRoomx(), token.getRoomy()-1).getTile().getRoom().getName().contentEquals("Blank") || 
						housemap.getTile(token.getRoomx(), token.getRoomy()-1).getTile().getRoom().getExits().contains(Direction.SOUTH))
				&& (token.getRoomy()-1 != 8) && (token.getRoomy()-1 != 17))
			this.add(btn_north,c);
		else
			this.add(btn_blank,c);
		c.ipady=0;
		c.gridy++;
		if (tilegui.getTile().getRoom().getExits().contains(Direction.SOUTH) && 
				(housemap.getTile(token.getRoomx(), token.getRoomy()+1).getTile().getRoom().getName().contentEquals("Blank") || 
						housemap.getTile(token.getRoomx(), token.getRoomy()+1).getTile().getRoom().getExits().contains(Direction.NORTH))
				&& (token.getRoomy()+1 != 9) && (token.getRoomy()+1 != 18) && (token.getRoomy()+1 !=27))
			this.add(btn_south,c);
		else
			this.add(btn_blank1,c);
		c.gridy++;
		if (tilegui.getTile().getRoom().getExits().contains(Direction.EAST) && 
				(housemap.getTile(token.getRoomx()+1, token.getRoomy()).getTile().getRoom().getName().contentEquals("Blank") || 
						housemap.getTile(token.getRoomx()+1, token.getRoomy()).getTile().getRoom().getExits().contains(Direction.WEST))
				&& (token.getRoomx()+1 != 10))
			this.add(btn_east,c);
		else
			this.add(btn_blank2,c);
		c.gridy++;
		if (tilegui.getTile().getRoom().getExits().contains(Direction.WEST) && 
				(housemap.getTile(token.getRoomx()-1, token.getRoomy()).getTile().getRoom().getName().contentEquals("Blank") || 
						housemap.getTile(token.getRoomx()-1, token.getRoomy()).getTile().getRoom().getExits().contains(Direction.EAST))
				&& (token.getRoomx()-1 != 10))
			this.add(btn_west,c);
		else
			this.add(btn_blank3,c);
		c.gridy++;
		if (tilegui.getTile().getRoom().getType().contains(Type.UP))
			this.add(btn_up,c);
		else
			this.add(btn_blank4,c);
		c.gridy++;
		if (tilegui.getTile().getRoom().getType().contains(Type.DOWN))
			this.add(btn_down,c);
		else
			this.add(btn_blank5,c);
		c.gridy++;
		this.add(btn_cancel,c);
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(icon.getImage(), 0, 0, null);
	}
}
