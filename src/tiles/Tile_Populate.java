package tiles;

import java.util.ArrayList;

import tiles.Room;
import tiles.Room.Direction;
import tiles.Room.Floor;
import tiles.Room.Type;
import tiles.Room_Populate;
import tiles.Tile;

public class Tile_Populate extends Room_Populate
{
	
	private String dir = "/res/tiles/";
	private String ext = ".jpg";
	Room_Populate roompop = new Room_Populate();
	
	public Tile abandoned_tile;
	public Tile attic_tile;
	public Tile balcony_tile;
	public Tile ballroom_tile;
	public Tile basement_tile;
	public Tile bedroom_tile;
	public Tile bloody_tile;
	public Tile catacombs_tile;
	public Tile chapel_tile;
	public Tile charred_tile;
	public Tile chasm_tile;
	public Tile coal_tile;
	public Tile collapsed_tile;
	public Tile creaky_tile;
	public Tile crypt_tile;
	public Tile dining_tile;
	public Tile dusty_tile;
	public Tile furnace_tile;
	public Tile gallery_tile;
	public Tile gameroom_tile;
	public Tile gardens_tile;
	public Tile graveyard_tile;
	public Tile gym_tile;
	public Tile junk_tile;
	public Tile kitchen_tile;
	public Tile larder_tile;
	public Tile library_tile;
	public Tile master_tile;
	public Tile operating_tile;
	public Tile organ_tile;
	public Tile patio_tile;
	public Tile pentagram_tile;
	public Tile research_tile;
	public Tile servant_tile;
	public Tile stairs_tile;
	public Tile statuary_tile;
	public Tile storeroom_tile;
	public Tile tower_tile;
	public Tile lake_tile;
	public Tile landing_upper_tile;
	public Tile cellar_tile;
	public Tile grand_tile;
	public Tile foyer_tile;
	public Tile entrance_tile;
	public Tile door_tile;
	public Tile blank_tile;
	private ArrayList<Tile> tileList;
	
	public Tile_Populate()
	{
		tileList = new ArrayList<Tile>() {
			{
			add(abandoned_tile);
			add(attic_tile);
			add(balcony_tile);
			add(ballroom_tile);
			add(basement_tile);
			add(bedroom_tile);
			add(bloody_tile);
			add(catacombs_tile);
			add(chapel_tile);
			add(charred_tile);
			add(chasm_tile);
			add(coal_tile);
			add(collapsed_tile);
			add(creaky_tile);
			add(crypt_tile);
			add(dining_tile);
			add(dusty_tile);
			add(furnace_tile);
			add(gallery_tile);
			add(gameroom_tile);
			add(gardens_tile);
			add(graveyard_tile);
			add(gym_tile);
			add(junk_tile);
			add(kitchen_tile);
			add(larder_tile);
			add(library_tile);
			add(master_tile);
			add(operating_tile);
			add(organ_tile);
			add(patio_tile);
			add(pentagram_tile);
			add(research_tile);
			add(servant_tile);
			add(stairs_tile);
			add(statuary_tile);
			add(storeroom_tile);
			add(tower_tile);
			add(lake_tile);
			add(landing_upper_tile);
			add(cellar_tile);
			add(grand_tile);
			add(foyer_tile);
			add(entrance_tile);
			add(door_tile);
			add(blank_tile);
			}
		};
	
	}
	
