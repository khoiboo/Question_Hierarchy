package GeoC_QuestionHierarchy;

public class MultipleChoiceMulti extends Base_Question{
	String[] subcomponent;

	public MultipleChoiceMulti(String ID, String[] Label, String[] subcomponent) {
        super(MultipleChoiceMulti.class.getSimpleName(), ID, Label);
        this.subcomponent = subcomponent;
	}
	
	public String[] getComponent() {
        return this.subcomponent;
    }

}
