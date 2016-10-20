package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AudioSensor_Deserializer implements JsonDeserializer<AudioSensor>{

	public AudioSensor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String quesID;
		String[] quesLabel;		
		
		Gson gson =  new Gson();
		
		JsonObject obj = json.getAsJsonObject();
		quesID = obj.get("quesID").getAsString();
				
		JsonArray questionLabel = obj.get("quesLabel").getAsJsonArray();
		quesLabel = gson.fromJson(questionLabel, String[].class);
		
		AudioSensor audiosensor = new AudioSensor(quesID, quesLabel);
		
		return audiosensor;
	}
	
	
}
