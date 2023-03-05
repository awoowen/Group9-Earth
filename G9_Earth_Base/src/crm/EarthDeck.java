package crm;

import java.util.ArrayList;
import java.util.Collections;
public class EarthDeck {
    private static ArrayList<CardAmericanSycamore> earthDeck;

    public ArrayList<CardAmericanSycamore> getEarthDeck() {
        return earthDeck;
    }

    public void setEarthDeck(ArrayList<CardAmericanSycamore> earthDeck) {
        EarthDeck.earthDeck = earthDeck;
    }

    public EarthDeck() {
        earthDeck = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            earthDeck.add(new CardAmericanSycamore());
        }
    }

    public static CardAmericanSycamore dealTopEarthCard() {
        if (earthDeck.size() > 0){
            return earthDeck.remove(0); // dealing the card in the 0 position of the array
        }
//        else if (earthDeck.size() == 0) {
//             //Set Discard pile as the refreshed Earth Deck and shuffle it
//        }
        else{
            return null;
        }
    }

    public static void shuffleEarth() {
        Collections.shuffle(earthDeck);
    }
}
