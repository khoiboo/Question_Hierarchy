package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AreaOfInterest_Deserializer implements JsonDeserializer<AreaOfInterest>{

	public AreaOfInterest deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String geometryOfArea;
		
		Gson gson = new Gson();
		
		JsonObject obj = json.getAsJsonObject();
		
		
		
		return null;
	}

}
