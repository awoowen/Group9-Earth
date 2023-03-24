package crm.cards;

import crm.*;
public class VirginiaStrawberry extends oneActionCard{
    public VirginiaStrawberry()
    {
        setName("Virginia Strawberry");
        setType(CardType.FLORA);
        setFloraType(FloraType.HERB);
        setHabitatType(true, true, true, true);
        setSoilCost(1);
        setBasePointValue(0);
        setActionDesc("Pay: compost 1 card(s) from your hand. Gain: draw 2 card(s).");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //Pay: compost 1 card(s) from your hand. Gain: draw 2 card(s).
    }
}
