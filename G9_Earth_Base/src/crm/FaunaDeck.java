package crm;

import crm.cards.fauna.*;

import java.util.ArrayList;
import java.util.Collections;

public class FaunaDeck {


    private static ArrayList<Card> faunaDeck;

    /**
     * Creates the Fauna deck.
     */
    public FaunaDeck() {
        faunaDeck = new ArrayList<>();

        faunaDeck.add(new BaldEagle());
        faunaDeck.add(new PaleBilledWoodpecker());
        faunaDeck.add(new YellowBellied());
        faunaDeck.add(new MarmotRedSquirrel());
        faunaDeck.add(new EuropeanMole());
        faunaDeck.add(new EarthWorm());
        faunaDeck.add(new AndeanCondor());
        faunaDeck.add(new GreenTreeAnt());

        Collections.shuffle(faunaDeck);
    }

    public void setFaunaDeck(ArrayList<Card> faunaDeck) {
        FaunaDeck.faunaDeck = faunaDeck;
    }

    public ArrayList<Card> getFaunaDeck() {
        return faunaDeck;
    }

    public Card dealTopFaunaCard() {
        return faunaDeck.remove(0);
    }

}
