package crm;

import java.util.ArrayList;
import java.util.Collections;

public class EarthDeck {
	
    private static ArrayList<CardAmericanSycamore> earthDeck;
    private ArrayList<Card> discardPile;

    public EarthDeck() {
        earthDeck = new ArrayList<>();
        discardPile = new ArrayList<Card>();

        for (int i = 0; i < 1000; i++) {
            earthDeck.add(new CardAmericanSycamore());
        }
    }
    
    public ArrayList<CardAmericanSycamore> getEarthDeck() {
        return earthDeck;
    }

    public void setEarthDeck(ArrayList<CardAmericanSycamore> earthDeck) {
        EarthDeck.earthDeck = earthDeck;
    }

    public CardAmericanSycamore dealTopEarthCard() {
        if (earthDeck.size() > 0){
            return earthDeck.remove(0); // dealing the card in the 0 position of the array
        }
        //else if (earthDeck.size() == 0) {
             //Set Discard pile as the refreshed Earth Deck and shuffle it
        //}
        else{
            return null;
        }
    }

    public static void shuffleEarth() {
        Collections.shuffle(earthDeck);
    }
    
    public void discardCard(Card disCard) {
    	discardPile.add(disCard);
    }
}
