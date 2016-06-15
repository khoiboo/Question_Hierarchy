package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class BaseQuestion_Deserializer implements JsonDeserializer<Base_Question>{

	public Base_Question deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		
		String quesID;
		String quesType;
		String[] quesLabel;
		
		Gson gson = new Gson();
		
		JsonObject obj = arg0.getAsJsonObject();
		quesID = obj.get("quesID").getAsString();
		quesType = obj.get("quesType").getAsString();
		
		JsonArray j_array = obj.get("quesLabel").getAsJsonArray();
		quesLabel = gson.fromJson(j_array, String[].class);
		
		Base_Question baseQuestion = new Base_Question(quesType, quesID, quesLabel);
		
		return baseQuestion;
	}

}
