package tiles;

import java.util.ArrayList;
import java.util.Collections;

import gui.HouseMap;
import gui.TileGui;
import tiles.Room.Floor;

public class TileDeck {

	private ArrayList<Tile> upperDeck;
	private ArrayList<Tile>	groundDeck;
	private ArrayList<Tile> basementDeck;
	private ArrayList<Tile> tileList;
	//private Tile_Populate tilepop;
	
	public TileDeck(Tile_Populate tilepop)
	{
		upperDeck = new ArrayList<Tile>();
		groundDeck = new ArrayList<Tile>();
		basementDeck = new ArrayList<Tile>();
		
		//tilepop = new Tile_Populate();
		tileList = tilepop.getTileList();
	
		
		//Cycle through tileList and add to appropriate decks
		for(int i = 0; i < tileList.size(); ++i)
		{
			Tile temp = tileList.get(i);
		
			//Check room properties to add to relevant deck
			
			if(temp.getRoom().getFloor().contains(Floor.UPPER))
			{
				upperDeck.add(temp);
			}
			
			if(temp.getRoom().getFloor().contains(Floor.GROUND))
			{
				groundDeck.add(temp);
			}
			
			if(temp.getRoom().getFloor().contains(Floor.BASEMENT))
			{
				basementDeck.add(temp);
			}
		}
		
		//Shuffle tiles in deck
		Collections.shuffle(upperDeck);
		Collections.shuffle(groundDeck);
		Collections.shuffle(basementDeck);
	}

	public ArrayList<Tile> getUpperDeck() {
		return upperDeck;
	}

	public ArrayList<Tile> getGroundDeck() {
		return groundDeck;
	}

	public ArrayList<Tile> getBasementDeck() {
		return basementDeck;
	}

	public ArrayList<Tile> getTileList() {
		return tileList;
	}
	
	public TileGui fetchTile(HouseMap housemap, int x, int y)
	{
		TileGui tilegui = housemap.getTile(x, y);
		
		if (y < 9)
			tilegui = pullTop(basementDeck);
		else if (y < 19)
			tilegui = pullTop(groundDeck);
		else
			tilegui = pullTop(upperDeck);
		
		//remove instance from other Decks
		basementDeck.remove(tilegui.getTile());
		groundDeck.remove(tilegui.getTile());
		upperDeck.remove(tilegui.getTile());
		
		tilegui.getTile().setX(x);
		tilegui.getTile().setY(y);
		
		return tilegui;
		
	}
	
	//pull and remove top tile from deck
	private TileGui pullTop(ArrayList<Tile> deck)
	{
		TileGui tiletemp = new TileGui(deck.get(0));
		deck.remove(0);
		
		return tiletemp;
	}
	
	//Check if there is a tile card to fetch
	public boolean deckEmpty(int x, int y)
	{
	if (y < 9 && basementDeck.size() == 0)
		return true;
	else if (y < 19 && groundDeck.size() == 0)
		return true;
	else if (upperDeck.size() == 0)
		return true;
	else
		return false;
	}
}
