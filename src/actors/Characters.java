/**
 * 
 * stores all relevent character information and 
 * severl helper methods
 * 
 */

package actors;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import game.Dice;
import game.Items;
import game.Omens;

public class Characters extends Actors
{
	//Array of stats
	protected int[] statMight;
	protected int[] statSpeed;
	protected int[] statSanity;
	protected int[] statKnowledge;
	
	//Character information
	protected String fName;		//first name
	protected String lName;		//last name
	protected String bDay;		//Birthday
	protected int age;			//Age
	protected int height;			//Height
	protected int weight;			//Weight
	protected String hobby1;		//Hobbies
	protected String hobby2;
	protected String hobby3;
	protected int playerNum;		//Player Number
	protected ImageIcon icon;		//Icon for Character
	protected ImageIcon deadicon;	//Icon for dead player
	protected ImageIcon tokenIcon;		//token icon
	
	//Starting stats
	protected int startMight;
	protected int startSpeed;
	protected int startSanity;
	protected int startKnowledge;
	
	//For Sound Bites
	protected String soundPre;
	//Carrying Items
	protected ArrayList<Items> items = new ArrayList<Items>();
	protected ArrayList<Omens> omens = new ArrayList<Omens>();
	protected ArrayList<Integer> weapons;
	
	//List of turn used items and omens;
	protected ArrayList<Boolean> usedItems;
	protected ArrayList<Boolean> usedOmens;
	
	private Dice dice;
	//Internal tracker for haunt.
	private boolean hauntActive = false;
	
	//Used for easier character construction with setters
	public Characters()
	{
		this.fName = "Blank";
	}
	
	//Initialize Player
	public Characters(int[] statMight, int[] statSpeed, int[] statSanity, int[] statKnowledge, String fName, String lName, String bDay, int age, int height, int weight, String hobby1, String hobby2, String hobby3, int startMight, int startSpeed, int startSanity, int startKnowledge, String soundPre)
	{
		this.statMight = statMight;
		this.statSpeed = statSpeed;
		this.statSanity = statSanity;
		this.statKnowledge = statKnowledge;
		this.fName = fName;
		this.lName = lName;
		this.bDay = bDay;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.hobby1 = hobby1;
		this.hobby2 = hobby2;
		this.hobby3 = hobby3;
		
		this.startMight = startMight;
		this.startSpeed = startSpeed;
		this.startSanity = startSanity;
		this.startKnowledge = startKnowledge;
		icon = new ImageIcon(getClass().getResource("/res/player/" + fName + ".png"));
		tokenIcon = new ImageIcon(getClass().getResource("/res/tokens/" + fName + ".png"));
		
		
		might = startMight;
		speed = startSpeed;
		sanity = startSanity;
		knowledge = startKnowledge;
		this.soundPre = soundPre;
		
		this.dice = new Dice();
		
	}
	
	//Change icon once dead
	public void setDeadIcon()
	{
		icon = new ImageIcon(getClass().getResource("/res/player/" + fName + "_dead.png"));
	}

	public int getMight()
	{
		return statMight[might];
	}
	public int getSanityt()
	{
		return statSanity[sanity];
	}
	public int getSpeed()
	{
		return statSpeed[speed];
	}
	public int getKnowledge()
	{
		return statKnowledge[knowledge];
	}
	public int getMightStat()
	{
		return might;
	}
	public int getSanitytStat()
	{
		return sanity;
	}
	public int getSpeedStat()
	{
		return speed;
	}
	public int getKnowledgeStat()
	{
		return knowledge;
	}
	
	public int[] getStatMight() {
		return statMight;
	}

	public void setStatMight(int[] statMight) {
		this.statMight = statMight;
	}

	public int[] getStatSpeed() {
		return statSpeed;
	}

	public void setStatSpeed(int[] statSpeed) {
		this.statSpeed = statSpeed;
	}

