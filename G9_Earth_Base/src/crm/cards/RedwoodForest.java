package crm.cards;

import crm.*;

public class RedwoodForest extends oneActionCard {
    public RedwoodForest()
    {
        setName("Redwood Forest");
        setType(CardType.TERRAIN);
        setHabitatType(false, true, true, true);
        setSoilCost(11);
        setBasePointValue(0);
        setActionDesc("Score 2 points per Flora with 2+ growth");
    }

    @Override
    public void executeAction() {
        //Implementation TBD
        //Score 2 points per Flora with 2+ growth
    }
}
