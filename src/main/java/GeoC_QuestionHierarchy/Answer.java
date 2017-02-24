package GeoC_QuestionHierarchy;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSFunction;
import org.mozilla.javascript.annotations.JSGetter;

public class Answer implements AnswerInterface{
	private List<Object> list = new ArrayList<Object>();
	private String questionID;
	private DateTime dt;
	private String questionType;
	private String campaignID;
	
	public Answer(String ID ){
		this.questionID = ID;
	}
	
	public Answer(String CamID, String quesType, String ID, List list, DateTime datetime) {
		this.questionType = quesType;
		this.questionID = ID;
		this.list = list;
		this.dt = datetime;
		this.campaignID = CamID;
	}
	
	public void setValues(List list){
		this.list = list;
	}
	
	public int count() {		
		int result = 0;
		
		if (this.list.get(0) instanceof String )
		{
			for (int i=0;i < this.list.size();i++)
				if (  !((String) list.get(i)).isEmpty() && list.get(i) != null &&  !((String) list.get(i)).trim().isEmpty()  ) { result++;}
			//System.out.println("Non-empty is " + result);
			return result;			
		}
		else return this.list.size();
	}
	
	public Object getValue(int index) {		
		return list.get(index);
	}
	
	public Object getValue() {
		if (this.list.size() ==1) 
			return this.list.get(0);
		else throw new RuntimeException("This answer has more than 1 field");		
	}
	
	public List<Object> getValues() {
		return this.list;
	}	
	
	public String getID(){
		return this.questionID;
	}
	
	public String getTimestamp() {
		return this.dt.toString();
	}
	
	public List getList(){
		return this.list;
	}
	
	public String getQuestionType() {
		return this.questionType;
	}
	
	public String getCampaignID() {
		return this.campaignID;
	}

}
