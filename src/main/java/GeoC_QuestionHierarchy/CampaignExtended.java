package GeoC_QuestionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class CampaignExtended {
	String Campaign_ID;
    String Campaign_Description;
    boolean onetime;
    boolean expiry;
    String startDate;
    String endDate;
    boolean geoBoolean;
    ArrayList<String> PoI_list = new ArrayList<String>();
    String startQuestion;
    List Question_Array = new ArrayList();
    List<Workflow_Element> workflow = new ArrayList<Workflow_Element>();
    boolean extrinsicBoolean;
    ArrayList incentiveList = new ArrayList();
    String incentiveContact;
    boolean showResult;
    int authorCode;

    int secretCode;
    
    boolean showAuthor;
    String firstName;
    String linkPic;
    
    boolean continuousSubmission;
    boolean trackedSubmission;

    boolean userProfileBoolean;
    UserProfile userProfile;

    public CampaignExtended(String ID, String description, boolean oneTimeInput, boolean expiryValue, String startDateValue, String endDateValue, 
    		boolean geoBoolean_input, ArrayList PoI_list_input,String start, List quesArray, List workflow, 
    		boolean extrinsicBooleanValue, ArrayList list_of_incentive, String incentive_Contact, boolean showResultValue, int secretCodeValue, int authorCodeValue,
    		boolean showAuthorBoolean, String firstNameValue, String linkPicValue, boolean continuousSubmissionValue, 
    		boolean trackedSubmissionValue , boolean userProfileBooleanValue , UserProfile userProfileValue)
    {
        this.Campaign_ID = ID;
        this.Campaign_Description = description;
        this.onetime = oneTimeInput;
        this.expiry = expiryValue;
        this.startDate = startDateValue;
        this.endDate = endDateValue;        
        this.geoBoolean = geoBoolean_input;
        this.PoI_list = PoI_list_input;
        this.startQuestion = start;
        this.Question_Array = quesArray;
        this.workflow = workflow;
        
        this.extrinsicBoolean = extrinsicBooleanValue;
        this.incentiveList = list_of_incentive;
        this.incentiveContact = incentive_Contact;
        
        this.showResult = showResultValue;
        
        this.secretCode = secretCodeValue;
        
        this.authorCode = authorCodeValue;
        
        this.showAuthor = showAuthorBoolean;
        this.firstName = firstNameValue;
        this.linkPic = linkPicValue; 
        
        this.continuousSubmission = continuousSubmissionValue;
        this.trackedSubmission = trackedSubmissionValue;
        this.userProfileBoolean = userProfileBooleanValue;
        this.userProfile = userProfileValue;
    }    
    
    public String getID() {return this.Campaign_ID;}
    public String getDescription() {return this.Campaign_Description;}
    public boolean getOnetimeValue()  {return this.onetime;}
    public boolean getExpiry() {return this.expiry;}
    public String getStartDate() {return this.startDate;}
    public String getEndDate() {return this.endDate;}
    public String getStartQuestion() {return this.startQuestion;}
    public List getQuestionArray() {return this.Question_Array;}
    public List getWorkflow() {return this.workflow;}
    public boolean getgeoBoolean() {return this.geoBoolean;}
    public ArrayList<String> getPoI_list() {return this.PoI_list;}
    
    public boolean getIncentiveBoolean() {return this.extrinsicBoolean;}
    public ArrayList getIncentiveType() {return this.incentiveList;}
    public String getIncentiveContact() {return this.incentiveContact;}
    
    public boolean getShowResultBoolean() {return this.showResult;}
    
    public int getCampaignSecretCode() {return this.secretCode;}
    
    public int getAuthorCode() {return this.authorCode;}
    
    public boolean getShowAuthor() {return this.showAuthor;}
    public String getAuthorFirstName() {return this.firstName;}
    public String getAuthorLinkPic() {return this.linkPic;}
    
    public boolean getContinuousSubmissionValue() { return this.continuousSubmission; }
    
    public boolean getTrackedSubmissionValue() { return this.trackedSubmission; }
    
    public boolean getUserProfileBoolean()     { return this.userProfileBoolean; }
    public UserProfile getUserProfile()			{ return this.userProfile; }
    
    public Base_Question getQuestionByID(String ID){
    	Base_Question result = null;
    	
    	for (Object object : Question_Array){
    		Base_Question question = (Base_Question) object;
    		if (question.getQuestionID().equalsIgnoreCase(ID) ) 
    			result = question;	
    	}
    	
    	/*for (int i=0;i<Question_Array.size();i++)
    	{
    		if (    ((Base_Question) Question_Array.get(i)).getQuestionID().equals(ID) ) 
    			result = (Base_Question) Question_Array.get(i);
    	}*/    	
    	return result;    	
    }

}