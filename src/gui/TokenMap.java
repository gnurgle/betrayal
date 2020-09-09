/**
 * Acts as a visual frontend for the token layout over the tiles.
 * This is done using an array of TokenCard. This is linked to a
 * Scroll Pane. drawToken and removeToken will generally be called
 * by HouseTokens, but can be called directly for any reason.
 */
package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import actors.Token;

public class TokenMap extends JPanel{

	private GridBagLayout gridlayout = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private TokenCard[] cardmap = new TokenCard[6913];
	//private int x;
	//private int y;
	public TokenMap()
	{
		//Set JPanel parameters
		this.setSize(3072,9216);
		this.setPreferredSize(new Dimension(3072, 9216));
		this.setBounds(0, 0, 3072,9216);
		this.setOpaque(false);
		
		//Set Layout
		setLayout(gridlayout);
		
		//Fill GridBag and array with Blank face TokenCards
		for (int j = 0; j < 144; ++j)
		{
			c.gridy = j;
			for(int i = 0; i < 48; ++i)
			{
				c.gridx = i;
				
				add(new TokenCard().getCardPanel(),c);
				cardmap[i+j*48] = new TokenCard();
			}
		}
	}
	
	//Change the TokenCard to the proper image for token at location
	public void drawToken(String str, int x, int y, int roomx, int roomy)
	{
		//Set GridBagConstraints to absolute x, y
		c.gridx = (x+roomx*4);
		c.gridy = (y+roomy*4);
		
		
		//Prep replacement TokenCard
		TokenCard test = new TokenCard();
		test.setCard(str);
		
		//Overwrite TokenCard in array and remove old
		cardmap[(x+roomx*4)+(y+roomy*4)*12]=test;
		remove((x+roomx*4)+(y+roomy*4)*12);
		
		//Add replacement TokenCard to visual layout
		add(test.getCardPanel(),c);
	}
	
	//Changes the TokenCard to blank image and resets array at location
	public void removeToken(int x, int y, int roomx, int roomy)
	{
		//Set GridBagConstraints to absolute x,y
		c.gridx = (x+roomx*4);
		c.gridy = (y+roomy*4);
		
		//Prep replacement TokenCard
		TokenCard test = cardmap[(x+roomx*4)+(y+roomy*4)*12];
		test.setCard("Blank");
		//Overwrite TokenCard in array and remove old
		//cardmap[(x+roomx*4)+(y+roomy*4)*12]=test;
		//remove((x+roomx*4)+(y+roomy*4)*12);
		
		//Add replacement TokenCard to visual layout
		add(test.getCardPanel(),c);
	}
}
