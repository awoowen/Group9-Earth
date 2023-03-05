package crm;

import java.util.Scanner;

public class Tableu {

	private Card[][] tableu;
	
	public Tableu() {
		tableu = new Card[4][4];
	}
	
	public void placeCard(Card chosenCard) {
		int row = -1;
		int col = -1;
		Scanner input = new Scanner(System.in);

		System.out.println("Choose the row and column of the Tableau to place your card");

		System.out.print("Row: ");
		row = input.nextInt() - 1;

		System.out.print("Column: ");
		col = input.nextInt() - 1;

		input.nextLine();

		tableu[row][col] = chosenCard;

		input.close();
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
