package crm;

import crm.cards.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UnitTest {
    static ArrayList<Card> earthDeck;
    ArrayList<Card> discardPile;


    @BeforeAll
    static void setup() {
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
    }

    @Test
    void Test1() {

    }

}
