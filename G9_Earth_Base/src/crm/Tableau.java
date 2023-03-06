package crm;

public class Tableau {

	private Card[][] tableau;
	
	public Tableau() {
		tableau = new Card[4][4];
	}
	
	public boolean placeCard(Card chosenCard, int row, int col) {
		if(row < 1 || row > 4 || col < 1 || col > 4) {
			return false;
		}
		if(tableau[row - 1][col - 1] == null) {
			tableau[row - 1][col - 1] = chosenCard;
			showTableau();
			return true;
		} else {
			return false;
		}
	}
	
	public void showTableau() {
		//System.out.println(Arrays.deepToString(island_board));

		System.out.println("=Tableau=");
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				System.out.print(tableau[a][b] + " | ");
			}
			System.out.println("\n---------------------------");
		}
	}

}
