package crm;

import crm.cards.CardEmptySpace;

public class Tableu {

	private Card[][] tableu;
	private int numCards;
	
	public Tableu() {
		tableu = new Card[4][4];		// Initialize tableau to empty card spaces
		for (int i = 0; i < tableu.length; i++) {
			for (int j = 0; j < tableu[i].length; j++) {
				tableu[i][j] = new CardEmptySpace();
			}
		}
		numCards = 0;
	}
	
	public boolean placeCard(Card chosenCard, int row, int col) {
		if(tableu[row][col].getType() == "NOTYPE") {
			tableu[row][col] = chosenCard;
			numCards++;
			return true;
		} else {
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
	
	public Card chooseCard(int row, int col) {
		return tableu[row][col];
	}
	
	public int countEmptySprouts() {
		int sum = 0;
		for (Card[] r : tableu) {
			for (Card c : r) {
				sum += (c.getSproutMax() - c.getCurrSprouts());
			}
		}
		return sum;
	}
}