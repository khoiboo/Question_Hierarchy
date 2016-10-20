package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class PoI_Deserializer implements JsonDeserializer<PoI>{

	public PoI deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)	throws JsonParseException {
		
		double lat;
		double lon;
		double radius;
		
		Gson gson =  new Gson();
		
		JsonObject obj = json.getAsJsonObject();
		
		String lat_String = obj.get("lat").getAsString();
		lat = Double.valueOf(lat_String);
		
		String lon_String = obj.get("lon").getAsString();
		lon = Double.valueOf(lon_String);
		
		String radius_String = obj.get("radius").getAsString();
		radius = Double.valueOf(radius_String);
		
		PoI point_of_interest = new PoI(lat,lon,radius);
		
		return point_of_interest;
	}
	
	
}
