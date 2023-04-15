package crm;

import crm.cards.*;
import java.util.ArrayList;
import java.util.Collections;
import crm.cards.island.*;

public class IslandDeck {
    private static ArrayList<Card> islandDeck;
    private ArrayList<Card> discardPile;

    public IslandDeck()
    {
        islandDeck = new ArrayList<>();
        discardPile = new ArrayList<>();

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
        if(islandDeck.size() > 0)
        {
            // Taking the top part of the deck
            return islandDeck.remove(0);
        }
        // If there are no cards in the deck, then we'll put
        // everything in the discard pile back into the deck
        else if(islandDeck.size() == 0)
        {
            int discardSize = discardPile.size();
            for(int i = 0; i < discardSize; i++)
            {
                // Taking cards from discard pile
                islandDeck.add(discardPile.remove(0));
            }
            shuffleDeck();
            return islandDeck.remove(0);
        }
        else
        {
            // Should something go wrong, we'll get an error card
            return new ErrorCard();
        }
    }

}
