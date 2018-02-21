package GeoC_QuestionHierarchy;  

public class FakeCampaign {
	String camID;
	boolean userProfileBoolean;
	UserProfile userProfile;
	
	public FakeCampaign (String camName, boolean userProfileBooleanVale, UserProfile profile)
	{
		this.camID = camName;
		this.userProfileBoolean = userProfileBooleanVale;
		this.userProfile = profile;
	}
	
	public String getCamID() { return this.camID; }
	public boolean getUserProfileBoolean() { return this.userProfileBoolean; }
	public UserProfile getUserProfile() { return this.userProfile; }

}
