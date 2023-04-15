package crm.cards.flora;

import crm.*;

public class CardWoollyBuckeye extends oneActionCard {

    public CardWoollyBuckeye()
    {
        setName("Woolly Buckeye");
        setType(CardType.FLORA);
        setFloraType(FloraType.TREE);
        setHabitatType(true, false, true, false);
        setSoilCost(5);
        setBasePointValue(2);
        setActionDesc("Gain up to 3 growth on any 8 adjacent Flora");
    }

    @Override
    public void executeAction() {
        //Gain up to 3 growth on any 8 adjacent Flora cards
        //Clarification: You can place a total of 3 pieces distributed as you want on any of the adjacent cards.
        //You do not place 3 pieces on each card.
    }
}
