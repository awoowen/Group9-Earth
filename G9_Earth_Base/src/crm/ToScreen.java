package crm;

import java.util.Scanner;

public class ToScreen {

	private static String padZero(int i) {				// Appends leading zeros to make a 2 character string
		StringBuilder result = new StringBuilder();
		if (i <= 9) {
			result.append("0" + i);
		} else {
			result.append(i);
		}
		return result.toString();
	}

	public static void displayTableu(Tableu toDisplay) {
		StringBuilder tableuResult = new StringBuilder();			// Holds the visual representation for tableau. Each card occupies a 3x3 space of chars.
											// Card: o-o									No card:
											//		 |x|											 x
											//		 o-o 														where x is a number 1 through 16

		StringBuilder cardInfo = new StringBuilder();				// Holds the card info of the tableau. Uses output of Card.toString();

		int cardNum = 1;

		for (Card[] currRow : toDisplay.getTableu()) {				// Loop through tableau to build tableuResult and cardInfo
			StringBuilder line1 = new StringBuilder();
			StringBuilder line2 = new StringBuilder();
			StringBuilder line3 = new StringBuilder();

			for (Card currCard : currRow) {
				if (currCard.getType().equals("NOTYPE")) {
					line1.append("    ");
					line2.append(" " + padZero(cardNum) + " ");
					line3.append("    ");
				} else {
					line1.append("o--o");
					line2.append("|" + padZero(cardNum) + "|");
					line3.append("o--o");
				}

				if (!currCard.getType().equals("NOTYPE")) {
					cardInfo.append(padZero(cardNum) + ". " + currCard.toString() + "\n");
				}
				cardNum++;
			}

			tableuResult.append(line1 + "\n" + line2 + "\n" + line3 + "\n");
		}

		if (toDisplay.isEmpty())
			cardInfo.append("Tableu is empty");

		System.out.println("-----TABLEU-----");
		System.out.println(tableuResult.toString());
		System.out.println(cardInfo.toString());
	}
	
	public static void displayHand(Player activePlayer) {
		int x = 0;
		System.out.println("-----HAND-----");
		for (Card handCards : activePlayer.hand) {
			x += 1;
			System.out.println(x + ": " + handCards.toString());
		}
	}
	
	public static int requestInt(Scanner input) {
		int temp = 0;
		return temp;
	}
	
	public static String requestString(Scanner input) {
		String temp = "";
		return temp;
	}
	
	public static void playerChanges(String activePlayer, int choice, int amount) {
		if(choice == 0) {
			System.out.println(activePlayer + " gained " + amount + " soil");
		}
	}
	
	public static void inspectCardInHand(Player activePlayer, Scanner input) {
		int index;
		Card temp;
		
		displayHand(activePlayer);
		
		System.out.print("Choose a card to inspect: ");
		index = input.nextInt() - 1;
		temp = activePlayer.getCardFromHand(index);
		
		System.out.println("-----CARD-----");
		temp.toString();
	}
	
	public static void inspectCardOnTableau(Player activePlayer, Scanner input) {
		Card temp;
		int row;
		int col;
		
		displayTableu(activePlayer.getTableu());
		
		System.out.print("Choose a row (1-4): ");
		row = input.nextInt() - 1;
		System.out.print("Choose a column (1-4): ");
		col = input.nextInt() - 1;
		temp = activePlayer.getTableu().chooseCard(row, col);
		
		System.out.println("-----CARD-----");
		temp.toString();
	}
}
