package crm;

import crm.cards.*;
import crm.cards.event.*;
import crm.cards.flora.*;
import crm.cards.terrain.*;

import java.util.ArrayList;
import java.util.Collections;

public class EarthDeck {

    private static ArrayList<Card> earthDeck;
    private ArrayList<Card> discardPile;

    public EarthDeck() {
        earthDeck = new ArrayList<>();
        discardPile = new ArrayList<>();

        // There are 20 copies of each card
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

    // Looks for the first eco card on the top of the deck
    public Card drawEcocard()
    {
        try
        {
            for(int i = 0; i < earthDeck.size(); i++)
            {
                if(CardType.ECOSYSTEM == earthDeck.get(i).getCardType())
                {
                    // Putting the card into a variable then removing it after
                    Card c = earthDeck.get(i);
                    // Removing card from deck
                    earthDeck.remove(i);

                    return c;
                }
            }

            // If we don't find anything, we throw an exception saying that the card isn't found
            throw new CardNotFoundException("The card was not found in the deck.");
        }
        catch(CardNotFoundException e)
        {
            System.out.println(e);
        }

        return new ErrorCard();
    }
}
