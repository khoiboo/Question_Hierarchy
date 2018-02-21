package GeoC_QuestionHierarchy;

import java.util.ArrayList;

public class UserProfile {
	
	int gender;
	int[] ageRange;
	ArrayList<String> postCode;
	ArrayList<ExperienceType> expType = new ArrayList();
	
	public UserProfile(int genderValue, int[] ageRangeValue, ArrayList<String> postCodeArray, ArrayList<ExperienceType> expTypeArray)
	{
		this.gender = genderValue;
		this.ageRange = ageRangeValue;
		this.postCode = postCodeArray;
		this.expType = expTypeArray;	
	}
	
	public int getGender() 								{ return this.gender; }
	public int[] getageRange() 							{ return this.ageRange; }
	public ArrayList<String> getPostCode()				{ return this.postCode; }
	public ArrayList<ExperienceType> getExpType() 		{ return this.expType; }

}
