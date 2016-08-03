package GeoC_QuestionHierarchy;

public class ContRange extends Base_Question{
	String[] subcomponent;

	public ContRange(String ID, String[] label, String[] subcomponent) {
		super(ContRange.class.getSimpleName(), ID, label);
		this.subcomponent = subcomponent;				
	}
	
	public String[] getComponent() {
        return this.subcomponent;
    }

}
