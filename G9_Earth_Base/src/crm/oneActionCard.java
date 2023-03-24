package crm;

public abstract class oneActionCard extends Card {
	
	private String actionDescription;
	
	public void setActionDesc(String n) {
		actionDescription = n;
	}
	public String getActionDesc() {
		return actionDescription;
	}


	//oneActionCards must implement their action. 
	public abstract void executeAction();	// Return type and parameters TBD.
	

	//Returns a string with the card's information to be viewed.
	//All one action card info fits on two lines.
	
	public String toString() {
		StringBuilder temp = new StringBuilder();
		temp.append(getName());
		temp.append(", " + getType());
		if(getType().equals("Flora")){ temp.append(", " + getFloraType());}
		if(Card.sunny){	temp.append(", " + getSunny());}	//Habitat elements
		if(Card.wet){	temp.append(", " + getWet());}
		if(Card.rocky){	temp.append(", " + getRocky());}
		if(Card.cold){	temp.append(", " + getCold());}
		if(getSoilCost() > 0) {temp.append(", soil cost: " + getSoilCost());}
		if(getBasePointValue() > 0) {temp.append(", base VP: " + getBasePointValue());}
		if(getType().equals("Flora")) {
			temp.append(", Sprout spaces: " + getSproutMax());
			temp.append(", Amount of sprouts: " + getCurrSprouts());
			temp.append(", Maximum Growth: " + getGrowthMax());
			temp.append(", Amount of Growth: " + getCurrGrowth());
			temp.append(", Canopy Completion Victory Points: " + getCanopyVP());
		}
		//temp.append("\n" + getActionDesc());
		return temp.toString();
	}
}
