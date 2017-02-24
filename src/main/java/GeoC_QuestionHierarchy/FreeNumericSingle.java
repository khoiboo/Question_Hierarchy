package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class FreeNumericSingle extends Base_Question{
	
	public FreeNumericSingle(String ID, String[] Label) {
        super(FreeNumericSingle.class.getSimpleName(), ID, Label);
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

}
