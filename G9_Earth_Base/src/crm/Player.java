package crm;

import java.util.ArrayList;

public class Player {

	protected Tableu playerTableu;
	protected ArrayList<Card> hand;			// indexed from 0 in the code. Indexed from 1 for the view e.g. player enters 1 for first card.
	//private ArrayList<Card> compost;
	private int soil;
	//private int leaf;
	//private Card ecosystemCard;
	//private Card islandCard;
	//private Card climateCard;
	private boolean firstPlayer;			// Will probably be removed. Player order should be managed by the game loop
	private boolean activePlayer;
	private int victoryPoints;

	public Player(EarthDeck gameDeck) {
		playerTableu = new Tableu();
		hand = new ArrayList<Card>();
		//compost = new ArrayList<Card>();
		drawCard(gameDeck);
    	setSoil(1000);
		//setLeaf();
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
		//compost = new ArrayList<Card>();
		setSoil(1000);
		//setLeaf();
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
			//System.out.println("Successfully placed card.");
			return true;
		} else {
			//System.out.println("Failed to place card.");
			return false;
		}
	}

	public boolean playCard(Card chosenCard, int spot) {	// Spot 1-16. 1 in top left, 16 in bottom right.
		return playCard(chosenCard, (spot - 1) / 4, (spot - 1) % 4);
	}
	
	public void addToHand(Card c) {
		hand.add(c);
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
	
	public void setSoil(int amtSoil) {
		soil = amtSoil;
	}
	
	public void adjustSoil(int amtSoil) {
		soil += amtSoil;
	}
	
	public int getSoil() {
		return soil;
	}
	
	public Tableu getTableu() {
		return playerTableu;
	}

	/*public int getLeaf() {
		return leaf;
	}

	public void useLeaf() {
		leaf = getLeaf() - 1;
	}
	
	public void setLeaf() {
		leaf = 4;
	}*/
}
