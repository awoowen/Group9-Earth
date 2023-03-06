package crm;

public class Tableau {

	private Card[][] tableau;
	private int numCards;
	
	public Tableau() {
		tableau = new Card[4][4];		// Initialize tableau to empty card spaces
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				tableau[i][j] = new CardEmptySpace();
			}
		}
		numCards = 0;
	}
	
	public boolean placeCard(Card chosenCard, int row, int col) {
		if(row < 1 || row > 4 || col < 1 || col > 4) {
			return false;
		}
		if(tableau[row - 1][col - 1] == null) {
			tableau[row - 1][col - 1] = chosenCard;
			numCards++;
			return true;
		} else {
			return false;
		}
	}
	
	public Card[][] getTableu() {
		return tableau;
	}

	public boolean isEmpty() {
		return numCards == 0;
	}
	
	public boolean isFull() {
		return numCards == 16;
	}
}
