package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class WifiSensor extends Base_Question{
	
	public WifiSensor(String ID, String[] Label) {
        super(WifiSensor.class.getSimpleName(), ID, Label);
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

}
