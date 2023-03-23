package crm.cards;

import crm.*;

public class IndianOyster extends oneActionCard {
    public IndianOyster()
    {
        setName("Indian Oyster");
        setType(CardType.FLORA);
        setHabitatType(false, false, false, false);
        setSoilCost(4);
        setBasePointValue(5);
        setActionDesc("You may pay all/some of this Flora's cost with Cards you compost from your hand instead of soil (1 card = 1 less soil)");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //You may pay all/some of this Flora's cost with Cards you compost from your hand instead of soil (1 card = 1 less soil)
    }
}
