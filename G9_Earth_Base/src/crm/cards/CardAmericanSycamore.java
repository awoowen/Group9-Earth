package crm.cards;

import crm.*;

public class CardAmericanSycamore extends twoActionCard {
	
	public CardAmericanSycamore() {
		setName("American Sycamore");
		setType(CardType.FLORA);
		setFloraType(FloraType.TREE);
		setHabitatType(true,true,true,true);
		setSoilCost(3);
		setBasePointValue(1);
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


