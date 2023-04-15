package crm;

import java.util.ArrayList;

public class Player {

	protected String name;
	
	protected Tableu playerTableu;

	protected ArrayList<Card> hand;   // indexed from 0 in the code. Indexed from 1 for the view e.g. player enters 1 for first card.
	private ArrayList<Card> compost;

	private int soil;
	//private Card ecosystemCard;
	//private Card islandCard;
	//private Card climateCard;
	private boolean firstPlayer;			// Will probably be removed. Player order should be managed by the game loop
	private boolean activePlayer;
	private int victoryPoints;
	//private boolean greenAbility;
	//private boolean orangeAbility;
	//private boolean blueAbility;
	//private boolean yellowAbility;

	public Player(EarthDeck gameDeck) {
		setName("");
		playerTableu = new Tableu();
		hand = new ArrayList<Card>();
		compost = new ArrayList<Card>();
		drawCard(gameDeck);
		drawCard(gameDeck);
		drawCard(gameDeck);
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
		setName("");
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

	public int handSize() {
		return hand.size();
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

	public boolean playCard(Card chosenCard, int spot) {	// Spot 1-16. 1 in top left, 16 in bottom right.
		return playCard(chosenCard, (spot - 1) / 4, (spot - 1) % 4);
	}
	
	public void addToHand(Card c) {
		hand.add(c);
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
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
}
