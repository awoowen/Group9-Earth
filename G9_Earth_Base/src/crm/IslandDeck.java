package crm;

import crm.cards.*;
import crm.cards.climate.Oceanic;
import crm.cards.ecosystem.GreatBasinDesert;
import crm.cards.island.MetisShoal;

import java.util.ArrayList;
import java.util.Collections;
public class IslandDeck {
    private static ArrayList<Card> islandDeck;
    private ArrayList<Card> discardPile;

    public IslandDeck()
    {
        islandDeck = new ArrayList<>();

        //Add some cards here
        islandDeck.add(new MetisShoal());


        shuffleDeck();
    }

    public void shuffleDeck()
    {
        Collections.shuffle(islandDeck);
    }

    public Card dealTopIslandCard()
    {
        try
        {
            if(islandDeck.size() > 0)
            {
                // Taking the top part of the deck
                return islandDeck.remove(0);
            }
            else
            {
                throw new CardNotFoundException("A problem has occurred. The number of cards in the island deck is 0 or less than 0");
            }
        }
        catch(CardNotFoundException e)
        {
            // Should something go wrong, we'll get an error card
            return new ErrorCard();
        }
    }

    public void discardDeck()
    {
        islandDeck.clear();
    }

}
