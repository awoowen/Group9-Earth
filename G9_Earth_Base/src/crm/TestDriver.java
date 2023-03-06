package crm;
//Group 9: Andrew Nguyen, Austin Ly, Derek Trinh, Joseph Kim
//import java.util.Scanner;

public class TestDriver {

    public static void main(String[] args){
    	//Scanner inputScanner = new Scanner(System.in);
        EarthDeck earthDeck = new EarthDeck();
        System.out.println("Earth Deck: " + earthDeck);
        EarthDeck.shuffleEarth();

        Player p1 = new Player(earthDeck);

        while (true) {
            p1.playCard(p1.hand.remove(0), 1, 1);
            if(p1.hand.size() == 0) {
                System.out.println("No cards in hand.");
                break;
            }

        }

    }
    
    public void plantingAction(Player activePlayer) {
    	//plant up to 2 cards, one at a time, into your tableu by paying soil
    	//draw 4 cards, choose 1 to keep and discard the rest into the discard pile
    	//Note: the discarded cards are NOT put into the compost pile
    	//all other players may plant 1 card in their tableau 
    }
    
    public void compostingAction(Player activePlayer) {
    	
    }
    
    public void wateringAction(Player activePlayer) {
    	
    }
    
    public void growingAction(Player activePlayer) {
    	
    }
}