package crm;

import crm.cards.*;
import crm.cards.event.CardColdFront;
import crm.cards.flora.CardAmericanSycamore;
import crm.cards.flora.CardFlorenceFennel;
import crm.cards.flora.CardWoollyBuckeye;
import crm.cards.flora.CatSpruce;
import crm.cards.flora.ChickenOfTheWoods;
import crm.cards.flora.GiantBeardedFig;
import crm.cards.flora.Ginger;
import crm.cards.flora.IndianOyster;
import crm.cards.flora.SlipperyJack;
import crm.cards.flora.StrangleTare;
import crm.cards.flora.VirginiaStrawberry;
import crm.cards.terrain.Aridisol;
import crm.cards.terrain.CardShrubland;
import crm.cards.terrain.FallenSequoia;
import crm.cards.terrain.RedwoodForest;
import crm.cards.terrain.SandDunes;

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
