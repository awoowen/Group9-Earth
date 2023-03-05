package crm;

import java.util.ArrayList;

public class Player {

	private Tableu playerTableu;
	protected ArrayList<Card> hand;
	private int soil;
	//private int leafToken;
	//private Card ecosystemCard;
	//private Card islandCard;
	//private Card climateCard;
	private boolean firstPlayer;
	private boolean activePlayer;
	private int victoryPoints;

	public Player(EarthDeck gameDeck) {
		playerTableu = new Tableu();
		hand = new ArrayList<Card>();
		DrawCard(gameDeck);
    	soil = 0;
		//leafToken = 5;
		//ecosystemCard = null;
		//islandCard = null;
		//climateCard = null;
		setFirstPlayer(false);
		setActivePlayer(false);
		setVictoryPoints(0);
	}

	public Player() {
		hand = new ArrayList<Card>();
    	soil = 0;
		//leafToken = 5;
		//ecosystemCard = null;
		//islandCard = null;
		//climateCard = null;
		setFirstPlayer(false);
		setActivePlayer(false);
		setVictoryPoints(0);
	}
	
	public void DrawCard(EarthDeck gameDeck) {
		hand.add(gameDeck.dealTopEarthCard());
	}

	public void DisplayHand() {
		int x = 0;
		for (Card handCards : hand) {
			x += 1;
			System.out.println(x + ": " + handCards.getName());
		}
	}

	public void playCard(Card chosenCard, int row, int col) {
		playerTableu.placeCard(chosenCard, row, col);
		adjustVP(1);
	}
	
	public boolean isFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(boolean isFirst) {
		firstPlayer = isFirst;
	}

	public boolean isActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(boolean isActive) {
		activePlayer = isActive;
	}

	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int vp) {
		victoryPoints = vp;
	}
	
	public void adjustVP(int amtVP) {
		setVictoryPoints(getVictoryPoints() + amtVP);
	}
	
	public void setSoil() {
		soil = 1000;
	}
	
	public void adjustSoil(int amtSoil) {
		if(soil + amtSoil <= 0) {
			setSoil();
			soil += amtSoil;
		} else {
			soil += amtSoil;
		}
	}
	
	public int getSoil() {
		return soil;
	}
}
