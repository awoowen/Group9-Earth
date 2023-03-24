package crm.cards;

import crm.*;


public class Aridisol extends oneActionCard {
    public Aridisol()
    {
        setName("Aridisol");
        setType(CardType.TERRAIN);
        setHabitatType(true, true, true, true);
        setSoilCost(0);
        setBasePointValue(2);
        setActionDesc("All Bush cost 2 less soil (Cannot cost less than 0)");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //All Bush cost 2 less soil (Cannot cost less than 0)
    }
}
