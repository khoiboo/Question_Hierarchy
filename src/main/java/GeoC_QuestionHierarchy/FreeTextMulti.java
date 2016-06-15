package GeoC_QuestionHierarchy;

import java.util.Arrays;

public class FreeTextMulti extends Base_Question {
	String[] subcomponent;

    public FreeTextMulti(String ID, String[] Label, String[] subcomponent) {
        super(FreeTextMulti.class.getSimpleName(), ID, Label);
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
