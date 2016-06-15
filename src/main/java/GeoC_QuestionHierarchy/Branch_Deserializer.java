package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Branch_Deserializer implements JsonDeserializer<Branch>{

	public Branch deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String expression_string;
		String next_value;
		
		JsonObject obj = json.getAsJsonObject();
		expression_string = obj.get("expression").getAsString();
		next_value = obj.get("next").getAsString();
		
		Branch branch = new Branch(expression_string,next_value);		
		return branch;
	}

}
