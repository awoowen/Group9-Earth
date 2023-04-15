package crm;

import java.util.ArrayList;
import java.util.Collections;
import crm.cards.*;
import crm.cards.ecosystem.*;

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

    public void shuffleDeck()
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
        else if(ecoDeck.size() == 0)
        {
            int discardSize = discardPile.size();
            for(int i = 0; i < discardSize; i++)
            {
                ecoDeck.add(discardPile.remove(0));
            }
            shuffleDeck();
            return ecoDeck.remove(0);
        }
        else
        {
            // Hope we don't to this
            return new ErrorCard();
        }
    }


}
