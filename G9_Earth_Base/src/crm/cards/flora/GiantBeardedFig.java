package crm.cards.flora;

import crm.*;

public class GiantBeardedFig extends oneActionCard{
    public GiantBeardedFig()
    {
        setName("Giant Beared Fig");
        setType(CardType.FLORA);
        setFloraType(FloraType.TREE);
        setHabitatType(true, false, false, false);
        setSoilCost(1);
        setBasePointValue(3);
        setActionDesc("You may pay all/some of this Flora's cost with growth instead of soil (1 growth = 1 less soil)");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //You may pay all/some of this Flora's cost with growth instead of soil (1 growth = 1 less soil)
    }
}
