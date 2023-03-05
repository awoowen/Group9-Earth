package crm;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private Card[][] island_board = new Card[4][4];
	protected ArrayList<Card> hand;
	private int soilToken;
	private int leafToken;
	private Card ecosystemCard;
	private Card islandCard;
	private Card climateCard;
	private boolean firstPlayer;
	private boolean activePlayer;
	private int victoryPoints;

	private int chooseCard;
	private final static Scanner stdin = new Scanner(System.in);

	public Player(CardAmericanSycamore card) {
//		island_board = null;
		hand = new ArrayList<Card>();

		DrawCards();

	}

	public void DrawCards() {
		for(int i = 0; i < 16; i++) {
			hand.add(EarthDeck.dealTopEarthCard());
		}
	}

	public void DisplayHand() {
		int x = 0;
		for (Card handCards : hand) {
			x += 1;
			System.out.println(x + ": " + handCards.getName());
		}
	}

	public Object playCard() {

		chooseCard = -1;

		if (hand.size() > 0){
			System.out.println("Choose a card to play from your hand");
			System.out.println("------------------------------------");
			DisplayHand();
			System.out.println("------------------------------------");
			System.out.print("Select Card (1-" + hand.size() + "): ");
			chooseCard = stdin.nextInt() - 1;
			stdin.nextLine();
//			System.out.println("chooseCard: " + chooseCard);

			placeCardOnTableau();
		}
		else{
			System.out.println("No cards in hand.");
		}
		return null;
	}

	public void placeCardOnTableau() {

		int row = -1;
		int col = -1;

		System.out.println("Choose the row and column of the Tableau to place your card");

		System.out.print("Row: ");
		row = stdin.nextInt() - 1;

		System.out.print("Column: ");
		col = stdin.nextInt() - 1;

		stdin.nextLine();
//		System.out.println("Row = " + row + "\nColumn = " + col);

		island_board[row][col] = hand.remove(chooseCard);

		showTableau();
	}

	public void showTableau() {
//		System.out.println(Arrays.deepToString(island_board));

		System.out.println("=Tableau=");
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				System.out.print(island_board[a][b] + " | ");
			}
			System.out.println("\n---------------------------");
		}
	}
}