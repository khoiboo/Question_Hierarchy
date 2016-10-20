package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Answer_Deserializer implements JsonDeserializer<Answer>{

	public Answer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String camID;
		String quesID;
		ArrayList list;
		DateTime dt;
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        final Gson gson = gsonBuilder.create();
        
        JsonObject obj = json.getAsJsonObject();
        quesID = obj.get("questionID").getAsString();
        camID = obj.get("CampaignID").getAsString();
        
        JsonArray j_array = obj.get("list").getAsJsonArray();
        list = gson.fromJson(j_array, ArrayList.class);
        
        String datetime_string = obj.get("dt").getAsString();
        dt = new DateTime(datetime_string);
        
        Answer answer = new Answer(camID, quesID, list, dt);
		
		return answer;
	}

}
