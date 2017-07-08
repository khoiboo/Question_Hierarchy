package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class TimeInput extends Base_Question{
	
	public TimeInput(String ID, String[] Label) {
        super(TimeInput.class.getSimpleName(), ID, Label);
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

}
