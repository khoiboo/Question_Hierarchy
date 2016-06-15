package GeoC_QuestionHierarchy;

import java.util.ArrayList;

public class Workflow_Element {
    String QuesID;
    ArrayList Condition;

    public Workflow_Element (String quesID, ArrayList array)
    {
        this.QuesID = quesID;
        this.Condition = array;
    }

    public String getID() {	return this.QuesID;	}
    public ArrayList getCondition() { return this.Condition; }
}