package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class IncentiveType_Deserializer implements JsonDeserializer<IncentiveType>{

	public IncentiveType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String type;
		ArrayList list;
		
		Gson gson =  new Gson();
		
		JsonObject obj = json.getAsJsonObject();
		type = obj.get("type").getAsString();
		
		JsonArray jArray = obj.get("parameter").getAsJsonArray();
		list = gson.fromJson(jArray, ArrayList.class);
		
		IncentiveType newIncentiveType = new IncentiveType(type, list);
		
		return newIncentiveType;
	}

}
