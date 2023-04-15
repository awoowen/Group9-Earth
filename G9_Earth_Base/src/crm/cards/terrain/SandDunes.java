package crm.cards.terrain;

import crm.*;
public class SandDunes extends oneActionCard {
    public SandDunes()
    {
        setName("Sand Dunes");
        setType(CardType.TERRAIN);
        setHabitatType(true, false, true, false);
        setSoilCost(2);
        setBasePointValue(5);
        setActionDesc("All Sunny habitat cost 1 less soil (cannot cost less than 0)");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //All Sunny habitat cost 1 less soil (cannot cost less than 0)
    }
}
