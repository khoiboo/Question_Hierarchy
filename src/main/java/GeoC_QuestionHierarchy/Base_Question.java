package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class Base_Question {
	protected String quesType;
    protected String quesID;
    protected String[] quesLabel;

    //Constructor
    public Base_Question (String Type, String ID, String[] Label) {
        this.quesType = Type;
        this.quesID = ID;
        this.quesLabel = Label;
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

    public String getQuestionType(){
        return this.quesType;
    }

    public String getQuestionID(){
        return this.quesID;
    }

    public String[] getQuestionLabel(){
        return this.quesLabel;
    }
    
}
