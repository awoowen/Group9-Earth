package crm;

import java.util.ArrayList;
import java.util.Collections;
import crm.cards.*;
import crm.cards.ecosystem.GreatBasinDesert;

public class EcoDeck {
    private static ArrayList<Card> ecoDeck;
    private ArrayList<Card> discardPile;

    public EcoDeck()
    {
        ecoDeck = new ArrayList<>();

        // Add some ecosystem cards
        ecoDeck.add(new GreatBasinDesert());


        shuffleDeck();
    }

    private void shuffleDeck()
    {
        Collections.shuffle(ecoDeck);
    }

    public ArrayList<Card> getEcoDeck()
    {
        return ecoDeck;
    }

    public Card dealTopEcoCard()
    {
        if(ecoDeck.size() > 0)
        {
            // Returns the top card
            return ecoDeck.remove(0);
        }
        else
        {
            // Hope we don't to this
            return new ErrorCard();
        }
    }

    // Removes the deck from the game
    public void discardDeck()
    {
        ecoDeck.clear();
    }


}
