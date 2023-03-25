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

		StringBuilder cardInfo = new StringBuilder();				// Holds the card info of the tableu. Uses output of Card.toString();
		
		if (toDisplay.isEmpty()) 
			cardInfo.append("Tableu is empty");
		
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
		

		System.out.println("\n-----TABLEU-----");
		System.out.println(tableuResult.toString());
		System.out.println(cardInfo.toString());
	}
	
	/* Displays a player's hand of cards
	 * Cards are numbered starting with 1
	 */
	public static void displayHand(Player activePlayer) {
		int x = 0;
		System.out.println("\n-----HAND-----");
		System.out.println("num:\tcard:");
		for (Card handCards : activePlayer.hand) {
			x += 1;
			System.out.println(x + ": " + handCards.toString());
		}
	}

	/* Displays an array of cards
	 * Cards are numbered starting with 1
	 */
	public static void displayStack(Card[] stack) {
		int x = 0;
		System.out.println("\n-----DRAWN CARDS-----");
		System.out.println("num:\tcard:");
		for (Card c : stack) {
			x += 1;
			System.out.println(x + ": " + c.toString());
		}
	}

	/* Prompt player to enter number of cards to play.
	 * Loops until valid input is entered.
	 */
	public static int plantingPrep(Player p, Scanner input) {
		displayTableu(p.getTableu());
		displayHand(p);

		int choice;
		System.out.println("\nEnter number of cards to play from hand (0-2): ");
		choice = input.nextInt();
		
		while (choice < 0 || choice > 2) {	// Loop if player entered invalid choice
			System.out.println("\nInvalid input. Enter number of cards to play from hand (0-2): ");
			choice = input.nextInt();
		}

		return choice;
	}
	
	/* Prompt player to select card from hand. 
	 * Return index (from 0) of card chosen.
	 * Returns -1 when player chooses not to play card.
	 * Returns less than -1 when player chooses to cancel
	 */
	public static int chooseFromHand(Player p, Scanner input) {
		displayHand(p);
		int choice = 0;
		System.out.println("\nEnter card number (0 to cancel and move on): ");
		choice = input.nextInt();
		while (choice < 0 || choice > p.handSize()){
			System.out.println("\nEnter card number (0 to cancel and move on): ");
			choice = input.nextInt();
		}
		return (choice - 1);
	}

	public static int chooseFromHandExpensive(Player p, Scanner input) {
		System.out.println("You don't have enough soil to play that card!");
		return chooseFromHand(p, input);
	}

	/* Prompt player to select card from array.
	 * Return index of card chosen.
	 */
	public static int chooseFromStack(Card[] c, Scanner input) {
		displayStack(c);
		int result;
		System.out.println("\nEnter card number to keep: ");
		result = input.nextInt();
		while (result < 1 || result > 4) {
			System.out.println("\nEnter card number to keep: ");
			result = input.nextInt();
		}
		return (result - 1);
	}
	
	/* 
	 * Prompt player to enter int 1-16 for choosing planting location
	 */
	public static int plantCoord(Player p, Scanner input) {
		displayTableu(p.getTableu());
		System.out.println("\nEnter a number to plant at that spot (1-16): ");
		int result = input.nextInt();
		while (result < 1 || result > 16) {
			System.out.println("\nEnter a number to plant at that spot (1-16): ");
			result = input.nextInt();
		}
		return result;
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

	public static void cannotPlantEvent() {
		System.out.print("Cannot plant an Event card. Choose a Flora or Terrain card: ");
	}

	public static void selectionOutOfRange(int size) {
		System.out.print("Choose a card from 1-" + size + ": ");
	}
}
