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
		
		String FreeTextSingle = "FreeTextSingle";
        String FreeTextMulti = "FreeTextMulti";
        String MultipleChoiceSingle = "MultipleChoiceSingle";
        String MultipleChoiceMulti = "MultipleChoiceMulti";
        String ContRange = "ContRange";
        String AudioSensor = "AudioSensor";
        
		String CamID;
		String CamDescription;
		boolean expiryValue;
		String startDateValue;
		String endDateValue;
		
		boolean geoBooleanValue;
		ArrayList PoI_list = new ArrayList();
		
		String startQuestion;
		ArrayList Question_Array = new ArrayList();
		ArrayList workflow = new ArrayList();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Branch.class, new Branch_Deserializer());
		gsonBuilder.registerTypeAdapter(Workflow_Element.class, new Workflow_Element_Deserializer());
		gsonBuilder.registerTypeAdapter(Base_Question.class, new BaseQuestion_Deserializer());
		gsonBuilder.registerTypeAdapter(FreeTextSingle.class, new FreeTextSingle_Deserializer());
		gsonBuilder.registerTypeAdapter(FreeTextMulti.class, new FreeTextMulti_Deserializer());
		gsonBuilder.registerTypeAdapter(MultipleChoiceSingle.class, new MultipleChoiceSingle_Deserializer());
		gsonBuilder.registerTypeAdapter(MultipleChoiceMulti.class, new MultipleChoiceMulti_Deserializer());
		gsonBuilder.registerTypeAdapter(ContRange.class, new ContRange_Deserializer());
		gsonBuilder.registerTypeAdapter(AudioSensor.class, new AudioSensor_Deserializer());
		gsonBuilder.registerTypeAdapter(PoI.class, new PoI_Deserializer());
		Gson gson = gsonBuilder.create();
		
		JsonObject obj = arg0.getAsJsonObject();
		CamID = obj.get("Campaign_ID").getAsString();
		CamDescription = obj.get("Campaign_Description").getAsString();
		expiryValue = obj.get("expiry").getAsBoolean();
		startDateValue = obj.get("startDate").getAsString();
		endDateValue = obj.get("endDate").getAsString();	
		
		geoBooleanValue = obj.get("geoBoolean").getAsBoolean();
		
		startQuestion = obj.get("startQuestion").getAsString(); 
		JsonArray ques_array = obj.get("Question_Array").getAsJsonArray();
		JsonArray workflow_array = obj.get("workflow").getAsJsonArray();
		JsonArray PoI_Json_Array = obj.get("PoI_list").getAsJsonArray();
		
		for (int i=0;i<ques_array.size();i++)
		{
			Base_Question base_question = gson.fromJson(ques_array.get(i), Base_Question.class);
			
			if (base_question.getQuestionType().equals(FreeTextSingle))
				Question_Array.add( gson.fromJson(ques_array.get(i), FreeTextSingle.class) );
			
			else if (base_question.getQuestionType().equals(FreeTextMulti))
				Question_Array.add( gson.fromJson(ques_array.get(i), FreeTextMulti.class) );
			
			else if (base_question.getQuestionType().equals(MultipleChoiceSingle))
				Question_Array.add( gson.fromJson(ques_array.get(i), MultipleChoiceSingle.class) );
			
			else if (base_question.getQuestionType().equals(MultipleChoiceMulti))
				Question_Array.add( gson.fromJson(ques_array.get(i), MultipleChoiceMulti.class));
			
			else if (base_question.getQuestionType().equals(ContRange))
				Question_Array.add( gson.fromJson(ques_array.get(i), ContRange.class));
			
			else if (base_question.getQuestionType().equals(AudioSensor))
				Question_Array.add( gson.fromJson(ques_array.get(i), AudioSensor.class));
			
		}
		
		for (int i=0;i<workflow_array.size();i++)
		{
			workflow.add( gson.fromJson(workflow_array.get(i), Workflow_Element.class) );
		}
		
		for (int i=0;i<PoI_Json_Array.size();i++)
		{
			PoI_list.add(gson.fromJson(PoI_Json_Array.get(i), PoI.class));			
		}
		
		Campaign campaign = new Campaign(CamID,CamDescription,expiryValue,startDateValue,endDateValue,geoBooleanValue,PoI_list,startQuestion,Question_Array,workflow);		
		
		return campaign;
	}

}
