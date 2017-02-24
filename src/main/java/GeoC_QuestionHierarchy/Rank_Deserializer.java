package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Rank_Deserializer implements JsonDeserializer<Rank>{

	public Rank deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		double level;
		double weight;
		
		Gson gson =  new Gson();		
		JsonObject obj = json.getAsJsonObject();
		
		level   = obj.get("level").getAsDouble();
		weight  = obj.get("weight").getAsDouble();
		
		Rank rank = new Rank(level,weight);
		
		return rank;
	}

}
