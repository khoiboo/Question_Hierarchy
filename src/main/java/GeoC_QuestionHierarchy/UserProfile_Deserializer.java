package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class UserProfile_Deserializer implements JsonDeserializer<UserProfile>{

	public UserProfile deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(ExperienceType.class, new ExperienceType_Deserializer());
		Gson gson = gsonBuilder.create();
		
		int gender;
		int[] ageRange = new int[2];
		ArrayList<String> postCode = new ArrayList();
		ArrayList<ExperienceType> expType = new ArrayList();
		
		JsonObject obj = arg0.getAsJsonObject();
		gender = obj.get("gender").getAsInt();
		
		JsonArray ageRange_JsonArray = obj.get("age").getAsJsonArray();
		ageRange[0] = gson.fromJson(ageRange_JsonArray.get(0), Integer.class);
		ageRange[1] = gson.fromJson(ageRange_JsonArray.get(1), Integer.class);
		
		JsonArray postCode_JsonArray = obj.get("postCode").getAsJsonArray();
		for (int i=0; i < postCode_JsonArray.size();i++ )
		{
			postCode.add( gson.fromJson(postCode_JsonArray.get(i), String.class) );
		}
		
		JsonArray expType_JsonArray = obj.get("experienceType").getAsJsonArray();
		for (int i=0; i < expType_JsonArray.size(); i++)
		{
			expType.add( gson.fromJson(expType_JsonArray.get(i), ExperienceType.class) );
		}
		
		UserProfile userProfile = new UserProfile(gender,ageRange,postCode,expType);			
		
		return userProfile;
	}

}
