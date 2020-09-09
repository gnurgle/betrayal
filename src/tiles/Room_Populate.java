/*
 * 
 * Populates parameters of all rooms
 * 
 */
package tiles;

import java.util.EnumSet;

import tiles.Room;
import tiles.Room.Direction;
import tiles.Room.Floor;
import tiles.Room.Type;


public class Room_Populate extends Room
{
	protected Room abandoned;
	protected Room attic;
	protected Room balcony;
	protected Room ballroom;
	protected Room basement;
	protected Room bedroom;
	protected Room bloody;
	protected Room catacombs;
	protected Room chapel;
	protected Room charred;
	protected Room chasm;
	protected Room coal;
	protected Room collapsed;
	protected Room conservatory;
	protected Room creaky;
	protected Room crypt;
	protected Room dining;
	protected Room dusty;
	protected Room furnace;
	protected Room gallery;
	protected Room gameroom;
	protected Room gardens;
	protected Room graveyard;
	protected Room gym;
	protected Room junk;
	protected Room kitchen;
	protected Room larder;
	protected Room library;
	protected Room master;
	protected Room operating;
	protected Room organ;
	protected Room patio;
	protected Room pentagram;
	protected Room research;
	protected Room servant;
	protected Room stairs;
	protected Room statuary;
	protected Room storeroom;
	protected Room tower;
	protected Room lake;
	protected Room landing_upper;
	protected Room cellar;
	protected Room grand;
	protected Room foyer;
	protected Room entrance;
	protected Room door;
	protected Room blank;
	
	
	
	public Room_Populate()
	{
	}
	
