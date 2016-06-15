package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class FreeTextSingle extends Base_Question{
	public FreeTextSingle(String ID, String[] Label) {
        super(FreeTextSingle.class.getSimpleName(), ID, Label);
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

}
