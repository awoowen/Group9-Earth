package crm.tests;

import crm.*;
import crm.cards.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDriverTest {

	Player tester;
	EarthDeck gameDeck;
	
	@BeforeEach
	void setUpPlayer() {
		tester = new Player();
		gameDeck = new EarthDeck();
	}

	@Test
	void testPlantingActionRedo() {
		fail("Not yet implemented");
	}

	@Test
	void testCompostingAction() {
		fail("Not yet implemented");
	}

}