	public void populate()	
	{
		roompop.populate();
		abandoned_tile = new Tile(roompop.abandoned, dir + roompop.abandoned.getName() + ext);
		attic_tile = new Tile(roompop.attic, dir + roompop.attic.getName() + ext);
		balcony_tile = new Tile(roompop.balcony, dir + roompop.balcony.getName() + ext);
		ballroom_tile = new Tile(roompop.ballroom, dir + roompop.ballroom.getName() + ext);
		basement_tile = new Tile(roompop.basement, dir + roompop.basement.getName() + ext);
		bedroom_tile = new Tile (roompop.bedroom, dir + roompop.bedroom.getName() + ext);
		bloody_tile = new Tile (roompop.bloody, dir + roompop.bloody.getName() + ext);
		catacombs_tile = new Tile(roompop.catacombs, dir + roompop.catacombs.getName() + ext);
		chapel_tile = new Tile(roompop.chapel, dir + roompop.chapel.getName() + ext);
		charred_tile = new Tile(roompop.charred, dir + roompop.charred.getName() + ext);
		chasm_tile = new Tile(roompop.chasm, dir + roompop.chasm.getName() + ext);
		coal_tile = new Tile(roompop.coal, dir + roompop.coal.getName() + ext);
		collapsed_tile = new Tile(roompop.collapsed, dir + roompop.collapsed.getName() + ext);
		creaky_tile = new Tile(roompop.creaky, dir + roompop.creaky.getName() + ext);
		crypt_tile = new Tile(roompop.crypt, dir + roompop.crypt.getName() + ext);
		dining_tile = new Tile(roompop.dining, dir + roompop.dining.getName() + ext);
		dusty_tile = new Tile(roompop.dusty, dir + roompop.dusty.getName() + ext);
		furnace_tile = new Tile(roompop.furnace, dir + roompop.furnace.getName() + ext);
		gallery_tile = new Tile(roompop.gallery, dir + roompop.gallery.getName() + ext);
		gameroom_tile = new Tile(roompop.gameroom, dir + roompop.gameroom.getName() + ext);
		gardens_tile = new Tile(roompop.gardens, dir + roompop.gardens.getName() + ext);
		graveyard_tile = new Tile(roompop.graveyard, dir + roompop.graveyard.getName() + ext);
		gym_tile = new Tile(roompop.gym, dir + roompop.gym.getName() + ext);
		junk_tile = new Tile(roompop.junk, dir + roompop.junk.getName() + ext);
		kitchen_tile = new Tile(roompop.kitchen, dir + roompop.kitchen.getName() + ext);
		larder_tile = new Tile(roompop.larder, dir + roompop.larder.getName() + ext);
		library_tile = new Tile(roompop.library, dir + roompop.library.getName() + ext);
		master_tile = new Tile(roompop.master, dir + roompop.master.getName() + ext);
		operating_tile = new Tile(roompop.operating, dir + roompop.operating.getName() + ext);
		organ_tile = new Tile(roompop.organ, dir + roompop.organ.getName() + ext);
		patio_tile = new Tile(roompop.patio, dir + roompop.patio.getName() + ext);
		pentagram_tile = new Tile(roompop.pentagram, dir + roompop.pentagram.getName() + ext);
		research_tile = new Tile(roompop.research, dir + roompop.research.getName() + ext); 
		servant_tile = new Tile(roompop.servant, dir + roompop.servant.getName() + ext);
		stairs_tile = new Tile(roompop.stairs, dir + roompop.stairs.getName() + ext);
		statuary_tile = new Tile(roompop.statuary, dir + roompop.statuary.getName() + ext);
		storeroom_tile = new Tile(roompop.storeroom, dir + roompop.storeroom.getName() + ext);
		tower_tile = new Tile(roompop.tower, dir + roompop.tower.getName() + ext);
		lake_tile = new Tile(roompop.lake, dir + roompop.lake.getName() + ext);
		landing_upper_tile = new Tile(roompop.landing_upper, dir + roompop.landing_upper.getName() + ext);
		cellar_tile = new Tile(roompop.cellar, dir + roompop.cellar.getName() + ext);
		grand_tile = new Tile(roompop.grand, dir + roompop.grand.getName() + ext);
		foyer_tile = new Tile(roompop.foyer, dir + roompop.foyer.getName() + ext);;
		entrance_tile = new Tile(roompop.entrance, dir + roompop.entrance.getName() + ext);;
		door_tile = new Tile(roompop.door, dir + roompop.door.getName() + ".png");;
		blank_tile = new Tile(roompop.blank, dir + roompop.blank.getName() + ".png");
		
		tileList = new ArrayList<Tile>() {
			{
			add(abandoned_tile);
			add(attic_tile);
			add(balcony_tile);
			add(ballroom_tile);
			add(bedroom_tile);
			add(bloody_tile);
			add(catacombs_tile);
			add(chapel_tile);
			add(charred_tile);
			add(chasm_tile);
			add(coal_tile);
			add(collapsed_tile);
			add(creaky_tile);
			add(crypt_tile);
			add(dining_tile);
			add(dusty_tile);
			add(furnace_tile);
			add(gallery_tile);
			add(gameroom_tile);
			add(gardens_tile);
			add(graveyard_tile);
			add(gym_tile);
			add(junk_tile);
			add(kitchen_tile);
			add(larder_tile);
			add(library_tile);
			add(master_tile);
			add(operating_tile);
			add(organ_tile);
			add(patio_tile);
			add(pentagram_tile);
			add(research_tile);
			add(servant_tile);
			add(stairs_tile);
			add(statuary_tile);
			add(storeroom_tile);
			add(tower_tile);
			add(lake_tile);	
			add(cellar_tile);
			}
		};
	}
	
	public ArrayList<Tile> getTileList()
	{
		return tileList;
	}
}
