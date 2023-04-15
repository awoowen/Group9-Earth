package crm.cards;
import crm.*;

public class ErrorCard extends zeroActionCard {
    public ErrorCard()
    {
        setName("You're not suppose to see this card");
        setType(CardType.EMPTYSPACE);
        setFloraType(FloraType.HERB);
        setHabitatType(false, true, false, false);
        setSoilCost(1);
        setBasePointValue(4);
    }
}
