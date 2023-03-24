package crm;

public class Faunaboard {

	private Card fauna1;
	private Card fauna2;
	private Card fauna3;
	private Card fauna4;
	private Card eco1;
	private Card eco2;
	private int FirstVP = 15;
	private int SecondVP = 11;
	private int ThirdVP = 8;
	private int FourthVP = 6;
	private int FifthVP = 5;

	public Faunaboard(Card FAUNA1, Card FAUNA2, Card FAUNA3, Card FAUNA4,
			Card sharedECO1, Card sharedECO2)
	{
		fauna1 = FAUNA1;
		fauna2 = FAUNA2;
		fauna3 = FAUNA3;
		fauna4 = FAUNA4;
		eco1 = sharedECO1;
		eco2 = sharedECO2;

	}

	public void Points() {
//        If a player meets requirements for a Fauna, set them in 1st, 2nd, 3rd, 4th, or 5th
//        to achieve victory points.
	}
}
