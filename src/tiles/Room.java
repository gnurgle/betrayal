package tiles;

import java.util.ArrayList;
import java.util.Set;
import java.util.EnumSet;


public class Room 
{
	
	protected String name;					//room name
	protected String description;			//Room Description
	protected EnumSet<Direction> exits;			//Exit directions
	protected EnumSet<Direction> window;		//Window direction
	protected Direction orientation;	//Facing of room
	protected EnumSet<Floor> floor;				//Floor room can be on
	protected EnumSet<Type>	type;				//Room attributes
	
	public enum Direction {NORTH, EAST, SOUTH, WEST, INIT};
	public enum Floor {BASEMENT, GROUND, UPPER, ATTIC, INIT};
	public enum Type {EVENT, ITEM, OMEN, TRAIT, ROLL, DUMB, UP, DOWN, OUTSIDE, WINDOW, VAULT, EXIT, CROSS, MOVE, FALL, DRAIN, INIT};
	
	
	public Room(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.exits = EnumSet.noneOf(Direction.class);
		this.window = EnumSet.noneOf(Direction.class);
		this.orientation = Direction.NORTH;
		this.floor = EnumSet.noneOf(Floor.class);
		this.type = EnumSet.noneOf(Type.class);
	}
	
	public Room()
	{
		this.name = "Blank";
	}
	//Add methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EnumSet<Direction> getExits() {
		return exits;
	}

	public void addExit(Direction dir) {
		this.exits.add(dir);
	}

	public EnumSet<Direction> getWindow() {
		return window;
	}

	public void setWindow(EnumSet<Direction> window) {
		this.window = window;
	}

	public Direction getOrientation() {
		return orientation;
	}

	public void setOrientation(Direction orientation) {
		this.orientation = orientation;
	}

	public EnumSet<Floor> getFloor() {
		return floor;
	}

	public void addFloor(Floor f) {
		this.floor.add(f);
	}

	public EnumSet<Type> getType() {
		return type;
	}

	public void addType(Type t) {
		this.type.add(t);
	}

}
