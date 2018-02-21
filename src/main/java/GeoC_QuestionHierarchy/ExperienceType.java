package GeoC_QuestionHierarchy;

import java.util.ArrayList;

public class ExperienceType {
	int expTypeNumber;
	ArrayList<Object> parameter;
	
	public ExperienceType(int typeValue, ArrayList<Object> paramValue)
	{
		this.expTypeNumber = typeValue;
		this.parameter = paramValue;
	}
	
	public int getexpTypeNumber() { return this.expTypeNumber; }
	public ArrayList<Object> getParameter() { return this.parameter; }
}
