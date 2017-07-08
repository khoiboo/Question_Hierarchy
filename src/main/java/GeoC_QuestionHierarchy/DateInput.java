package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class DateInput extends Base_Question{
	
	public DateInput(String ID, String[] Label) {
        super(DateInput.class.getSimpleName(), ID, Label);
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

}
