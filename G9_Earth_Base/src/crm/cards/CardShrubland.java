package crm.cards;

import crm.*;

public class CardShrubland extends twoActionCard {

    CardShrubland() {
        setName("Shrubland");
        setType(CardType.TERRAIN);
        setHabitatType(true,true,true,true);
        setSoilCost(2);
        setBasePointValue(0);
        setLeftActionDesc("");		// Set the text for card's left action
        setRightActionDesc("");	    // Set the text for card's right action
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
