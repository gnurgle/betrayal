/**
 * 
 * This populates a list of avaliable characters with their values
 * to be used with Player
 * 
 */
package actors;

public class Character_Populate {

	public Characters darrin;
	public Characters ox;
	public Characters zoe;
	public Characters missy;
	public Characters brandon;
	public Characters peter;
	public Characters zostra;
	public Characters vivian;
	public Characters jenny;
	public Characters heather;
	public Characters rhinehardt;
	public Characters longfellow;
	public Characters blank;

	public Character_Populate()
	{
	}
	
	public void populate()
	{
	//Character constructor order
	//int[] statMight, int[] statSpeed, int[] statSanity, int[] statKnowledge, String fName, 
	//String lName, String bDay, int age, int height, int weight, String hobby1, String hobby2, 
	//String hobby3, int playerNum, int startMight, int startSpeed, int startSanity, 
	//int startKnowledge, ImageIcon icon
		
	darrin = new Characters(new int[]{0,2,3,3,4,5,6,6,7}, new int[]{0,4,4,4,5,6,7,7,8}, new int[] {0,1,2,3,4,5,5,5,7}, new int[] {0,2,3,3,4,5,5,5,7},
			"Darrin", "\"Flash\"Williams", "June 6th", 20, 71, 188, "Track", "Music", "Shakespearean Lit.",
			3,5,3,3,"JOCK");
	
	ox = new Characters(new int[] {0,4,5,5,6,6,7,8,8}, new int[] {0,2,2,2,3,4,5,5,6}, new int[] {0,2,2,3,4,5,5,6,7}, new int[] {0,2,2,3,3,5,5,6,6},
			"Ox", "Bellows", "Oct. 18th", 23, 76, 288, "Football", "Shiny Objects", "",
			3,5,3,3, "JOCK");
	zoe = new Characters(new int[] {0,2,2,3,3,4,4,6,7}, new int[] {0,4,4,4,4,5,6,8,8}, new int[] {0,3,4,5,5,6,6,7,8}, new int[] {0,1,2,3,4,4,5,5,5},
			"Zoe", "Ingstrom", "Nov 5th", 8, 47, 49, "Dolls", "Music", "", 
			4,4,3,3, "GIRL");
	missy =	new Characters(new int[] {0,2,3,3,3,4,5,6,7}, new int[] {0,3,4,5,6,6,6,7,7}, new int[] {0,1,2,3,4,5,5,6,7}, new int[] {0,2,3,4,4,5,6,6,6},
			"Missy", "Dubourde", "Feb. 14", 9, 50, 62, "Swimming", "Medicine", "",
			4,3,3,4, "GIRL");
	brandon = new Characters(new int[] {0,2,3,3,4,5,6,6,7}, new int[] {0,3,4,4,4,5,6,7,8}, new int[] {0,3,3,3,4,5,6,7,8}, new int[] {0,1,3,3,5,5,6,6,7},
			"Brandon","Jasper", "May 21st", 12, 61, 109, "Computers", "Camping", "Hockey", 
			3,4,4,3, "BOY");
	peter = new Characters(new int[] {0,2,3,3,4,5,5,6,8}, new int[] {0,3,3,3,4,6,6,7,7}, new int[] {0,3,4,4,4,5,6,6,7}, new int[] {0,3,4,4,5,6,7,7,8},
			"Peter", "Akimoto", "Sept. 3rd", 13, 59, 98, "Bugs", "Basketball", "",
			3,4,4,3, "BOY");
	zostra = new Characters(new int[] {0,2,3,3,4,5,5,5,6}, new int[] {0,2,3,3,5,5,6,6,7}, new int[] {0,4,4,4,5,6,7,8,8}, new int[] {0,1,3,4,4,4,5,6,6},
			"Madame", "Zostra", "Dec. 10th", 37, 60, 150, "Astrology", "Cooking", "Baseball",
			4,3,3,4, "WOMAN");
	vivian = new Characters(new int[] {0,2,2,2,4,4,5,6,6}, new int[] {0,3,4,4,4,4,6,7,8}, new int[] {0,4,4,4,5,6,7,8,8}, new int[] {0,4,5,5,5,5,6,6,7},
			"Vivian", "Lopez", "Jan. 11th", 42, 65, 142, "Old Movies", "Horses", "",
			3,4,3,4, "WOMAN");
	jenny = new Characters(new int[] {0,3,4,4,4,4,5,6,8}, new int[] {0,2,3,4,4,4,5,6,8}, new int[] {0,1,1,2,4,4,4,5,6}, new int[] {0,2,3,3,4,4,5,6,8},
			"Jenny", "LeClerc", "Mar. 4th", 21, 67, 142, "Reading", "Soccer", "",
			3,4,5,3, "CHEER");
	heather = new Characters(new int[] {0,3,3,3,4,5,6,7,8}, new int[] {0,3,3,4,5,6,6,7,8}, new int[] {0,3,3,3,4,5,6,6,6}, new int[] {0,2,3,3,4,5,6,7,8},
			"Heather", "Granville", "Aug. 2nd", 18, 62, 120, "Television", "Shopping","",
			3,3,3,5, "CHEER");
	rhinehardt = new Characters(new int[] {0,1,2,2,4,4,5,5,7}, new int[] {0,2,3,3,4,5,6,7,7}, new int[] {0,3,4,5,5,6,7,7,8}, new int[] {0,1,3,3,4,5,6,6,8},
			"Father", "Rhinehardt", "April 29th", 62, 69, 185, "Fencing", "Gardening", "",
			3,3,5,4, "OLD");
	longfellow = new Characters(new int[] {0,1,2,3,4,5,5,6,6}, new int[] {0,2,2,4,4,5,5,6,6}, new int[] {0,1,3,3,4,5,5,6,7}, new int[] {0,4,5,5,5,5,6,7,8},
			"Professor", "Longfellow", "July 27th", 57, 71, 153, "Gaelic Music", "Drama", "Fine Wines",
			3,4,3,5, "OLD");
	
	blank = new Characters(); //empty Character slot
	}
	
}

