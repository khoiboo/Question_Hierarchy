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
		
		String FreeTextSingle    		= "FreeTextSingle";
        String FreeTextMulti 			= "FreeTextMulti";
        String MultipleChoiceSingle     = "MultipleChoiceSingle";
        String MultipleChoiceMulti      = "MultipleChoiceMulti";
        String ContRange 				= "ContRange";
        String AudioSensor 				= "AudioSensor";
        String TextDisplay 				= "TextDisplay";
        String FreeNumericSingle 		= "FreeNumericSingle";
        String UploadPhoto				= "UploadPhoto";
        String DateInput				= "DateInput";
        String TimeInput				= "TimeInput";
        String WifiSensor				= "WifiSensor";
        
		String CamID;
		String CamDescription;
		boolean onetimeBoolean;
		boolean expiryValue;
		String startDateValue;
		String endDateValue;
		
		boolean geoBooleanValue;
		ArrayList PoI_list = new ArrayList<String>();
		
		String startQuestion;
		ArrayList Question_Array = new ArrayList();
		ArrayList workflow = new ArrayList();
		
		boolean incentiveBooleanValue;
		ArrayList incentiveType = new ArrayList();
		String incentiveContact;
		
		boolean showResultValue;
				
		int authorCode;
		
		boolean showAuthorValue;
		String firstName;
		String linkPic;
		
		boolean continuousSubmissionValue;
		
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
		gsonBuilder.registerTypeAdapter(TextDisplay.class, new TextDisplay_Deserializer());
		gsonBuilder.registerTypeAdapter(FreeNumericSingle.class, new FreeNumericSingle_Deserializer());
		gsonBuilder.registerTypeAdapter(IncentiveType.class, new IncentiveType_Deserializer());
		gsonBuilder.registerTypeAdapter(UploadPhoto.class, new UploadPhoto_Deserializer());
		gsonBuilder.registerTypeAdapter(DateInput.class, new DateInput_Deserializer());
		gsonBuilder.registerTypeAdapter(TimeInput.class, new TimeInput_Deserializer());
		gsonBuilder.registerTypeAdapter(WifiSensor.class, new WifiSensor_Deserializer());
		
		//gsonBuilder.registerTypeAdapter(PoI.class, new PoI_Deserializer());
		Gson gson = gsonBuilder.create();
		
		JsonObject obj = arg0.getAsJsonObject();
		CamID = obj.get("Campaign_ID").getAsString();
		CamDescription = obj.get("Campaign_Description").getAsString();
		onetimeBoolean = obj.get("onetime").getAsBoolean();
		expiryValue = obj.get("expiry").getAsBoolean();
		startDateValue = obj.get("startDate").getAsString();
		endDateValue = obj.get("endDate").getAsString();	
		
		geoBooleanValue = obj.get("geoBoolean").getAsBoolean();
		
		startQuestion = obj.get("startQuestion").getAsString(); 
		JsonArray ques_array = obj.get("Question_Array").getAsJsonArray();
		JsonArray workflow_array = obj.get("workflow").getAsJsonArray();
		JsonArray PoI_Json_Array = obj.get("PoI_list").getAsJsonArray();
		
		incentiveBooleanValue = obj.get("extrinsicBoolean").getAsBoolean();
		incentiveContact = obj.get("incentiveContact").getAsString();
		JsonArray incentiveListJArray = obj.get("incentiveList").getAsJsonArray();
		
		showResultValue = obj.get("showResult").getAsBoolean();
		
		authorCode = obj.get("authorCode").getAsInt();
		
		showAuthorValue = obj.get("showAuthor").getAsBoolean();
		firstName = obj.get("firstName").getAsString();
		linkPic = obj.get("linkPic").getAsString();
		
		continuousSubmissionValue = obj.get("continuousSubmission").getAsBoolean();
		
		for (int i=0;i<incentiveListJArray.size();i++ )
		{
			incentiveType.add(gson.fromJson(incentiveListJArray.get(i), IncentiveType.class));
		}
		
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
			
			else if (base_question.getQuestionType().equals(TextDisplay))
				Question_Array.add( gson.fromJson(ques_array.get(i), TextDisplay.class));
			
			else if (base_question.getQuestionType().equals(FreeNumericSingle))
				Question_Array.add( gson.fromJson(ques_array.get(i), FreeNumericSingle.class));
			
			else if (base_question.getQuestionType().equals(UploadPhoto))
				Question_Array.add( gson.fromJson(ques_array.get(i), UploadPhoto.class));
			
			else if (base_question.getQuestionType().equals(DateInput))
				Question_Array.add( gson.fromJson(ques_array.get(i), DateInput.class));
			
			else if (base_question.getQuestionType().equals(TimeInput))
				Question_Array.add( gson.fromJson(ques_array.get(i), TimeInput.class));
			
			else if (base_question.getQuestionType().equals(WifiSensor))
				Question_Array.add( gson.fromJson(ques_array.get(i), WifiSensor.class));
		}
		
		for (int i=0;i<workflow_array.size();i++)
		{
			workflow.add( gson.fromJson(workflow_array.get(i), Workflow_Element.class) );
		}
		
		for (int i=0;i<PoI_Json_Array.size();i++)
		{
			PoI_list.add(gson.fromJson(PoI_Json_Array.get(i), String.class));			
		}
		
		Campaign campaign = new Campaign(CamID,CamDescription,onetimeBoolean, expiryValue,startDateValue,endDateValue,geoBooleanValue,PoI_list,startQuestion,Question_Array,
										 workflow,incentiveBooleanValue,incentiveType,incentiveContact,showResultValue, authorCode, showAuthorValue, firstName, linkPic, continuousSubmissionValue);		
		
		return campaign;
	}

}
