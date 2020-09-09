/*
 * 
 * Manages The token map in combination with HouseMap
 * 
 */

package gui;

import javax.swing.JPanel;

import actors.Token;
import tiles.TileDeck;

public class HouseTokens extends JPanel {

	private Token[] tokenarray = new Token[6913];		//Full Token Map of the House
	Token empty_token = new Token();
	
	public HouseTokens()
	{
		
		//Fill tokenmap with "Blank" tokens
		for (int j = 0; j < 144; ++j)
		{
			for(int i = 0; i < 48; ++i)
			{
				tokenarray[i+j*48] = new Token();
			}
		}
	}
	
	//Draw token on (x,y) tile of Housemap
	public void drawToken(HouseMap housemap, TokenMap tokenmap, TileDeck deck, Token token, int x, int y)
	{
		//set new Room for token
		token.setRoomx(x);
		token.setRoomx(y);
		
		//Put Token in new room's data
		TileGui tilegui = housemap.getTile(x,y);
		
		tilegui.drawToken(token);
		
		//Set token to place in tokenmap
		this.tokenarray[token.getX()+token.getRoomx()*4+(token.getY()+token.getRoomy()*4)*12] = token;
		
		//Call Tokenmap draw function
		tokenmap.drawToken(token.getName(), token.getX(), token.getY(), token.getRoomx(),  token.getRoomy());
		
	}
	
	//Remove token on (x,y) tile of Housemap
	public void removeToken(HouseMap housemap, TokenMap tokenmap, Token token, int x, int y)
	{
	
		//Remove token from room's data
		TileGui tilegui = housemap.getTile(x, y);
		//Call TileGui's remove method
		tilegui.removeToken(token);
		
		//Set location in tokenmap to a Blank Token
		this.tokenarray[(token.getX()+token.getRoomx()*4)+(token.getY()+token.getRoomy()*4)*12] = new Token();
		
		//Call Tokenmap remove function
		tokenmap.removeToken(token.getX(), token.getY(), token.getRoomx(),  token.getRoomy());
	}
	
	//Move token from (x1,y1) tile to (x2,y2) tile of Housemap
	public void moveToken(HouseMap housemap, TokenMap tokenmap, TileDeck deck, Token token, int x1, int y1, int x2, int y2)
	{
		if (!deck.deckEmpty(x2, y2));
		{
	
		removeToken(housemap, tokenmap, token, x1, y1);
		drawToken(housemap, tokenmap, deck, token, x2, y2);
		}
	}
}
