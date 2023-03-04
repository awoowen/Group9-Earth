package crm;

public abstract class Card {
	private String name;		// Name on card; in rulebook: PDF page 4 number 5
	private CardType type;		// Type of card; in rulebook: PDF page 4
	private int soilCost;		// How much soil it costs to plant this card.
	private int basePointValue;	// The number of points this card is worth when planted.
	
	/*
	 * Children of Card must define toString
	 * 
	 * Returns a String for the View to generate UI.
	 */ 
	public abstract String toString();	
	
	
	
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public void setType(CardType n) {
		type = n;
	}
	public String getType() {
		switch (type) {
		case FLORA:
			return "Flora";
		case TERRAIN:
			return "Terrain";
		case EVENT:
			return "Event";
		case ISLAND:
			return "Island";
		case CLIMATE:
			return "Climate";
		case ECOSYSTEM:
			return "Ecosystem";
		case FAUNA:
			return "Fauna";
		default:
			return "NOTYPE";
		}
	}
	
	/*
	 * set and get soil cost of card. The player must have at least this much soil to plant this card.
	 */
	public void setSoilCost(int n) {
		soilCost = n;
	}
	public int getSoilCost() {
		return soilCost;
	}
	
	/*
	 * set and get base victory point value of card. The player gains this many VP when the score is counted.
	 */
	public void setBasePointValue(int n) {
		basePointValue = n;
	}
	public int getBasePointValue() {
		return basePointValue;
	}
}
