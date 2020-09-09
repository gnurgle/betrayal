/*
 * This populates all of the Items
 * 
 */

package gui;

import java.util.ArrayList;
import java.util.Collections;

import Items.*;
import actors.Player;
import game.Items;

public class ItemGui {

	private ArrayList<Items> itemlist = new ArrayList<Items>();
	private Items currentItem;
	public ItemGui()
	{
		
	}
	
	public void populate()
	{
		//Add events to itemlist
		itemlist.add(new AmuletOfTheAges());
		itemlist.add(new Armor());
		itemlist.add(new BloodDagger());
		itemlist.add(new Bottle());
		itemlist.add(new HealingSalve());
		itemlist.add(new LuckyStone());
		itemlist.add(new PuzzleBox());
		itemlist.add(new Revolver());
		itemlist.add(new SmellingSalts());
	
		
		Collections.shuffle(itemlist);
	}
	
	public void getItem(Player player)
	{
		//grab next event
		currentItem = itemlist.get(0);
		itemlist.remove(0);
		currentItem.activate(player);
		player.getCharacter().addItems(currentItem);
	}

	public Items getCurrentItem() {
		return currentItem;
	}
	
	
}
