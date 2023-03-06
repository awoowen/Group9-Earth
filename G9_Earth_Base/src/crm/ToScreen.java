package crm;

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
		StringBuilder tableuResult = new StringBuilder();			// Holds the visual representation for tableu. Each card occupies a 3x3 space of chars.
											// Card: o-o									No card:
											//		 |x|											 x
											//		 o-o 														where x is a number 1 through 16

		StringBuilder cardInfo = new StringBuilder();				// Holds the card info of the tableu. Uses output of Card.toString();

		int cardNum = 1;

		for (Card[] currRow : toDisplay.getTableu()) {				// Loop through tableu to build tableuResult and cardInfo
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
}
