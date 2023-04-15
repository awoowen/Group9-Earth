package crm;

import java.util.ArrayList;
import java.util.Collections;
import crm.cards.*;
import crm.cards.fauna.*;

public class FaunaDeck {

	private static ArrayList<Card> faunaDeck;
	private ArrayList<Card> discardPile;
	
	public FaunaDeck() {
		faunaDeck = new ArrayList<>();
		discardPile = new ArrayList<>();
		
		faunaDeck.add(new BaldEagle());
    faunaDeck.add(new PaleBilledWoodpecker());
    faunaDeck.add(new YellowBellied());
    faunaDeck.add(new MarmotRedSquirrel());
    faunaDeck.add(new EuropeanMole());
    faunaDeck.add(new EarthWorm());
    faunaDeck.add(new AndeanCondor());
    faunaDeck.add(new GreenTreeAnt());
		
		shuffleDeck();
	}
  
  public void setFaunaDeck(ArrayList<Card> faunaDeck) {
      FaunaDeck.faunaDeck = faunaDeck;
  }

  public ArrayList<Card> getFaunaDeck() {
      return faunaDeck;
  }

	public void shuffleDeck()
    {
        Collections.shuffle(faunaDeck);
    }
	
	public Card dealTopFaunaCard()
    {
        if(faunaDeck.size() > 0)
        {
            // Taking the top part of the deck
            return faunaDeck.remove(0);
        }
        // If there are no cards in the deck, then we'll put
        // everything in the discard pile back into the deck
        else if(faunaDeck.size() == 0)
        {
            int discardSize = discardPile.size();
            for(int i = 0; i < discardSize; i++)
            {
                // Taking cards from discard pile
            	faunaDeck.add(discardPile.remove(0));
            }
            shuffleDeck();
            return faunaDeck.remove(0);
        }
        else
        {
            // Should something go wrong, we'll get an error card
            return new ErrorCard();
        }
    }
}
