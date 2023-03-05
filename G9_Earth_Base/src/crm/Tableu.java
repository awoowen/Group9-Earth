package crm;

public class Tableu {

	private Card[][] tableu;
	
	public Tableu() {
		tableu = new Card[4][4];
	}
	
	public void placeCard(Card chosenCard, int row, int col) {
		tableu[row - 1][col - 1] = chosenCard;
		showTableu();
	}
	
	public void showTableu() {
		//System.out.println(Arrays.deepToString(island_board));

		System.out.println("=Tableau=");
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				System.out.print(tableu[a][b] + " | ");
			}
			System.out.println("\n---------------------------");
		}
	}

}
