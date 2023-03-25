package crm.cards;

import crm.CardType;
import crm.oneActionCard;

public class CardColdFront extends oneActionCard {

    public CardColdFront() {
        setName("Cold Front");
        setType(CardType.EVENT);
        setSoilCost(0);
        setBasePointValue(0);
        setActionDesc("");      // Set the text for card's left action
    }

    public void executeAction() {
        // TODO Auto-generated method stub
        // Card actions not being implemented in project prototype
    }
}
