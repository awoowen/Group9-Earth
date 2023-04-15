package crm.faunaCards;

import crm.CardType;
import crm.FaunaCard;
import crm.Player;

public class AndeanCondorXGreenTreeAnt extends FaunaCard {

    public AndeanCondorXGreenTreeAnt() {
        setName("Andean Condor");
        setType(CardType.FAUNA);
        setConditionDescription("20+ cards in your hand");

        setSecondName("Green Tree Ant");
        setType(CardType.FAUNA);
        setSecondConditionDescription("4+ Event cards in your Event Stack");
    }
}
