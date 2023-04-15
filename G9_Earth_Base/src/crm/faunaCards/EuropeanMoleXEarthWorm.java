package crm.faunaCards;

import crm.CardType;
import crm.FaunaCard;

public class EuropeanMoleXEarthWorm extends FaunaCard {

    public EuropeanMoleXEarthWorm() {
        setName("European Mole");
        setType(CardType.FAUNA);
        setConditionDescription("20+ Soil in your reserve");

        setSecondName("Earthworm");
        setType(CardType.FAUNA);
        setSecondConditionDescription("15+ cards in your Compost");
    }
}
