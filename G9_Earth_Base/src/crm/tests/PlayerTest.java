package crm.tests;

import crm.*;
import crm.cards.*;
import crm.cards.flora.CardAmericanSycamore;
import crm.cards.flora.CardFlorenceFennel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	
	Player tester;

	@BeforeEach
	void setupPlayer() {
		tester = new Player();
	}
	
	@Test
	void placeFirstCard() {
		Card first = new CardAmericanSycamore();
		tester.addToHand(first);
		tester.playCard(first, 1);
		assertFalse(tester.getTableu().isEmpty());
	}
	
	@Test
	void placeOntoFullTableu() {
		Card padder = new CardAmericanSycamore();
		for (int i = 1; i <= 16; i++) {
			tester.addToHand(padder);
			tester.playCard(padder, i);
		}
		Card last = new CardFlorenceFennel();
		tester.addToHand(last);
		assertFalse(tester.playCard(last, 1));
	}

}
