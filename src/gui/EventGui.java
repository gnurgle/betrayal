/**
 * 
 * Populate Events to an Arraylist
 * 
 */

package gui;

import java.util.ArrayList;
import java.util.Collections;

import Events.*;
import actors.Player;
import game.Events;

public class EventGui {

	private ArrayList<Events> eventlist = new ArrayList<Events>();
	private Events currentEvent;
	public EventGui()
	{
		
	}
	
	public void populate()
	{
		//Add events to eventlist
		eventlist.add(new AngryBeing());
		eventlist.add(new BurningMan());
		eventlist.add(new CreepyCrawlies());
		eventlist.add(new Debris());
		eventlist.add(new DisquietingSounds());
		eventlist.add(new Footsteps());
		eventlist.add(new Funeral());
		eventlist.add(new GraveDirt());
		eventlist.add(new HangedMan());
		eventlist.add(new HideousShriek());
		eventlist.add(new MistFromTheWalls());
		eventlist.add(new NightView());
		eventlist.add(new PhoneCall());
		eventlist.add(new Possesion());
		eventlist.add(new Rotten());
		eventlist.add(new ShriekingWind());
		eventlist.add(new Silence());
		eventlist.add(new SomethingSlimy());
		eventlist.add(new TheBeckoning());
		
		Collections.shuffle(eventlist);
	}
	
	public void getEvent(Player player)
	{
		//grab next event
		currentEvent = eventlist.get(0);
		eventlist.remove(0);
		currentEvent.activate(player);
	}

	public Events getCurrentEvent() {
		return currentEvent;
	}
	
	
}
