package crm;

public abstract class twoActionCard extends Card {
	
	private String leftActionDescription;
	private String rightActionDescription;
	
	public void setLeftActionDesc(String n) {
		leftActionDescription = n;
	}
	public String getLeftActionDesc() {
		return leftActionDescription;
	}
	
	public void setRightActionDesc(String n) {
		rightActionDescription = n;
	}
	public String getRightActionDesc() {
		return rightActionDescription;
	}

	/*
	 * twoActionCards must implement both actions.
	 */
	public abstract void executeLeftAction();	// Return type and parameters TBD.
	
	public abstract void executeRightAction();	// Return type and parameters TBD.
	
	/*
	 * Returns a string with the card's information to be viewed.
	 * All two action card info fits on two lines.
	 */
	public String toString() {
		StringBuilder temp = new StringBuilder();
		temp.append(getName());
		temp.append(", " + getType());

		if(getType().equals("Flora")){ temp.append(": " + getFloraType()); }
		if(Card.sunny){	temp.append(", " + getSunny());}		//Habitat elements
		if(Card.wet){	temp.append(", " + getWet());}
		if(Card.rocky){	temp.append(", " + getRocky());}
		if(Card.cold){	temp.append(", " + getCold());}

		temp.append(", soil cost: " + getSoilCost());
		temp.append(", base VP: " + getBasePointValue());
		//temp.append("\nLeft: " + getLeftActionDesc() + "\tRight: " + getRightActionDesc());
		return temp.toString();
	}
}
