package GeoC_QuestionHierarchy;

public class UserRegistration {
	
	String userID;
	String email;
	int yearOfBirth;
	int gender;
	
	public UserRegistration(String ID, String electronicMail, int YoB, int sex)
	{
		this.userID = ID;
		this.email = electronicMail;
		this.yearOfBirth = YoB;
		this.gender = sex;
	}
	
	public String getUserID() { return this.userID;}
	public String getEmail() {return this.email; }
	public int GetYearOfBirth() {return this.yearOfBirth; }
	public int getGender() { return this.gender; }
	

}
