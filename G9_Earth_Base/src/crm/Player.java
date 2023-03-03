package crm;

import java.util.ArrayList;

public class Player {

	private Card[][] island_board = new Card[4][4];
	private ArrayList<Card> hand;
	private int soilToken;
	private int leafToken;
	private Card ecosystemCard;
	private Card islandCard;
	private Card climateCard;
	private boolean firstPlayer;
	private boolean activePlayer;
	private int victoryPoints;
	
	public Player() {
		island_board = null;
		hand = new ArrayList<Card>();
		
	}

}
