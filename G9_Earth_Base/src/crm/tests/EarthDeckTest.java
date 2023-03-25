package crm.tests;

import crm.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EarthDeckTest {

	EarthDeck testDeck;
	
	@BeforeEach
	void setUp() throws Exception {
		testDeck = new EarthDeck();
		testDeck.discardCard(testDeck.dealTopEarthCard()); //Places one card in the discard pile
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		testDeck.setEarthDeck(tempDeck); //Empties the test deck
	}

	@Test
	void testDealTopEarthCardOfEmptyDeck() {
		Card temp;
		temp = testDeck.dealTopEarthCard(); //Attempts to deal a card from the empty deck
		assertNotNull(temp);
	}
}
