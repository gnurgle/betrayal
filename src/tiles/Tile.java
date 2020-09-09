package tiles;
import javax.swing.ImageIcon;

public class Tile {
	
	private Room room;		//Room information for tile
	private int x;			//Tile location(x) in array for board
	private int y;			//Tile location(y) in array for board
	private String image;	//Tile image location for ImageIcon
	private ImageIcon icon;	//Tile ImageIcon
	private String name;
	
	//private Token[] drawSpace; //Used to keep track of what's on tile
	public Tile(Room room, String image)
	{
		this.room = room;
		this.x = 0;
		this.y = 0;
		this.image = image;
		icon = new ImageIcon(getClass().getResource(image));
		this.name = (room.getName());
		
	}
	
	public Tile(Room room, int x, int y, String image)
	{
		this.room = room;
		this.x = x;
		this.y = y;
		this.image = image;
		icon = new ImageIcon(getClass().getResource(image));
		this.name = (room.getName());
		
	}
	//get methods
	
	public Room getRoom()
	{
		return room;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public String getImage()
	{
		return image;
	}
	
	public ImageIcon getImageIcon()
	{
		return icon;
	}
	
	public int getWidth()
	{
		return icon.getIconWidth();
	}
	
	public int getHeight()
	{
		return icon.getIconHeight();
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
