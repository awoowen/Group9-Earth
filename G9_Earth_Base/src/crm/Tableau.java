package crm;

public class Tableau {

	private Card[][] tableau;
	
	public Tableau() {
		tableau = new Card[4][4];
	}
	
	public void placeCard(Card chosenCard, int row, int col) {
		tableau[row - 1][col - 1] = chosenCard;
		showTableau();
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
