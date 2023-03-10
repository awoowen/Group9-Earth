package crm;

public class Tableu {

	private Card[][] tableu;
	private int numCards;
	
	public Tableu() {
		tableu = new Card[4][4];		// Initialize tableu to empty card spaces
		for (int i = 0; i < tableu.length; i++) {
			for (int j = 0; j < tableu[i].length; j++) {
				tableu[i][j] = new CardEmptySpace();
			}
		}
		numCards = 0;
	}
	
	public boolean placeCard(Card chosenCard, int row, int col) {
		if(row < 1 || row > 4 || col < 1 || col > 4) {
			return false;
		}
		if(tableu[row - 1][col - 1].getType() == "NOTYPE") {
			tableu[row - 1][col - 1] = chosenCard;
			numCards++;
			//System.out.println("Card placed successfully.");
			return true;
		} else {
			//System.out.println("There's already a card there.");
			return false;
		}
	}

	public boolean isEmpty() {
		return numCards == 0;
	}
	
	public boolean isFull() {
		return numCards == 16;
	}
	
	public Card[][] getTableu() {
		return tableu;
	}
}