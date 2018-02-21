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

public class ExperienceType_Deserializer implements JsonDeserializer<ExperienceType>{

	public ExperienceType deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		
		int typeNumber;
		ArrayList<Object> expTypeParameter = new ArrayList();
		
		Gson gson = new Gson();
		
		JsonObject obj = arg0.getAsJsonObject();
		typeNumber = obj.get("typeNumber").getAsInt();
		JsonArray jarray = obj.get("typeParameter").getAsJsonArray();		
		for (int i=0;i<jarray.size();i++)
		{
			expTypeParameter.add( gson.fromJson(jarray.get(i), Object.class) );
		}
		
		ExperienceType expType = new ExperienceType(typeNumber, expTypeParameter);
		
		return expType;
	}

}
