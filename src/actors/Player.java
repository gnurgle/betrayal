/*
 * 
 * This links a character to individual players.
 * 
 */ 
package actors;


import game.SoundEffect;

public class Player{

	
	private Characters character;			//Character player is playing as
	private Token token;					//Token on board
	private int playerNum;					//Player number
	
	//Persistent traits for edge cases
	
	//Marker for stat rooms
	private boolean gainedKnowledge = false;
	private boolean gainedMight = false;
	private boolean gainedSpeed = false;
	private boolean gainedSanity = false;
	private boolean dead = false;
	private boolean checkedDead = false;
	
	//Item
	private boolean hasAmulet = false;
	private boolean hasRevlover = false;
	public Player(Characters chara, Token tok, int num)
	{
		//Copy all stats from Character
		this.character = chara;
		this.token = tok;
		this.playerNum = num;
	}
	public Characters getCharacter() {
		return character;
	}
	public void setCharacter(Characters character) {
		this.character = character;
	}
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	
	//Sound Effect Calls
	public void playIntro()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_INTRO_1").play();
	}
	public void playIntro2()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_INTRO_2").play();
	}
	
	public void playEvent()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_EVENT_1").play();
	}
	public void playOmen()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_OMEN_1").play();
	}
	public void playItem()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_ITEM_1").play();
	}
	public void playHurt()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_HURT_1").play();
	}
	public void playHeal()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_HEAL_1").play();
	}
	public void playFall()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_FALL_1").play();
	}
	public void playLowPhys()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_LOW_PHYS").play();
	}
	public void playLowMent()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_LOW_MENT").play();
	}
	public void playDeath()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_DEATH").play();
	}
	public void playHmm()
	{
		SoundEffect.valueOf(character.getSoundPre()+"_HMM").play();
	}
	public boolean isGainedKnowledge() {
		return gainedKnowledge;
	}
	public void setGainedKnowledge(boolean gainedKnowledge) {
		this.gainedKnowledge = gainedKnowledge;
	}
	public boolean isGainedMight() {
		return gainedMight;
	}
	public void setGainedMight(boolean gainedMight) {
		this.gainedMight = gainedMight;
	}
	public boolean isGainedSpeed() {
		return gainedSpeed;
	}
	public void setGainedSpeed(boolean gainedSpeed) {
		this.gainedSpeed = gainedSpeed;
	}
	public boolean isGainedSanity() {
		return gainedSanity;
	}
	public void setGainedSanity(boolean gainedSanity) {
		this.gainedSanity = gainedSanity;
	}
	public boolean isHasAmulet() {
		return hasAmulet;
	}
	public void setHasAmulet(boolean hasAmulet) {
		this.hasAmulet = hasAmulet;
	}
	public boolean isHasRevlover() {
		return hasRevlover;
	}
	public void setHasRevlover(boolean hasRevlover) {
		this.hasRevlover = hasRevlover;
	}
	public void setHauntActive(boolean value) {
		this.character.setHauntActive(value);
	}
	//Check death state
	public boolean isDead()
	{
		
		if (character.getMight() == 0)
			dead = true;
		else if (character.getSpeed() == 0)
			dead = true;
		else if (character.getSanity() == 0)
			dead = true;
		else if (character.getKnowledge() == 0)
			dead = true;
		
		return dead;
	}
	public boolean getCheckedDead() {
		return checkedDead;
	}
	public void setCheckedDead(boolean checkedDead) {
		this.checkedDead = checkedDead;
	}
	
	
}