	public int[] getStatSanity() {
		return statSanity;
	}

	public void setStatSanity(int[] statSanity) {
		this.statSanity = statSanity;
	}

	public int[] getStatKnowledge() {
		return statKnowledge;
	}

	public void setStatKnowledge(int[] statKnowledge) {
		this.statKnowledge = statKnowledge;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getbDay() {
		return bDay;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getHobby1() {
		return hobby1;
	}

	public void setHobby1(String hobby1) {
		this.hobby1 = hobby1;
	}

	public String getHobby2() {
		return hobby2;
	}

	public void setHobby2(String hobby2) {
		this.hobby2 = hobby2;
	}

	public String getHobby3() {
		return hobby3;
	}

	public void setHobby3(String hobby3) {
		this.hobby3 = hobby3;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	
	public ImageIcon getImageIcon() {
		return icon;
	}

	public void setImageIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public int getStartMight() {
		return startMight;
	}

	public void setStartMight(int startMight) {
		this.startMight = startMight;
	}

	public int getStartSpeed() {
		return startSpeed;
	}

	public void setStartSpeed(int startSpeed) {
		this.startSpeed = startSpeed;
	}

	public int getStartSanity() {
		return startSanity;
	}

	public void setStartSanity(int startSanity) {
		this.startSanity = startSanity;
	}

	public int getStartKnowledge() {
		return startKnowledge;
	}

	public void setStartKnowledge(int startKnowledge) {
		this.startKnowledge = startKnowledge;
	}

	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}
	
	public void addItems(Items item)
	{
		this.items.add(item);
	}

	public void removeItems(Items item)
	{
		this.items.remove(item);
	}
	public ArrayList<Omens> getOmens() {
		return omens;
	}

	public void setOmens(ArrayList<Omens> omens) {
		this.omens = omens;
	}
	
	public void addOmens(Omens omen)
	{
		this.omens.add(omen);
	}
	
	public void removeOmens(Omens omen)
	{
		this.omens.remove(omen);
	}
	public ArrayList<Integer> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Integer> weapons) {
		this.weapons = weapons;
	}

	public ArrayList<Boolean> getUsedItems() {
		return usedItems;
	}

	public void setUsedItems(ArrayList<Boolean> usedItems) {
		this.usedItems = usedItems;
	}

	public ArrayList<Boolean> getUsedOmens() {
		return usedOmens;
	}

	public void setUsedOmens(ArrayList<Boolean> usedOmens) {
		this.usedOmens = usedOmens;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public ImageIcon getTokenIcon() {
		return tokenIcon;
	}

	public void setTokenIcon(ImageIcon tokenIcon) {
		this.tokenIcon = tokenIcon;
	}

	public String getSoundPre() {
		return soundPre;
	}

	public void setSoundPre(String soundPre) {
		this.soundPre = soundPre;
	}
	
	
	public void setHauntActive(boolean hauntActive) {
		this.hauntActive = hauntActive;
	}

	//Overwrites
	public void decrementSpeed()
	{
		if (speed > 0 && hauntActive)
			speed--;
		else if (speed > 1)
			speed--;
		injured = true;
	}
	
	public void decrementMight()
	{
		if (might > 0 && hauntActive)
			might--;
		else if (might > 1)
			might--;
		injured = true;
	}
	
	public void decrementSanity()
	{
		if (sanity > 0 && hauntActive)
			sanity--;
		else if (sanity > 1)
			sanity--;
		injured = true;
	}
	
	public void decrementKnowledge()
	{
		if (knowledge > 0 && hauntActive)
			knowledge--;
		else if (knowledge > 1)
			knowledge--;
		injured = true;
	}
	
	
	//Internal luck rolls
	public int traitRoll(int value)
	{
		int subtotal = 0;
		for (int i = 0; i < value; ++i)
		{
			subtotal += dice.roll();
		}
		
		return subtotal;
	}
	
	
	
	
}
