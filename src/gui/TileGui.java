/**
 * This serves as a visual frontend for the Tile system.
 * The TileGui uses the image set by the tile as 
 * 
 * 
 * 
 */
package gui;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.ImageIcon;
import tiles.Tile;
import actors.Token;



public class TileGui extends JPanel{

	
	private ImageIcon icon;
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private Tile tile;
	private Token[] tokenStorage = new Token[16];
	private String name;
	private int x;
	private int y;
	
	public TileGui(Tile tile)
	{
		
		this.tile = tile;
		this.name = tile.getName();
		this.setLayout(gridbag);
		this.icon = tile.getImageIcon();
		this.setSize(256,256);
		this.setPreferredSize(new Dimension(256,256));
		this.setOpaque(false);
		this.x = tile.getX();
		this.y = tile.getY();
		
		for(int i = 0; i < 4; ++i)
		{
			for (int j = 0; j < 4; ++j)
			{
				
				Token temp = new Token();
				tokenStorage[i*4+j] = temp;
				
			}
		}
	}
	
	public void drawToken(Token token)
	{
		//Take first avaliable and set X,Y of token
		Point dim = checkStorage(token);
		token.setX((int)(dim.getX()));
		token.setY((int)(dim.getY()));
		token.setRoomx(x);
		token.setRoomy(y);
		
		tokenStorage[token.getX()+token.getY()*4] = token;
		
	}
	//
	public void removeToken(Token token)
	{
		c.gridx = token.getX();
		c.gridy = token.getY();
		
		tokenStorage[token.getX()+token.getY()*4] = new Token();
		
		
	}
	
	//Set Token spot based on 1st free optimal space 
	private Point orderTokens(Token token)
	{
		int x =0;
		int y =0;
		
		for(int i = 0; i <16; ++i)
		{
			
			if (tokenStorage[i].getName().equals("Blank"))
			{
				//Set x,y of token to 1st avaliable optimal
				switch(i)
				{
				case 0:
					x = 1; y = 1; break;
				case 1:
					x = 2; y = 2; break;
				case 2:
					x = 1; y = 2; break;
				case 3:
					x = 2; y = 2; break;
				case 4:
					x = 1; y = 0; break;
				case 5:
					x = 2; y = 0; break;
				case 6:
					x = 0; y = 1; break;
				case 7:
					x = 0; y = 2; break;
				case 8:
					x = 3; y = 1; break;
				case 9:
					x = 3; y = 1; break;
				case 10:
					x = 1; y = 3; break;
				case 11:
					x = 2; y = 3; break;
				case 12:
					x = 0; y = 0; break;
				case 13:
					x = 3; y = 0; break;
				case 14:
					x = 0; y = 3; break;
				case 15:
					x = 3; y = 3; break;
				}
				
				i=16;	//end loop
				
			}
		}
		
		return(new Point(x,y));
	}
	
	private Point checkStorage(Token token)
	{
		int tx = 0;
		int ty = 0;
		
		if (tokenStorage[5].getName().contentEquals("Blank"))
		{
			tokenStorage[5] = token;
			tx = 1; ty = 1;
		}
		else if (tokenStorage[6].getName().contentEquals("Blank"))
		{
			tokenStorage[6]=token;
			tx = 2; ty = 1;
		}
		else if (tokenStorage[9].getName().contentEquals("Blank"))
		{
			tokenStorage[9]=token;
			tx = 1; ty = 2;
		}
		else if (tokenStorage[10].getName().contentEquals("Blank"))
		{
			tokenStorage[10]=token;
			tx = 2; ty = 2;
		}
		else if (tokenStorage[1].getName().contentEquals("Blank"))
		{
			tokenStorage[1]=token;
			tx = 1; ty = 0;
		}
		else if (tokenStorage[2].getName().contentEquals("Blank"))
		{
			tokenStorage[2]=token;
			tx = 2; ty = 0;
		}
		else if (tokenStorage[4].getName().contentEquals("Blank"))
		{
			tokenStorage[4]=token;
			tx = 0; ty = 1;
		}
		else if (tokenStorage[8].getName().contentEquals("Blank"))
		{
			tokenStorage[8]=token;
			tx = 0; ty = 2;
		}
		else if (tokenStorage[7].getName().contentEquals("Blank"))
		{
			tokenStorage[7]=token;
			tx = 3; ty = 1;
		}
		else if (tokenStorage[11].getName().contentEquals("Blank"))
		{
			tokenStorage[11]=token;
			tx = 3; ty = 2;
		}
		else if (tokenStorage[13].getName().contentEquals("Blank"))
		{
			tokenStorage[13]=token;
			tx = 1; ty = 3;
		}
		else if (tokenStorage[14].getName().contentEquals("Blank"))
		{
			tokenStorage[14]=token;
			tx = 2; ty = 3;
		}
		else if (tokenStorage[0].getName().contentEquals("Blank"))
		{
			tokenStorage[0]=token;
			tx = 0; ty = 0;
		}
		else if (tokenStorage[3].getName().contentEquals("Blank"))
		{
			tokenStorage[3]=token;
			tx = 3; ty = 0;
		}
		else if (tokenStorage[12].getName().contentEquals("Blank"))
		{
			tokenStorage[12]=token;
			tx = 0; ty = 3;
		}
		else if (tokenStorage[15].getName().contentEquals("Blank"))
		{
			tokenStorage[15]=token;
			tx = 3; ty = 3;
		}
		else
		{
			//for error handling
			tx=4;ty=4;
		}
		Point output = new Point(tx,ty);
		return output; 
	}
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	        g.drawImage(icon.getImage(), 0, 0, null);
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
	

