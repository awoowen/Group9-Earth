package crm.cards.climate;

import crm.CardType;
import crm.oneActionCard;

public class Oceanic extends oneActionCard {

	public Oceanic() {
		setName("Oceanic");
		setType(CardType.CLIMATE);
		setBasePointValue(3);
		setHabitatType(true, true, false, false);
		setActionDesc("");
	}

	public void executeAction() {
		// TODO Auto-generated method stub
        // Card actions not being implemented in project prototype
	}

}
