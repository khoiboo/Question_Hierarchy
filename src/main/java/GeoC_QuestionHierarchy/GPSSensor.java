package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class GPSSensor extends Base_Question{
	
	public GPSSensor(String ID, String[] Label) {
        super(GPSSensor.class.getSimpleName(), ID, Label);
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

}
