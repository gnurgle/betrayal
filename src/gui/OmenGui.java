/*
 * 
 * Populates arraylist of Omens
 * 
 */
package gui;

import java.util.ArrayList;
import java.util.Collections;

import Omens.*;
import actors.Player;
import game.Omens;

public class OmenGui {

	private ArrayList<Omens> omenlist = new ArrayList<Omens>();
	private Omens currentOmen;
	public OmenGui()
	{
		
	}
	
	public void populate()
	{
		//Add events to omenlist
		omenlist.add(new Bell());
		omenlist.add(new Bite());
		omenlist.add(new Book());
		omenlist.add(new Dog());
		omenlist.add(new Girl());
		omenlist.add(new HolySymbol());
		omenlist.add(new Idol());
		omenlist.add(new Madman());
		omenlist.add(new Mask());
		omenlist.add(new Medallion());
		omenlist.add(new Skull());
		omenlist.add(new Spear());
	
		
		Collections.shuffle(omenlist);
	}
	
	public void getOmen(Player player)
	{
		//grab next event
		currentOmen = omenlist.get(0);
		omenlist.remove(0);
		currentOmen.activate(player);
		player.getCharacter().addOmens(currentOmen);
	}

	public Omens getCurrentOmen() {
		return currentOmen;
	}
	
	
}
