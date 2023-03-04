package crm;

public abstract class Card {
	private String name;		// name on card; in rulebook: PDF page 4 number 5
	private CardType type;		// type of card; in rulebook: PDF page 4
	
	/*
	 * Children of Card must define toString
	 * 
	 * Returns a String for the View to generate UI.
	 */ 
	public abstract String toString();		
	
	public String getName() {
		return name;
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
}
