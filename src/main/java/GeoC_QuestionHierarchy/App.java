package GeoC_QuestionHierarchy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.Class;

public class App 
{
    public static void main( String[] args )
    {               
        
    	FreeTextSingle free_single = new FreeTextSingle("Q001",new String[]{"Text of Q001",null,null});
		FreeTextSingle free_single2 = new FreeTextSingle("Q003",new String[]{"Text of Q003","https://theaviationist.com/wp-content/uploads/2015/03/Su-30-Vitaly-V.-Kuzmin.jpg",null});
		FreeTextMulti free_multi = new FreeTextMulti("Q002",new String[]{"Text of Q002","http://www.airforce-technology.com/projects/su27/images/su27_2.jpg",null}, new String[]{"sub1","sub2","sub3"});
		MultipleChoiceSingle multi_single = new MultipleChoiceSingle("Q004",new String[]{"Text of Q004","http://www.janes.com/images/assets/813/57813/main__p1487765.jpg",null}, new String[]{"yes","no"});
		MultipleChoiceMulti multi_multi = new MultipleChoiceMulti("Q005",new String[]{"Where have you been?",null,null}, new String[]{"Valencia","Castellon","Barcelona"}   );
		ContRange cont_range = new ContRange("Q006", new String[]{"Select a number",null,null}, new String[]{"100","250"});
		
		List list = new ArrayList();		
		list.add(free_single);
		list.add(free_single2);
		list.add(free_multi);
		list.add(multi_single);
		list.add(multi_multi);
		list.add(cont_range);
		
		
		
		ArrayList conditionQ004 = new ArrayList();
		conditionQ004.add(      new Branch("Q004.value == 'yes'","Q002")           );
		conditionQ004.add(      new Branch("Q004.value == 'no'","Q001")           );		
		Workflow_Element elementQ004 = new Workflow_Element("Q004", conditionQ004 );
		
		ArrayList conditionQ003 = new ArrayList();
		Workflow_Element elementQ003 = new Workflow_Element("Q003", conditionQ003 );
		
		ArrayList conditionQ002 = new ArrayList();
		conditionQ002.add(      new Branch("true","Q003")           );				
		Workflow_Element elementQ002 = new Workflow_Element("Q002", conditionQ002 );
		
		ArrayList conditionQ001 = new ArrayList();
		conditionQ001.add(      new Branch("true","Q003")           );				
		Workflow_Element elementQ001 = new Workflow_Element("Q001", conditionQ001 );
		ArrayList workflow = new ArrayList();
		workflow.add(elementQ001);
		workflow.add(elementQ002);
		workflow.add(elementQ003);
		workflow.add(elementQ004);
		
		
		Campaign cam = new Campaign("Cam999","description blabla","Q004",list, workflow);
    	
		//Campaign campaign = new Campaign("Cam999","description blabla","Q001",list, workflow);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Base_Question.class, new BaseQuestion_Deserializer());
		gsonBuilder.registerTypeAdapter(Branch.class, new Branch_Deserializer());
		gsonBuilder.registerTypeAdapter(Campaign.class, new Campaign_Deserializer());		
		Gson gson = gsonBuilder.create();	
		
		String text = gson.toJson(cam);		
		System.out.println(text);
		
		Campaign cam2 = gson.fromJson(text, Campaign.class);
		List<Base_Question> question_list =  cam2.getQuestionArray();
		System.out.println(list.size());
		
		Base_Question question = question_list.get(5);
		
		if (question instanceof ContRange)
		{
			System.out.println("This is a ContRange question");
		}
		
		
		
		//System.out.println(  ((Branch) ((Workflow_Element) cam2.getWorkflow().get(3)).getCondition().get(0)).getExpression()     );
		
		
		//show("Q001",cam);					
    } 
    
    public static void show(String ID, Campaign cam)
    {
    	FreeTextSingle temp_FreeTextSingle = null;
		FreeTextMulti temp_FreeTextMulti = null;
		MultipleChoiceSingle temp_MultipleChoiceSingle = null;
		
		if (cam.getQuestionByID(ID) instanceof FreeTextSingle )
		{
			temp_FreeTextSingle = (FreeTextSingle) cam.getQuestionByID(ID);
			display(temp_FreeTextSingle);
		}
		else if (cam.getQuestionByID(ID) instanceof FreeTextMulti )
		{
			temp_FreeTextMulti = (FreeTextMulti) cam.getQuestionByID(ID);
			display(temp_FreeTextMulti);
		}
		else if (cam.getQuestionByID(ID) instanceof MultipleChoiceSingle )
		{
			temp_MultipleChoiceSingle = (MultipleChoiceSingle) cam.getQuestionByID(ID);
			display(temp_MultipleChoiceSingle);
		}    	
    }
    
    public static void display(FreeTextSingle obj) 
    {
    	System.out.println(obj.getQuestionID() + " " + obj.getQuestionType() + " " + Arrays.toString(obj.getQuestionLabel()));
    }
    public static void display(FreeTextMulti obj) 
    {
    	System.out.println(obj.getQuestionID() + " " + obj.getQuestionType() + " " + Arrays.toString(obj.getQuestionLabel()) + " " + Arrays.toString(obj.getComponent()));
    }
    public static void display(MultipleChoiceSingle obj) 
    {
    	System.out.println(obj.getQuestionID() + " " + obj.getQuestionType() + " " + Arrays.toString(obj.getQuestionLabel()) + " " + Arrays.toString(obj.getComponent()));
    }
    
    public static Holder foo(Object obj) {
        if (obj instanceof FreeTextSingle) return new Holder<FreeTextSingle>( ((FreeTextSingle) obj) ) {};
        else if (obj instanceof FreeTextMulti) return new Holder<FreeTextMulti>( ((FreeTextMulti) obj) ) {};
        else if (obj instanceof MultipleChoiceSingle) return new Holder<MultipleChoiceSingle>( ((MultipleChoiceSingle) obj) ) {};
        
		return null;
    }
    
}

abstract class Holder<T> {
    private final T object;

    protected Holder(T object) { this.object = object; }
    public T get() { return object; }    
}
