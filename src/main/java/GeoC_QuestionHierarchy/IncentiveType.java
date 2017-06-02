package GeoC_QuestionHierarchy;

import java.util.ArrayList;

public class IncentiveType {
	String typeNumber;
	ArrayList<String> parameter;
	boolean finishedComputation;
	ArrayList<String> parameter2;
	
	
	public IncentiveType(String number, ArrayList<String> param, boolean booleanFinishedValue, ArrayList<String> param2)
	{
		this.typeNumber = number;
		this.parameter = param;
		this.finishedComputation = booleanFinishedValue;
		this.parameter2 = param2;
	}
	
	public String getTypeNumber() { return this.typeNumber;}
	public ArrayList<String> getParameter() { return this.parameter;}
	public boolean getFinishedState() {return this.finishedComputation;}
	public ArrayList<String> getParameter2() { return this.parameter2;}

}
