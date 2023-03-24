package crm.cards;

import crm.*;
public class SlipperyJack extends twoActionCard{
    public SlipperyJack()
    {
        setName("Slippery Jack");
        setType(CardType.FLORA);
        setHabitatType(false, true, false, true);
        setSoilCost(3);
        setBasePointValue(1);
        setLeftActionDesc("Gain: compost 2 card(s) from your hand.");
        setRightActionDesc("Pay: discard 2 card(s) from your compost. Gain: 3 soil.");
    }

    @Override
    public void executeLeftAction() {
        //TBD implementation
        //Gain: compost 2 card(s) from your hand.
    }

    @Override
    public void executeRightAction() {
        //TBD implementation
        //Pay: discard 2 card(s) from your compost. Gain: 3 soil.
    }
}
