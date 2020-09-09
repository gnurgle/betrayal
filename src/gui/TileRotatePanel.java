//This class is responsible for holding all different possibilities
//of token facings for drawing over the tiles. Naming convention
//is to be used with Token.getName()

package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tiles.Room.Direction;

public class TileRotatePanel implements ItemListener {
	private CardLayout cardLayout;
	private int rotation;
	public ImagePanel cardPanel;
	
	private TileGui tile0; 
	private TileGui tile90;
	private TileGui tile180;
	private TileGui tile270;
	private TileGui currentTile;
	private boolean flag0 = false;
	private boolean flag90 = false;
	private boolean flag180 = false;
	private boolean flag270 = false;
	private ImageIcon image90;
	private ImageIcon image180;
	private ImageIcon image270;
	
	public TileRotatePanel(TileGui tilegui, Direction dir)
	{
		tile0 = tilegui;
		cardPanel = new ImagePanel(new ImageIcon(getClass().getResource("/res/tiles/Blank.png")));
		cardPanel.setPreferredSize(new Dimension(tile0.getIcon().getIconWidth(), tile0.getIcon().getIconHeight()));
		
		JLabel degrees0 = new JLabel("0");
		JLabel degrees90 = new JLabel("90");
		JLabel degrees180 = new JLabel("180");
		JLabel degrees270 = new JLabel("270");
		
		
		image90 = new ImageIcon(getClass().getResource("/res/tiles/" + tile0.getTile().getRoom().getName() + "270.jpg"));
		image180 = new ImageIcon(getClass().getResource("/res/tiles/" + tile0.getTile().getRoom().getName() + "180.jpg"));
		image270 = new ImageIcon(getClass().getResource("/res/tiles/" + tile0.getTile().getRoom().getName() + "90.jpg"));
		
		degrees90.setIcon(image90);
		degrees180.setIcon(image180);
		degrees270.setIcon(image270);
		degrees0.setIcon(tile0.getIcon());
		
		//Card Layout
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
	
		//Add components to Card Layout
		if (check90(tile0, dir))
		{
			cardPanel.add(degrees90, "degrees90");
			cardLayout.show(cardPanel, "degrees90");
			currentTile = tile90;
			rotation = 90;
			flag90 = true;
		}
		if (check180(tile0, dir))
		{
			cardPanel.add(degrees180, "degrees180");
			cardLayout.show(cardPanel, "degrees180");
			currentTile = tile180;
			rotation = 180;
			flag180 = true;
		}
		if (check270(tile0, dir))
		{
			cardPanel.add(degrees270, "degrees270");
			cardLayout.show(cardPanel, "degrees270");
			currentTile = tile270;
			rotation = 270;
			flag270 = true;
		}
		if (check0(tile0,dir))
		{
			cardPanel.add(degrees0, "degrees0");
			cardLayout.show(cardPanel, "degrees0");
			currentTile = tile0;
			rotation = 0;
			flag0 = true;
		}
		
	}
	
	//Check rotated exits
	private boolean check0(TileGui tilegui, Direction dir)
	{
		TileGui tileexit = tilegui;
		if ((dir == (Direction.NORTH) && tileexit.getTile().getRoom().getExits().contains(Direction.SOUTH)))
			return true;
		else if ((dir == (Direction.SOUTH) && tileexit.getTile().getRoom().getExits().contains(Direction.NORTH)))
			return true;
		else if ((dir == (Direction.EAST) && tileexit.getTile().getRoom().getExits().contains(Direction.WEST)))
			return true;
		else if ((dir == (Direction.WEST) && tileexit.getTile().getRoom().getExits().contains(Direction.EAST)))
			return true;
		else
		
		return false;
	}
	
	private boolean check270(TileGui tilegui, Direction dir)
	{
		TileGui tileexit = tilegui;
		if ((dir == (Direction.NORTH) && tileexit.getTile().getRoom().getExits().contains(Direction.WEST)))
			return true;
		else if ((dir == (Direction.SOUTH) && tileexit.getTile().getRoom().getExits().contains(Direction.EAST)))
			return true;
		else if ((dir == (Direction.EAST) && tileexit.getTile().getRoom().getExits().contains(Direction.NORTH)))
			return true;
		else if ((dir == (Direction.WEST) && tileexit.getTile().getRoom().getExits().contains(Direction.SOUTH)))
			return true;
		else
		
		return false;
	}
	
