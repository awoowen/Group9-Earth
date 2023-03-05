package crm;

//import java.util.Scanner;

public class Gameboard {

	private int sprout, soil, trunk, canopy;
	private EarthDeck gameDeck;
	private Player p1;
	//private Player p2, p3, p4, p5;
	
	public Gameboard() {
		setSprout();
		setSoil();
		setTrunk();
		setCanopy();
		gameDeck = new EarthDeck();
		p1 = new Player();
		//p2 = new Player();
		//p3 = new Player();
		//p4 = new Player();
		//p5 = new Player();
	}

	/*public static void main(String[] args) {
		int playerInput;
		Gameboard thisGame = new Gameboard();
		
		System.out.print("How many players? (1-5): ");
		Scanner input = new Scanner(System.in);
		playerInput = input.nextInt(); //Assume 1 for now
		

		input.close();
	}*/

	public void setSprout() {
		sprout = 1000;
	}
	
	public void adjustSprout(int amtSprout) {
		if(sprout + amtSprout <= 0) {
			setSprout();
			sprout += amtSprout;
		} else {
			sprout += amtSprout;
		}
	}
	
	public int getSprout() {
		return sprout;
	}
	
	public void setSoil() {
		soil = 1000;
	}
	
	public void adjustSoil(int amtSoil) {
		if(soil + amtSoil <= 0) {
			setSoil();
			soil += amtSoil;
		} else {
			soil += amtSoil;
		}
	}
	
	public int getSoil() {
		return soil;
	}
	
	public void setTrunk() {
		trunk = 500;
	}
	
	public void adjustTrunk(int amtTrunk) {
		if(trunk + amtTrunk <= 0) {
			setTrunk();
			trunk += amtTrunk;
		} else {
			trunk += amtTrunk;
		}
	}
	
	public int getTrunk() {
		return trunk;
	}
	
	public void setCanopy() {
		canopy = 100;
	}
	
	public void adjustCanopy(int amtCanopy) {
		if(canopy + amtCanopy <=0) {
			setCanopy();
			canopy += amtCanopy;
		} else {
			canopy += amtCanopy;
		}
	}
	
	public int getCanopy() {
		return canopy;
	}
	
	public Player newPlayer() {
		Player temp = new Player();
		return temp;
	}
}
