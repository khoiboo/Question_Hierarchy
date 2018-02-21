package GeoC_QuestionHierarchy;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Participant_Deserializer implements JsonDeserializer<Participant>{

	public Participant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String str;
		double value;
		double nRank;
		double money;
		List<String> prizeArray;
		String rewardCode;
		double highestPoint;
		
		Gson gson = new Gson();
		
		JsonObject obj = json.getAsJsonObject();
		value = obj.get("expPoint").getAsDouble();
		str = obj.get("userID").getAsString();
		nRank = obj.get("nextRank").getAsDouble();
		money = obj.get("money").getAsDouble();
		rewardCode = obj.get("rewardCode").getAsString();
		highestPoint = obj.get("highestPoint").getAsDouble();
		
		JsonArray j_array = obj.get("prize").getAsJsonArray();
		prizeArray = gson.fromJson(j_array, List.class);
		
		Participant participant = new Participant(str,value,nRank, money, prizeArray, rewardCode, highestPoint);
		
		return participant;
	}
}
