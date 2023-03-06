package crm;

import java.util.ArrayList;

public class Player {

	private Tableu playerTableau;
	protected ArrayList<Card> hand;
	private ArrayList<Card> compost;
	private int soil;
	//private int leaf;
	//private Card ecosystemCard;
	//private Card islandCard;
	//private Card climateCard;
	private boolean firstPlayer;
	private boolean activePlayer;
	private int victoryPoints;

	public Player(EarthDeck gameDeck) {
		playerTableau = new Tableu();
		hand = new ArrayList<Card>();
		compost = new ArrayList<Card>();
		DrawCard(gameDeck);
    	setSoil(0);
		//setLeaf();
		//ecosystemCard = null;
		//islandCard = null;
		//climateCard = null;
		setFirstPlayer(false);
		setActivePlayer(false);
		setVictoryPoints(0);
	}

	public Player() {
		playerTableau = new Tableu();
		hand = new ArrayList<Card>();
		compost = new ArrayList<Card>();
		setSoil(0);
		//setLeaf();
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

	public boolean playCard(Card chosenCard, int row, int col) {
		if(playerTableau.placeCard(chosenCard, row, col)) {
			adjustVP(chosenCard.getBasePointValue());
			soil -= chosenCard.getSoilCost();
			hand.remove(chosenCard);
			return true;
		} else {
			return false;
		}
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
