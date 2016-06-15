package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class MultipleChoiceSingle extends Base_Question {
	String[] subcomponent;

    public MultipleChoiceSingle(String ID, String[] Label, String[] subcomponent) {
        super(MultipleChoiceSingle.class.getSimpleName(), ID, Label);
        this.subcomponent = subcomponent;
    }

    @Override
    public String toString() {
        return String.format(" Type = %s, ID = %s, Label = %s, Subcomponent = %s", quesType, quesID, Arrays.toString(quesLabel), Arrays.toString(subcomponent));
    }

    public String[] getComponent() {
        return this.subcomponent;
    }

}
