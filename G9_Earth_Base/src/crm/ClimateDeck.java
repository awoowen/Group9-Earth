package crm;

import java.util.ArrayList;
import java.util.Collections;
import crm.cards.*;
import crm.cards.climate.*;

public class ClimateDeck {
	private static ArrayList<Card> climateDeck;
	private ArrayList<Card> discardPile;

	public ClimateDeck() {
		climateDeck = new ArrayList<>();
		discardPile = new ArrayList<>();
		
		//Add some cards here
		climateDeck.add(new Oceanic());
		
		shuffleDeck();
	}

	public void shuffleDeck()
    {
        Collections.shuffle(climateDeck);
    }
	
	public Card dealTopClimateCard()
    {
        if(climateDeck.size() > 0)
        {
            // Taking the top part of the deck
            return climateDeck.remove(0);
        }
        // If there are no cards in the deck, then we'll put
        // everything in the discard pile back into the deck
        else if(climateDeck.size() == 0)
        {
            int discardSize = discardPile.size();
            for(int i = 0; i < discardSize; i++)
            {
                // Taking cards from discard pile
            	climateDeck.add(discardPile.remove(0));
            }
            shuffleDeck();
            return climateDeck.remove(0);
        }
        else
        {
            // Should something go wrong, we'll get an error card
            return new ErrorCard();
        }
    }
}
