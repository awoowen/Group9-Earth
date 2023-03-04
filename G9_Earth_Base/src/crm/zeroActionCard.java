package crm;

public abstract class zeroActionCard extends Card {

	// These cards have no action.

	/*
	 * Returns a string with the card's information to be viewed.
	 * All zero action card info fits on one line.
	 */
	public String toString() {
		StringBuilder temp = new StringBuilder();
		temp.append(getName());
		temp.append(", " + getType());
		temp.append(", soil cost: " + getSoilCost());
		temp.append(", base VP: " + getBasePointValue());
		return temp.toString();
	}
}
