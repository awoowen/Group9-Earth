package crm;

public class CardFlorenceFennel extends oneActionCard {

    CardFlorenceFennel(){
        setName("Florence Fennel");
        setType(CardType.FLORA);
        setFloraType(FloraType.HERB);
        setHabitatType(false,false,true,false);
        setSoilCost(7);
        setBasePointValue(5);
        setActionDesc("");      // Set the text for card's left action
    }

    public void executeAction() {
        // TODO Auto-generated method stub
        // Card actions not being implemented in project prototype
    }
}
