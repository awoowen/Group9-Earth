package crm.cards;
import crm.*;

public class ChickenOfTheWoods extends oneActionCard {
    public ChickenOfTheWoods()
    {
        setName("Chicken of the Woods");
        setType(CardType.FLORA);
        setSoilCost(5);
        setBasePointValue(5);
        setActionDesc("Gain: compost 3 card(s) from your hand");
    }

    public void executeAction()
    {
        //TBD implementation
        //Gain: compost 3 card(s) from your hand
    }
}
