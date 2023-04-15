package crm.cards.flora;

import crm.*;

public class Ginger extends oneActionCard {
    public Ginger()
    {
        setName("Ginger");
        setType(CardType.FLORA);
        setFloraType(FloraType.HERB);
        setHabitatType(false, true, false, false);
        setSoilCost(1);
        setBasePointValue(4);
        setActionDesc("Gain: compost 3 card(s) from your hand.");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //Gain: compost 3 card(s) from your hand.
    }
}
