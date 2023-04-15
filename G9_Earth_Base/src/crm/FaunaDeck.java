package crm;

import crm.faunaCards.*;

import java.util.ArrayList;
import java.util.Collections;

public class FaunaDeck {


    private static ArrayList<FaunaCard> faunaDeck;

    /**
     * Creates the Fauna deck.
     */
    public FaunaDeck() {
        faunaDeck = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            faunaDeck.add(new BaldEagleXPaleBilledWoodpecker());
            faunaDeck.add(new YellowBelliedXMarmotRedSquirrel());
            faunaDeck.add(new EuropeanMoleXEarthWorm());
            faunaDeck.add(new AndeanCondorXGreenTreeAnt());
        }
        Collections.shuffle(faunaDeck);
    }

    public void setFaunaDeck(ArrayList<FaunaCard> faunaDeck) {
        FaunaDeck.faunaDeck = faunaDeck;
    }

    public ArrayList<FaunaCard> getFaunaDeck() {
        return faunaDeck;
    }

    public FaunaCard dealTopFaunaCard() {
        return faunaDeck.remove(0);
    }

    public void chooseSide() {

    }

}
