package crm.cards.terrain;

import crm.*;

public class FallenSequoia extends oneActionCard{
    public FallenSequoia()
    {
        setName("Fallen Sequoia");
        setType(CardType.TERRAIN);
        setHabitatType(false, true, true, true);
        setSoilCost(2);
        setBasePointValue(9);
        setActionDesc("All Mushroom cost 1 less soil (cannot cost less than 0)");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //All Mushroom cost 1 less soil (cannot cost less than 0)
    }
}
