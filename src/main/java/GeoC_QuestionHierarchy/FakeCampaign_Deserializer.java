package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class FakeCampaign_Deserializer implements JsonDeserializer<FakeCampaign> {

	public FakeCampaign deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String camID;
		boolean userProfileBoolean;
		UserProfile userProfile;
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(ExperienceType.class, new ExperienceType_Deserializer());
		gsonBuilder.registerTypeAdapter(UserProfile.class, new UserProfile_Deserializer());
		Gson gson = gsonBuilder.create();
		
		JsonObject obj = json.getAsJsonObject();
		camID = obj.get("Campaign_ID").getAsString();
		
		userProfileBoolean = obj.get("userProfileBoolean").getAsBoolean();
		
		JsonObject jObj_UserProfile = obj.get("userProfileValue").getAsJsonObject();
		userProfile = gson.fromJson(jObj_UserProfile, UserProfile.class);
		
		FakeCampaign fakeCampaign = new FakeCampaign(camID,userProfileBoolean,userProfile);

		
		return fakeCampaign;
	}

}
