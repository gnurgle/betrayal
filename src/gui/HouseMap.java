/*
 * 
 * Keeps track of tiles on the board
 * Interfaces with Tokens, players, everything
 */

package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import tiles.Room;
import tiles.Tile;



public class HouseMap extends JPanel{

	private TileGui[] housemap = new TileGui[433];		//Full Map of the House
	private ImageIcon blankTile = new ImageIcon(getClass().getResource("/res/tiles/Blank.png"));
	GridBagLayout grid_bgpanel = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();
	
	//All set specifically for this case
	public HouseMap()
	{	
		this.setLayout(grid_bgpanel);
		
		//Set Boundaries and transparency of Panel
		this.setSize(3072,9216);
		this.setPreferredSize(new Dimension(3072, 9216));
		this.setBounds(0, 0, 3072,9216);
		this.setOpaque(false);
		
		//Initialize All blank tiles
		for(int i = 0; i < 12; ++i)
		{
			c.gridx = i;
			for (int j = 0; j < 36; ++j)
			{
				c.gridx = i;
				c.gridy = j;
				TileGui temp = new TileGui(new Tile(new Room("Blank", ""),i,j,"/res/tiles/Blank.png"));
				
				this.add(new TileGui(new Tile(new Room("Blank", ""),c.gridx,c.gridy,"/res/tiles/Blank.png")),c);
				housemap[i+j*12] = new TileGui(new Tile(new Room("Blank", ""),c.gridx,c.gridy,"/res/tiles/Blank.png"));
			}
		}
	}
		//public void drawTile(TileGui tile,int x,int y)
		public void drawTile(TileGui tile, int x, int y)
		{
			//Save coordinates to tile
			tile.setX(x);
			tile.setY(y);
			
			//Add coordinates to grid
			c.gridx = x;
			c.gridy = y;
			
			//remove previous tile
			this.remove(x+y*12);
			
			//Add image to bg
			JLabel lbl = new JLabel(tile.getIcon());
			this.add(lbl,c);
			
			//Add tile to map of tiles
			housemap[x+y*12] = tile;
			
			//Make sure everything is drawn
			this.validate();
			this.revalidate();
			this.repaint();
		}
		
		public void removeTile(TileGui tile)
		{
			c.gridx = tile.getX();
			c.gridy = tile.getY();
			this.remove(tile.getX()+tile.getY()*12);
			housemap[tile.getX()+tile.getY()*12] = new TileGui(new Tile(new Room("Blank", ""),tile.getX(),tile.getY(),"/res/objects/blanktile.png"));
			
			JLabel lbl = new JLabel(blankTile);
		
			this.add(lbl,c);
		}
		
		public TileGui getTile(int x, int y)
		{
			return housemap[x+y*12];
		}
		
		public int getMapSize()
		{
			return housemap.length;
		}
		
		public String getEntryName(int num)
		{
			return housemap[num].getName();
		}
}
	

