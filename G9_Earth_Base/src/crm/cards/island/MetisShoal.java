package crm.cards.island;

import crm.CardType;
import crm.twoActionCard;

public class MetisShoal extends twoActionCard {

	public MetisShoal() {
		setName("Metis Shoal");
		setType(CardType.ISLAND);
		setBasePointValue(5);
		setHabitatType(true, false, true, false);
		setLeftActionDesc("");		// Set the text for card's left action
		setRightActionDesc("");		// Set the text for card's right action
	}

	public void executeLeftAction() {
		// TODO Auto-generated method stub 
		// Card actions not being implemented in project prototype

	}

	
	public void executeRightAction() {
		// TODO Auto-generated method stub
		// Card actions not being implemented in project prototype
	}
}
