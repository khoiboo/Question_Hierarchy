package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class WifiSensor_Deserializer implements JsonDeserializer<WifiSensor>{

	public WifiSensor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String quesID;
		String quesType;
		String[] quesLabel;
		
		Gson gson = new Gson();
		
		JsonObject obj = json.getAsJsonObject();
		quesID = obj.get("quesID").getAsString();
		quesType = obj.get("quesType").getAsString();
		
		JsonArray j_array = obj.get("quesLabel").getAsJsonArray();
		quesLabel = gson.fromJson(j_array, String[].class);
		
		WifiSensor wifiSensor = new WifiSensor(quesID, quesLabel);
		
		return wifiSensor;		
	}

}