	public void populate()
	{
		//Populate Rooms
		
		
		//---Base Game---
		//Abandoned Room
		abandoned = new Room("Abandoned Room", "");
		abandoned.addExit(Direction.NORTH);
		abandoned.addExit(Direction.EAST);
		abandoned.addExit(Direction.SOUTH);
		abandoned.addExit(Direction.WEST);
		abandoned.addFloor(Floor.BASEMENT);
		abandoned.addFloor(Floor.GROUND);
		abandoned.addType(Type.OMEN);
		
		//Attic
		attic = new Room("Attic", "When exiting, you must attempt a Speed roll of 3+. If you fail, lose 1 Might (but continue moving)");
		attic.addExit(Direction.SOUTH);
		attic.addFloor(Floor.UPPER);
		attic.addType(Type.EVENT);
		attic.addType(Type.EXIT);
		
		//Balcony
		balcony = new Room("Balcony", "");
		balcony.addExit(Direction.NORTH);
		balcony.addExit(Direction.SOUTH);
		balcony.addFloor(Floor.UPPER);
		balcony.addType(Type.OMEN);
		balcony.addType(Type.OUTSIDE);
		
		//Ballroom
		ballroom = new Room("Ballroom", "");
		ballroom.addExit(Direction.NORTH);
		ballroom.addExit(Direction.EAST);
		ballroom.addExit(Direction.SOUTH);
		ballroom.addExit(Direction.WEST);
		ballroom.addFloor(Floor.GROUND);
		ballroom.addType(Type.EVENT);
		
		//Basement Landing
		basement = new Room("Basement Landing", "");
		basement.addExit(Direction.NORTH);
		basement.addExit(Direction.EAST);
		basement.addExit(Direction.SOUTH);
		basement.addExit(Direction.WEST);
		basement.addFloor(Floor.BASEMENT);
		
		//Bedroom
		bedroom = new Room("Bedroom", "");
		bedroom.addExit(Direction.EAST);
		bedroom.addExit(Direction.WEST);
		bedroom.addFloor(Floor.UPPER);
		bedroom.addType(Type.EVENT);
		bedroom.addType(Type.WINDOW);
		
		//Bloody Room
		bloody = new Room("Bloody Room", "");
		bloody.addExit(Direction.NORTH);
		bloody.addExit(Direction.EAST);
		bloody.addExit(Direction.SOUTH);
		bloody.addExit(Direction.WEST);
		bloody.addFloor(Floor.UPPER);
		bloody.addFloor(Floor.GROUND);
		bloody.addType(Type.ITEM);
		
		//Catacombs
		catacombs = new Room("Catacombs","You can attempt a Sanity roll of 6+ to cross. If you fail, you stop moving.");
		catacombs.addExit(Direction.NORTH);
		catacombs.addExit(Direction.SOUTH);
		catacombs.addFloor(Floor.BASEMENT);
		catacombs.addType(Type.OMEN);
		catacombs.addType(Type.CROSS);

		//Chapel
		chapel = new Room("Chapel", "Once per game, if you end your turn here, gain 1 Sanity.");
		chapel.addExit(Direction.NORTH);
		chapel.addFloor(Floor.UPPER);
		chapel.addFloor(Floor.GROUND);
		chapel.addType(Type.EVENT);
		chapel.addType(Type.WINDOW);
		chapel.addType(Type.TRAIT);

		//Charred Room
		charred = new Room("Charred Room","");
		charred.addExit(Direction.NORTH);
		charred.addExit(Direction.SOUTH);
		charred.addExit(Direction.EAST);
		charred.addExit(Direction.WEST);
		charred.addFloor(Floor.UPPER);
		charred.addFloor(Floor.GROUND);
		charred.addType(Type.OMEN);

		//Chasm
		chasm = new Room("Chasm","You can attempt a Speed roll of 3+ to cross. If you fail, you stop moving.");
		chasm.addExit(Direction.EAST);
		chasm.addExit(Direction.WEST);
		chasm.addFloor(Floor.BASEMENT);
		chasm.addType(Type.CROSS);

		//Coal Chute
		coal = new Room("Coal Chute", "One-way slide to Basement Landing.");
		coal.addExit(Direction.NORTH);
		coal.addFloor(Floor.GROUND);
		coal.addType(Type.MOVE);

		//Collapsed Room
		collapsed = new Room("Collapsed Room", "You must attempt a Speed roll of 5+ to avoid falling. If you fail the roll, draw a basement tile and put it in play. You fall there and take 1 die of physical damage.");
		collapsed.addExit(Direction.NORTH);
		collapsed.addExit(Direction.SOUTH);
		collapsed.addExit(Direction.EAST);
		collapsed.addExit(Direction.WEST);
		collapsed.addFloor(Floor.UPPER);
		collapsed.addFloor(Floor.GROUND);
		collapsed.addType(Type.FALL);

		//Conservatory
		conservatory = new Room("Conservatory", "");
		conservatory.addExit(Direction.NORTH);
		conservatory.addFloor(Floor.UPPER);
		conservatory.addFloor(Floor.GROUND);
		conservatory.addType(Type.EVENT);
		conservatory.addType(Type.OUTSIDE);

		//Creaky Hallway
		creaky = new Room("Creaky Hallway", "");
		creaky.addExit(Direction.NORTH);
		creaky.addExit(Direction.SOUTH);
		creaky.addExit(Direction.EAST);
		creaky.addExit(Direction.WEST);
		creaky.addFloor(Floor.UPPER);
		creaky.addFloor(Floor.GROUND);
		creaky.addFloor(Floor.BASEMENT);

		//Crypt
		crypt = new Room("Crypt","If you end your turn here, take 1 point of mental damage.");
		crypt.addExit(Direction.NORTH);
		crypt.addFloor(Floor.BASEMENT);
		crypt.addType(Type.EVENT);
		crypt.addType(Type.DRAIN);

		//Dining Room
		dining = new Room("Dining Room","");
		dining.addExit(Direction.NORTH);
		dining.addExit(Direction.EAST);
		dining.addFloor(Floor.GROUND);
		dining.addType(Type.OMEN);
		dining.addType(Type.WINDOW);

		//Dusty Hallway
		dusty = new Room("Dusty Hallway","");
		dusty.addExit(Direction.NORTH);
		dusty.addExit(Direction.SOUTH);
		dusty.addExit(Direction.EAST);
		dusty.addExit(Direction.WEST);
		dusty.addFloor(Floor.UPPER);
		dusty.addFloor(Floor.GROUND);
		dusty.addFloor(Floor.BASEMENT);

		//Furnace Room
		furnace = new Room("Furnace Room","If you end your turn here, take 1 point of physical damage.”");
		furnace.addExit(Direction.NORTH);
		furnace.addExit(Direction.SOUTH);
		furnace.addExit(Direction.WEST);
		furnace.addFloor(Floor.BASEMENT);
		furnace.addType(Type.OMEN);
		furnace.addType(Type.DRAIN);

		//Gallery
		gallery = new Room("Gallery","You can choose to fall to the Ballroom if it’s in the house. If you do, take 1 die of physical damage.");
		gallery.addExit(Direction.NORTH);
		gallery.addExit(Direction.SOUTH);
		gallery.addFloor(Floor.UPPER);
		gallery.addType(Type.OMEN);
		gallery.addType(Type.FALL);
		

		//Game Room
		gameroom = new Room("Game Room", "");
		gameroom.addExit(Direction.NORTH);
		gameroom.addExit(Direction.SOUTH);
		gameroom.addExit(Direction.EAST);
		gameroom.addFloor(Floor.UPPER);
		gameroom.addFloor(Floor.GROUND);
		gameroom.addFloor(Floor.BASEMENT);
		gameroom.addType(Type.EVENT);

		//Gardens
		gardens = new Room("Gardens","");
		gardens.addExit(Direction.NORTH);
		gardens.addExit(Direction.SOUTH);
		gardens.addFloor(Floor.GROUND);
		gardens.addType(Type.EVENT);
		gardens.addType(Type.OUTSIDE);

		//Graveyard
		graveyard = new Room("Graveyard","When exiting, you must attempt a Sanity roll of 4+. If you fail, lose 1 Knowledge (but continue moving)");
		graveyard.addExit(Direction.SOUTH);
		graveyard.addFloor(Floor.GROUND);
		graveyard.addType(Type.EVENT);
		graveyard.addType(Type.OUTSIDE);
		graveyard.addType(Type.EXIT);

		//Gymnasium
		gym = new Room("Gymnasium", "Once per game, if you end your turn here, gain 1 Speed.");
		gym.addExit(Direction.SOUTH);
		gym.addExit(Direction.EAST);
		gym.addFloor(Floor.UPPER);
		gym.addFloor(Floor.BASEMENT);
		gym.addType(Type.OMEN);
		gym.addType(Type.TRAIT);

		//Junk Room
		junk = new Room("Junk Room","When exiting, you must attempt a Might roll of 3+. If you fail, lose 1 Speed (but continue moving)");
		junk.addExit(Direction.NORTH);
		junk.addExit(Direction.SOUTH);
		junk.addExit(Direction.EAST);
		junk.addExit(Direction.WEST);
		junk.addFloor(Floor.UPPER);
		junk.addFloor(Floor.GROUND);
		junk.addFloor(Floor.BASEMENT);
		junk.addType(Type.OMEN);
		junk.addType(Type.EXIT);

		//Kitchen
		kitchen = new Room("Kitchen","");
		kitchen.addExit(Direction.NORTH);
		kitchen.addExit(Direction.EAST);
		kitchen.addFloor(Floor.GROUND);
		kitchen.addFloor(Floor.BASEMENT);
		kitchen.addType(Type.OMEN);

		//Larder
		larder = new Room("Larder","Once per game, if you end your turn here, gain 1 Might");
		larder.addExit(Direction.NORTH);
		larder.addExit(Direction.SOUTH);
		larder.addFloor(Floor.BASEMENT);
		larder.addType(Type.ITEM);
		larder.addType(Type.TRAIT);

		//Library
		library = new Room("Library","Once per game, if you end your turn here, gain 1 Knowledge.”");
		library.addExit(Direction.SOUTH);
		library.addExit(Direction.WEST);
		library.addFloor(Floor.UPPER);
		library.addFloor(Floor.GROUND);
		library.addType(Type.EVENT);
		library.addType(Type.TRAIT);

		//Master Bedroom
		master = new Room("Master Bedroom", "");
		master.addExit(Direction.NORTH);
		master.addExit(Direction.WEST);
		master.addFloor(Floor.UPPER);
		master.addType(Type.OMEN);
		master.addType(Type.WINDOW);

		//Operating Laboratory
		operating = new Room("Operating Laboratory","");
		operating.addExit(Direction.SOUTH);
		operating.addExit(Direction.EAST);
		operating.addFloor(Floor.UPPER);
		operating.addFloor(Floor.BASEMENT);
		operating.addType(Type.EVENT);

		//Organ Room
		organ = new Room("Organ Room", "");
		organ.addExit(Direction.SOUTH);
		organ.addExit(Direction.WEST);
		organ.addFloor(Floor.UPPER);
		organ.addFloor(Floor.GROUND);
		organ.addFloor(Floor.BASEMENT);
		organ.addType(Type.EVENT);

		//Patio
		patio = new Room("Patio","");
		patio.addExit(Direction.NORTH);
		patio.addExit(Direction.SOUTH);
		patio.addExit(Direction.WEST);
		patio.addFloor(Floor.GROUND);
		patio.addType(Type.EVENT);
		patio.addType(Type.OUTSIDE);
		
		//Pentagon Chamber
		pentagram = new Room("Pentagram Chamber", "When exiting, you must attempt a Knowledge roll of 4+. If you fail, lose 1 Sanity (but continue moving).");
		pentagram.addExit(Direction.EAST);
		pentagram.addFloor(Floor.BASEMENT);
		pentagram.addType(Type.OMEN);
		pentagram.addType(Type.EXIT);
		
		//Research Laboratory
		research = new Room("Research Laboratory", "");
		research.addExit(Direction.NORTH);
		research.addExit(Direction.SOUTH);
		research.addFloor(Floor.UPPER);	
		research.addFloor(Floor.BASEMENT);
		research.addType(Type.EVENT);
		
		//Servant's Quarters
		servant = new Room("Servants' Quarters","");
		servant.addExit(Direction.NORTH);
		servant.addExit(Direction.SOUTH);
		servant.addExit(Direction.EAST);
		servant.addExit(Direction.WEST);
		servant.addFloor(Floor.UPPER);
		servant.addFloor(Floor.BASEMENT);
		servant.addType(Type.OMEN);
		
		//Stairs from basement
		stairs = new Room("Stairs from Basement", "");
		stairs.addExit(Direction.SOUTH);
		stairs.addFloor(Floor.BASEMENT);
		stairs.addType(Type.UP);
		
		//Statuary Corridor
		statuary = new Room("Statuary Corridor", "");
		statuary.addExit(Direction.NORTH);
		statuary.addExit(Direction.SOUTH);
		statuary.addFloor(Floor.UPPER);
		statuary.addFloor(Floor.GROUND);
		statuary.addFloor(Floor.BASEMENT);
		statuary.addType(Type.EVENT);
		
		//Storeroom
		storeroom = new Room("Storeroom", "");
		storeroom.addExit(Direction.NORTH);
		storeroom.addFloor(Floor.UPPER);
		storeroom.addFloor(Floor.BASEMENT);
		storeroom.addType(Type.ITEM);
		
		//Tower
		tower = new Room("Tower","You can attempt a Might roll of 3+ to cross. If you fail, you stop moving.");
		tower.addExit(Direction.EAST);
		tower.addExit(Direction.WEST);
		tower.addFloor(Floor.UPPER);
		tower.addType(Type.EVENT);
		tower.addType(Type.OUTSIDE);
		tower.addType(Type.CROSS);
		
		//Underground Lake
		lake = new Room("Underground Lake","");
		lake.addExit(Direction.NORTH);
		lake.addExit(Direction.EAST);
		lake.addFloor(Floor.BASEMENT);
		lake.addType(Type.EVENT);
		
		//Upper Landing
		landing_upper = new Room("Upper Landing","");
		landing_upper.addExit(Direction.NORTH);
		landing_upper.addExit(Direction.SOUTH);
		landing_upper.addExit(Direction.EAST);
		landing_upper.addExit(Direction.WEST);
		landing_upper.addFloor(Floor.UPPER);
		landing_upper.addType(Type.DOWN);
			
		//Wine Cellar
		cellar = new Room("Wine Cellar","");
		cellar.addExit(Direction.NORTH);
		cellar.addExit(Direction.SOUTH);
		cellar.addFloor(Floor.BASEMENT);
		cellar.addType(Type.ITEM);
		
		//Start 3 panel
		grand = new Room("Grand Staircase","Leads to Upper Landing");
		grand.addExit(Direction.EAST);
		grand.addFloor(Floor.GROUND);
		grand.addType(Type.UP);
		
		foyer = new Room("Foyer","");
		foyer.addExit(Direction.NORTH);
		foyer.addExit(Direction.SOUTH);
		foyer.addExit(Direction.EAST);
		foyer.addExit(Direction.WEST);
		
		entrance = new Room("Entrance Hall", "");
		entrance.addExit(Direction.NORTH);
		entrance.addExit(Direction.SOUTH);
		entrance.addExit(Direction.WEST);
		
		door = new Room("Door","");
		
		//Blank tile
		blank = new Room("Blank","");
	}
}
