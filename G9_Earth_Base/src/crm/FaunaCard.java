package crm;

public abstract class FaunaCard extends Card {

    private String conditionDescription;
    private String secondConditionDescription;

    public void setConditionDescription(String n) {
        conditionDescription = n;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setSecondConditionDescription(String n) {
        secondConditionDescription = n;
    }

    public String getSecondConditionDescription() {
        return secondConditionDescription;
    }

//    public abstract void checkCondition();

    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("Front Side: " + getName());
        temp.append(", " + getType());
        temp.append(", " + getConditionDescription());

        temp.append("\nBack Side: " + getSecondName());
        temp.append(", " + getType());
        temp.append(", " + getSecondConditionDescription() + "\n");

        return temp.toString();
    }
}
