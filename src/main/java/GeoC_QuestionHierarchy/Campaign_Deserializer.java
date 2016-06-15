package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Campaign_Deserializer implements JsonDeserializer<Campaign>{

	public Campaign deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		String CamID;
		String CamDescription;
		String startQuestion;
		ArrayList Question_Array = new ArrayList();
		ArrayList workflow = new ArrayList();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Branch.class, new Branch_Deserializer());
		gsonBuilder.registerTypeAdapter(Workflow_Element.class, new Workflow_Element_Deserializer());
		gsonBuilder.registerTypeAdapter(Base_Question.class, new BaseQuestion_Deserializer());
		Gson gson = gsonBuilder.create();
		
		JsonObject obj = arg0.getAsJsonObject();
		CamID = obj.get("Campaign_ID").getAsString();
		CamDescription = obj.get("Campaign_Description").getAsString();
		startQuestion = obj.get("startQuestion").getAsString(); 
		JsonArray ques_array = obj.get("Question_Array").getAsJsonArray();
		JsonArray workflow_array = obj.get("workflow").getAsJsonArray();
		
		for (int i=0;i<ques_array.size();i++)
		{
			Question_Array.add( gson.fromJson(ques_array.get(i), Base_Question.class) );
		}
		
		for (int i=0;i<workflow_array.size();i++)
		{
			workflow.add( gson.fromJson(workflow_array.get(i), Workflow_Element.class) );
		}
		
		Campaign campaign = new Campaign(CamID,CamDescription,startQuestion,Question_Array,workflow);		
		
		return campaign;
	}

}
