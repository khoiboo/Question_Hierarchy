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

	public IncentiveType deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)	throws JsonParseException {
		
		String typeNumber;
		ArrayList<String> incentiveParameter = new ArrayList();
		boolean finishedBooleanValue;
		ArrayList<String> incentiveParameter2 = new ArrayList();
		
		Gson gson = new Gson();
		
		JsonObject obj = arg0.getAsJsonObject();
		typeNumber = obj.get("typeNumber").getAsString();
		
		JsonArray jarray = obj.get("parameter").getAsJsonArray();		
		for (int i=0;i<jarray.size();i++)
		{
			incentiveParameter.add( gson.fromJson(jarray.get(i), String.class) );
		}
		
		finishedBooleanValue = obj.get("finishedComputation").getAsBoolean();
		
		JsonArray jarray2 = obj.get("parameter2").getAsJsonArray();		
		for (int i=0;i<jarray2.size();i++)
		{
			incentiveParameter2.add( gson.fromJson(jarray2.get(i), String.class) );
		}
		
		
		IncentiveType incentiveType = new IncentiveType(typeNumber, incentiveParameter, finishedBooleanValue, incentiveParameter2);
		
		return incentiveType;
	}

}
