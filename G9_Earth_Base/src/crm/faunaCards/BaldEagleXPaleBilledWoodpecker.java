package crm.faunaCards;

import crm.CardType;
import crm.FaunaCard;

public class BaldEagleXPaleBilledWoodpecker extends FaunaCard {

    public BaldEagleXPaleBilledWoodpecker() {
        setName("Bald Eagle");
        setType(CardType.FAUNA);
        setConditionDescription("4+ Flora, each with 3+ Growth.");

        setSecondName("Pale-Billed Woodpecker");
        setType(CardType.FAUNA);
        setSecondConditionDescription("7+ Flora, each with 1+ Growth.");
    }
}
