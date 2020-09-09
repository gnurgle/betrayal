/**
 * 
 * Manages the behind the scenes of turns
 * 
 */

package game;

import java.util.ArrayList;

import actors.Player;

public class TurnSystem {

	private Player currentPlayer;
	private Player currentTraitor;
	private int numPlayers;
	private int currentNum;
	private int turnNum;
	private ArrayList<Player> playerList;
	
	public TurnSystem(int num)
	{
		//Set number of players
		this.numPlayers = num;
		playerList = new ArrayList<Player>();
	}

	public void addPlayer(Player p)
	{
		playerList.add(p.getPlayerNum()-1, p);
	}
	
	//Called to start the game
	public void startTurns()
	{
		currentPlayer = playerList.get(numPlayers-1);
		currentNum = numPlayers-1;
		turnNum = 0;
	}
	
	//end of turn cleanup
	public void endTurn(boolean end)
	{
		currentNum++;
		currentNum = currentNum%numPlayers;
		currentPlayer = playerList.get(currentNum);
		if (currentPlayer.getCheckedDead())
			endTurn(end);
		else if (currentPlayer.getCharacter().getMightStat() == 1 || currentPlayer.getCharacter().getSpeedStat() == 1)
			currentPlayer.playLowPhys();
		else if (currentPlayer.getCharacter().getSanitytStat() == 1 || currentPlayer.getCharacter().getKnowledgeStat() == 1)
			currentPlayer.playLowMent();
		else
		{
			if (!end)
				currentPlayer.playIntro();
		}
	}
	
	public Player getPlayer(int num)
	{
		return playerList.get(num);
	}
	//Getters and Setters
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public int getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}

	public int getTurnNum() {
		return turnNum;
	}

	public void setTurnNum(int turnNum) {
		this.turnNum = turnNum;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public Player getCurrentTraitor() {
		return currentTraitor;
	}

	public void setCurrentTraitor(Player currentTraitor) {
		this.currentTraitor = currentTraitor;
	}
	
	
	
	
}
