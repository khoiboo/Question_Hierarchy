package GeoC_QuestionHierarchy;

import java.util.ArrayList;

public class IncentiveType {
	String type;
	ArrayList parameter;
	
	public IncentiveType(String incentiveType, ArrayList paramList)
	{
		this.type = incentiveType;
		this.parameter = paramList;
	}
	
	public String getType()              { return this.type;}
	public ArrayList getParameter()      { return this.parameter;}	

}
