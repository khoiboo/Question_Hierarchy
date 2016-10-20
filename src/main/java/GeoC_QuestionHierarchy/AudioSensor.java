package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class AudioSensor extends Base_Question{

	//Constructor
	public AudioSensor(String ID, String[] Label) {
		
		super(AudioSensor.class.getSimpleName(), ID, Label);		
	}
	
	@Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s", quesType, quesID, Arrays.toString(quesLabel));
    }

}
