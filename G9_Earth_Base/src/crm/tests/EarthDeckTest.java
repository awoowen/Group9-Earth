package crm.tests;

import crm.Card;
import crm.EarthDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EarthDeckTest {

	EarthDeck testDeck;

	@BeforeEach
	void setUp() throws Exception {
		testDeck = new EarthDeck();
		testDeck.discardCard(testDeck.dealTopEarthCard()); //Places one card in the discard pile
		ArrayList<Card> tempDeck = new ArrayList<Card>();
//		testDeck.setEarthDeck(tempDeck); //Empties the test deck
	}

	@Test
	void testDealTopEarthCardOfEmptyDeck() {
		Card temp;
		temp = testDeck.dealTopEarthCard(); //Attempts to deal a card from the empty deck
		assertNotNull(temp);
	}

	/**
	 * Draws all cards in the Earth deck and discards them on to the discard pile.
	 * Earth deck becomes empty and attempting to draw from an empty Earth deck should
	 * take the discard pile to refresh the Earth deck.
	 */
	@Test
	void TestDeckRefresh() {
		Card hand;

		int size = testDeck.getEarthDeckSize();

		for (int x = 0; x < size; x++) {
			hand = testDeck.dealTopEarthCard();
			testDeck.discardCard(hand);
		}
		hand = testDeck.dealTopEarthCard();
		assertEquals(0, testDeck.getDiscardPileSize());
	}

	/**
	 *  Checks the top of the Earth deck before drawing and set to temp.
	 *  Draw top card from Earth deck and check if the card is the same as temp.
	 */
	@Test
	void TestDealTopEarthCard() {
		Card hand;
		Card temp;
		temp = testDeck.getEarthDeck().get(0);
		hand = testDeck.dealTopEarthCard();
		assertSame(temp, hand);
	}
}
