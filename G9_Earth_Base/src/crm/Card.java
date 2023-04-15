package crm;

public abstract class Card {
	private String name;		// Name on card; in rulebook: PDF page 4 number 5
	private CardType type;		// Type of card; in rulebook: PDF page 4
	private int soilCost;		// How much soil it costs to plant this card.
	private int basePointValue;	// The number of points this card is worth when planted.
	private int sproutMax;		// Flora: Sprouts provide VP and can be converted to soil: PDF page 7
	private int currSprouts;	// Flora: Current number of sprouts on card
	private int growthMax;		// Flora: Growth encompasses trunks and canopies and provide VP: PDF page 8
	private int currGrowth;		// Flora: Current number of growth on card
	private int canopyVP;		// Flora: Max Growth VP

	private FloraType floraType;
	protected static boolean sunny;
	protected static boolean wet;
	protected static boolean rocky;
	protected static boolean cold;

	//Children of Card must define toString
	//Returns a String for the View to generate UI.
	public abstract String toString();	
	
	Card() {
		name = "";
		type = CardType.EMPTYSPACE;
		soilCost = 0;
		basePointValue = 0;
	}
	
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

	public CardType getCardType()
	{
		return type;
	}

	public enum FloraType {
		TREE,
		HERB,
		MUSHROOM,
		BUSH
	}

	public void setFloraType(FloraType f) {
		floraType = f;
	}

	public String getFloraType() {
		return switch (floraType) {
			case TREE -> "Tree";
			case HERB -> "Herb";
			case MUSHROOM -> "Mushroom";
			case BUSH -> "Bush";
		};
	}

	public void setHabitatType(boolean s, boolean w, boolean r, boolean c){
		sunny = s;
		wet = w;
		rocky = r;
		cold = c;
	}

	public String getSunny() {
		return "Sunny";
	}

	public String getWet() {
		return "Wet";
	}

	public String getRocky() {
		return "Rocky";
	}

	public String getCold() {
		return "Cold";
	}

	//Set and get soil cost of card. The player must have at least this much soil to plant this card.
	public void setSoilCost(int n) {
		soilCost = n;
	}
	public int getSoilCost() {
		return soilCost;
	}
	
	//Set and get base victory point value of card. The player gains this many VP when the score is counted.
	public void setBasePointValue(int n) {
		basePointValue = n;
	}
	public int getBasePointValue() {
		return basePointValue;
	}
	
	public void setSproutMax(int n) {
		sproutMax = n;
	}
	
	public int getSproutMax() {
		return sproutMax;
	}
	
	public void setGrowthMax(int n) {
		growthMax = n;
	}
	
	public int getGrowthMax() {
		return growthMax;
	}
	
	public void setCanopyVP(int n) {
		canopyVP = n;
	}
	
	public int getCanopyVP() {
		return canopyVP;
	}
	
	public void setCurrSprouts(int n) {
		currSprouts = n;
	}
	
	public void addCurrSprouts(int n) {
		currSprouts += n;
	}
	
	public void removeCurrSprouts(int n) {
		currSprouts -= n;
	}
	
	public int getCurrSprouts() {
		return currSprouts;
	}
	
	public void setCurrGrowth(int n) {
		currGrowth = n;
	}
	
	public void addCurrGrowth(int n) {
		currGrowth += n;
	}
	
	public void removeCurrGrowth(int n) {
		currGrowth -= n;
	}
	
	public int getCurrGrowth() {
		return currGrowth;
	}
}
