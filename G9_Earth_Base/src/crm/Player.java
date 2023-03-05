package crm;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private Tableu playerTableu;
	protected ArrayList<Card> hand;
	//private int soilToken;
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
    	//soilToken = 0;
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
    	//soilToken = 0;
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

	public void playCard() {
		Card tempCard;
		int chooseCard = -1;
		Scanner input = new Scanner(System.in);

		if (hand.size() > 0){
			System.out.println("Choose a card to play from your hand");
			System.out.println("------------------------------------");
			DisplayHand();
			System.out.println("------------------------------------");
			System.out.print("Select Card (1-" + hand.size() + "): ");
			chooseCard = input.nextInt() - 1;
			input.nextLine();
			tempCard = hand.remove(chooseCard);
			//System.out.println("chooseCard: " + chooseCard);

			playerTableu.placeCard(tempCard);
			adjustVP(1);
		}
		else{
			System.out.println("No cards in hand.");
		}
		
		input.close();
	}
	
	/*public void addSoilTokens(int amtSoil) {
		soilToken += amtSoil;
	}
	
	public int getSoilTokens() {
		return soilToken;
	}*/
	
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
}
