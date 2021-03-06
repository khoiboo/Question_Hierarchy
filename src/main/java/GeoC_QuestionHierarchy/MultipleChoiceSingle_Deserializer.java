package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class MultipleChoiceSingle_Deserializer implements JsonDeserializer<MultipleChoiceSingle>{

	public MultipleChoiceSingle deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)	throws JsonParseException {
		String quesID;
		String quesType;
		String[] quesLabel;
		String[] subcomponent;
		
		Gson gson = new Gson();
		
		JsonObject obj = json.getAsJsonObject();
		quesID = obj.get("quesID").getAsString();
		quesType = obj.get("quesType").getAsString();
		
		JsonArray questionLabel = obj.get("quesLabel").getAsJsonArray();
		quesLabel = gson.fromJson(questionLabel, String[].class);
		
		JsonArray j_subcomponent = obj.get("subcomponent").getAsJsonArray();
		subcomponent = gson.fromJson(j_subcomponent, String[].class);
		
		MultipleChoiceSingle multiplechoicesingle = new MultipleChoiceSingle(quesID, quesLabel, subcomponent);
		
		return multiplechoicesingle;
	}

}
