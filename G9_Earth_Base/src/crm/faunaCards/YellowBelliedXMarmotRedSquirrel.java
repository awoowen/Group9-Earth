package crm.faunaCards;

import crm.CardType;
import crm.FaunaCard;

public class YellowBelliedXMarmotRedSquirrel extends FaunaCard {

    public YellowBelliedXMarmotRedSquirrel() {
        setName("Yellow-Bellied Marmot");
        setType(CardType.FAUNA);
        setConditionDescription("6+ Flora, each with 4+ Sprouts");

        setSecondName("Red Squirrel");
        setType(CardType.FAUNA);
        setSecondConditionDescription("9+ Flora, each with 1+ Sprouts");
    }
}
