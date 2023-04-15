package crm;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import crm.cards.*;
import crm.cards.climate.Oceanic;

public class ClimateDeck {
    private static ArrayList<Card> climateDeck;

    public ClimateDeck()
    {
        climateDeck = new ArrayList<>();

        // Add some climate cards
        climateDeck.add(new Oceanic());

        shuffleDeck();
    }

    private void shuffleDeck()
    {
        Collections.shuffle(climateDeck);
    }

    public ArrayList<Card> getClimateDeck()
    {
        return climateDeck;
    }

    public Card dealTopClimateCard()
    {
        try
        {
            if(climateDeck.size() > 0)
            {
                // Returns the top card
                return climateDeck.remove(0);
            }
            else
            {
                throw new CardNotFoundException("A problem has occurred. The number of cards in the climate deck is 0 or less than 0.");
            }
        }
        catch(CardNotFoundException e)
        {
            // We return an error card if something goes wrong
            return new ErrorCard();
        }
    }

}
