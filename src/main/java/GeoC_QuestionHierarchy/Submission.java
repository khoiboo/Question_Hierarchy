package GeoC_QuestionHierarchy;

public class Submission {
	
	String userID;
	String submissionContent;
	String submissionLat;
	String submissionLon;
	String submissionTime;
	
	public Submission(String user, String content, String lat, String lon, String time)
	{
		this.userID = user;
		this.submissionContent = content;
		this.submissionLat = lat;
		this.submissionLon = lon;
		this.submissionTime = time;
	}
	
	

}
