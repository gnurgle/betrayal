/*
 * 
 * Links Character to a Token to be drawn on the board 
 * 
 */

package actors;

import javax.swing.ImageIcon;
import tiles.Room.Direction;

public class Token {

private Characters character;
private String name;
private Direction facing;
private ImageIcon icon;
;
private int x;
private int y;
private int roomx;
private int roomy;

//Character Token
public Token(Characters character)
{
	this.character = character;
	this.name = character.getfName(); 
	this.facing = Direction.NORTH;
	this.icon = character.getTokenIcon();
}

//Blank Token
public Token()
{
	this.name = "Blank";
	this.icon = new ImageIcon(getClass().getResource("/res/objects/block.png"));
}

//Set and get methods
public Characters getCharacter() {
	return character;
}

public void setCharacter(Characters character) {
	this.character = character;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public ImageIcon getIcon() {
	return icon;
}

public void setIcon(ImageIcon icon) {
	this.icon = icon;
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

public Direction getFacing() {
	return facing;
}

public int getRoomx() {
	return roomx;
}

public void setRoomx(int roomx) {
	this.roomx = roomx;
}

public int getRoomy() {
	return roomy;
}

public void setRoomy(int roomy) {
	this.roomy = roomy;
}



}
