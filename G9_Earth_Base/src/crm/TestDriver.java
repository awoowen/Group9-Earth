package crm;

//import java.util.Scanner;

public class TestDriver {

    public static void main(String[] args){
    	//Scanner inputScanner = new Scanner(System.in);
        EarthDeck earthDeck = new EarthDeck();
        System.out.println("Earth Deck: " + earthDeck);
        EarthDeck.shuffleEarth();

        Player p1 = new Player(earthDeck);

        while (true) {
            p1.playCard();
            if(p1.hand.size() == 0) {
                System.out.println("No cards in hand.");
                break;
            }

        }

    }
}