	private boolean check180(TileGui tilegui, Direction dir)
	{
		TileGui tileexit = tilegui;
		if ((dir == (Direction.NORTH) && tileexit.getTile().getRoom().getExits().contains(Direction.NORTH)))
			return true;
		else if ((dir == (Direction.SOUTH) && tileexit.getTile().getRoom().getExits().contains(Direction.SOUTH)))
			return true;
		else if ((dir == (Direction.EAST) && tileexit.getTile().getRoom().getExits().contains(Direction.EAST)))
			return true;
		else if ((dir == (Direction.WEST) && tileexit.getTile().getRoom().getExits().contains(Direction.WEST)))
			return true;
		else
			return false;
	}
		
	private boolean check90(TileGui tilegui, Direction dir)
	{
			TileGui tileexit = tilegui;
			if ((dir == (Direction.NORTH) && tileexit.getTile().getRoom().getExits().contains(Direction.EAST)))
				return true;
			else if ((dir == (Direction.SOUTH) && tileexit.getTile().getRoom().getExits().contains(Direction.WEST)))
				return true;
			else if ((dir == (Direction.EAST) && tileexit.getTile().getRoom().getExits().contains(Direction.SOUTH)))
				return true;
			else if ((dir == (Direction.WEST) && tileexit.getTile().getRoom().getExits().contains(Direction.NORTH)))
				return true;
			else
			
			return false;
	}
	
	
	
	//Rotate Exits
	private TileGui rotateExits(TileGui tilegui)
	{
		TileGui tileguiexit = tilegui;
		boolean north = false;
		boolean south = false;
		boolean east = false;
		boolean west = false;
	
		if (tileguiexit.getTile().getRoom().getExits().contains(Direction.NORTH))
		{
			north = true;
			tileguiexit.getTile().getRoom().getExits().remove(Direction.NORTH);
		}
		if (tileguiexit.getTile().getRoom().getExits().contains(Direction.SOUTH))
		{
			south = true;
			tileguiexit.getTile().getRoom().getExits().remove(Direction.SOUTH);
		}
		if (tileguiexit.getTile().getRoom().getExits().contains(Direction.EAST))
		{
			east = true;
			tileguiexit.getTile().getRoom().getExits().remove(Direction.EAST);
		}
		if (tileguiexit.getTile().getRoom().getExits().contains(Direction.WEST))
		{
			west = true;
			tileguiexit.getTile().getRoom().getExits().remove(Direction.WEST);
		}
		
		if(north)
			tileguiexit.getTile().getRoom().addExit(Direction.EAST);
		if(east)
			tileguiexit.getTile().getRoom().addExit(Direction.SOUTH);
		if(south)
			tileguiexit.getTile().getRoom().addExit(Direction.WEST);
		if(west)
			tileguiexit.getTile().getRoom().addExit(Direction.NORTH);
	
		return tileguiexit;
		
	}
	
	public void setCard(String str)
	{
		cardLayout.show(cardPanel, str);
	}
	
	public void nextCard()
	{
		cardLayout.next(cardPanel);
		cardPanel.validate();
		cardPanel.repaint();
		cardPanel.revalidate();
		nextTile();
	}
	
	public ImagePanel getCardPanel() {
		return cardPanel;
	}
	
	private void nextTile()
	{
		if (rotation == 0)
		{
			if (flag90)
				rotation = 90;
			else if (flag180)
				rotation = 180;
			else if (flag270)
				rotation = 270;
			else
				rotation = 0;
		}
		else if (rotation == 90)
		{	
			if (flag180)
				rotation = 180;
			else if (flag270)
				rotation = 270;
			else if (flag0)
				rotation = 0;
			else
				rotation = 90;
		}
		else if (rotation == 180)
		{	
			if (flag270)
				rotation = 270;
			else if (flag0)
				rotation = 0;
			else if (flag90)
				rotation = 90;
			else
				rotation = 180;
		}
		else if (rotation == 270)
		{	
			if(flag0)
				rotation = 0;
			else if (flag90)
				rotation = 90;
			else if (flag180)
				rotation = 180;
			else rotation = 270;
			
		}
	}
	
	
	public TileGui getCurrentTile() {
		currentTile = tile0;
		for(int i = 0; i < rotation/90; ++i)
		{
			rotateExits(currentTile);
		}
		if (rotation == 90)
			currentTile.setIcon(image90);
		else if (rotation == 180)
			currentTile.setIcon(image180);	
		else if (rotation == 270)
			currentTile.setIcon(image270);
		return currentTile;
	}
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cardPanel.getLayout());
        cl.show(cardPanel, (String)evt.getItem());
    }
}