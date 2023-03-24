package crm;

import java.util.ArrayList;

public class Player {

	protected Tableu playerTableu;
	protected ArrayList<Card> hand;
	private ArrayList<Card> compost;
	private int soil;
	//private Card ecosystemCard;
	//private Card islandCard;
	//private Card climateCard;
	private boolean firstPlayer;
	private boolean activePlayer;
	private int victoryPoints;
	//private boolean greenAbility;
	//private boolean orangeAbility;
	//private boolean blueAbility;
	//private boolean yellowAbility;

	public Player(EarthDeck gameDeck) {
		playerTableu = new Tableu();
		hand = new ArrayList<Card>();
		compost = new ArrayList<Card>();
		drawCard(gameDeck);
    	setSoil(1000);
		//ecosystemCard = null;
		//islandCard = null;
		//climateCard = null;
		setFirstPlayer(false);
		setActivePlayer(false);
		setVictoryPoints(0);
	}

	public Player() {
		playerTableu = new Tableu();
		hand = new ArrayList<Card>();
		compost = new ArrayList<Card>();
		setSoil(1000);
		//ecosystemCard = null;
		//islandCard = null;
		//climateCard = null;
		setFirstPlayer(false);
		setActivePlayer(false);
		setVictoryPoints(0);
	}
	
	public void drawCard(EarthDeck gameDeck) {
		hand.add(gameDeck.dealTopEarthCard());
	}

	public boolean playCard(Card chosenCard, int row, int col) {
		if(playerTableu.placeCard(chosenCard, row, col) == true) {
			adjustVP(chosenCard.getBasePointValue());
			soil -= chosenCard.getSoilCost();
			hand.remove(chosenCard);
			return true;
		} else {
			return false;
		}
	}
	
	public void compostCard(Card chosenCard) {
		compost.add(chosenCard);
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
		victoryPoints += amtVP;
	}
	
	public void setSoil(int amtSoil) {
		soil = amtSoil;
	}
	
	public void addSoil(int amtSoil) {
		soil += amtSoil;
	}
	
	public void removeSoil(int amtSoil) {
		soil -= amtSoil;
	}
	
	public int getSoil() {
		return soil;
	}
	
	public Tableu getTableu() {
		return playerTableu;
	}
	
	public Card getCardFromHand(int index) {
		return hand.get(index);
	}
}
