package crm;

import crm.cards.*;

import java.util.ArrayList;
import java.util.Collections;

public class EarthDeck {
	
    private static ArrayList<Card> earthDeck;
    private ArrayList<Card> discardPile;

    public EarthDeck() {
        earthDeck = new ArrayList<>();
        discardPile = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            earthDeck.add(new CardAmericanSycamore());
            earthDeck.add(new CardColdFront());
            earthDeck.add(new CardFlorenceFennel());
            earthDeck.add(new CardShrubland());
            earthDeck.add(new Aridisol());
            earthDeck.add(new CardWoollyBuckeye());
            earthDeck.add(new CatSpruce());
            earthDeck.add(new ChickenOfTheWoods());
            earthDeck.add(new FallenSequoia());
            earthDeck.add(new GiantBeardedFig());
            earthDeck.add(new Ginger());
            earthDeck.add(new IndianOyster());
            earthDeck.add(new RedwoodForest());
            earthDeck.add(new SandDunes());
            earthDeck.add(new SlipperyJack());
            earthDeck.add(new StrangleTare());
            earthDeck.add(new VirginiaStrawberry());
        }
        shuffleEarth();
    }
    
    public ArrayList<Card> getEarthDeck() {
        return earthDeck;
    }

    public void setEarthDeck(ArrayList<Card> earthDeck) {
        EarthDeck.earthDeck = earthDeck;
    }

    public Card dealTopEarthCard() {
    	int temp;
    	
        if (earthDeck.size() > 0){
            return earthDeck.remove(0);     // dealing the card in the 0 position of the array
        }

        else if (earthDeck.size() == 0) {
            //Set Discard pile as the refreshed Earth Deck and shuffle it
        	temp = discardPile.size();
        	for(int i = 0; i < temp; i++) {
        		earthDeck.add(discardPile.remove(0));
        	}
        	shuffleEarth();
    		return earthDeck.remove(0);
        }
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

    public int getEarthDeckSize() {
        return earthDeck.size();
    }
}
