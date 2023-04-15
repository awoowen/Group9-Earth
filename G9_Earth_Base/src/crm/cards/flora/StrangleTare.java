package crm.cards.flora;

import crm.*;

public class StrangleTare extends oneActionCard {
    public StrangleTare()
    {
        setName("Strangle-Tare");
        setType(CardType.FLORA);
        setFloraType(FloraType.BUSH);
        setHabitatType(false, false, false, false);
        setSoilCost(0);
        setBasePointValue(0);
        setActionDesc("Pay: 1 sprout(s). Gain: draw 2 card(s).");
    }

    @Override
    public void executeAction() {
        //TBD implementation
        //Pay: 1 sprout(s). Gain: draw 2 card(s).
    }
}
