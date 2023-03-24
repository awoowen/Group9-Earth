package crm.cards;

import crm.*;
public class CatSpruce extends oneActionCard{
    public CatSpruce()
    {
        setName("Cat Spruce");
        setType(CardType.FLORA);
        setFloraType(FloraType.TREE);
        setHabitatType(false, false, false, true);
        setSoilCost(2);
        setBasePointValue(2);
        setActionDesc("Pay: 1 soil. Gain: 3 growth.");
    }

    @Override
    public void executeAction()
    {
        //TBD implementation
        //Pay: 1 soil. Gain: 3 growth
    }
}
