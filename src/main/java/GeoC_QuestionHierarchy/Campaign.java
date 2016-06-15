package GeoC_QuestionHierarchy;


import java.util.ArrayList;
import java.util.List;

public class Campaign {
	String Campaign_ID;
    String Campaign_Description;
    String startQuestion;
    List <Base_Question> Question_Array = new ArrayList<Base_Question>();
    List<Workflow_Element> workflow = new ArrayList<Workflow_Element>();

    public Campaign(String ID, String description, String start, List quesArray, List workflow)
    {
        this.Campaign_ID = ID;
        this.Campaign_Description = description;
        this.startQuestion = start;
        this.Question_Array = quesArray;
        this.workflow = workflow;
    }

    
    
    public String getID() {return this.Campaign_ID;}
    public String getDescription() {return this.Campaign_Description;}
    public String getStartQuestion() {return this.startQuestion;}
    public List getQuestionArray() {return this.Question_Array;}
    public List getWorkflow() {return this.workflow;}
    
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
