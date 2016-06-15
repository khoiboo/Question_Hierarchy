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



public class Workflow_Element_Deserializer implements JsonDeserializer<Workflow_Element>{

	public Workflow_Element deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		String questionID;
		ArrayList list = new ArrayList();
		
		GsonBuilder gsonBuilder = new GsonBuilder();        
        gsonBuilder.registerTypeAdapter(Branch.class, new Branch_Deserializer());
        Gson gson = gsonBuilder.create();
		
		JsonObject obj = json.getAsJsonObject();
		questionID = obj.get("QuesID").getAsString();
		
		JsonArray jarray = obj.get("Condition").getAsJsonArray();
		for (int i=0;i<jarray.size();i++)
		{
			list.add( gson.fromJson(jarray.get(i), Branch.class) );
		}
		
		Workflow_Element workflow_element = new Workflow_Element(questionID,list);
		
		return workflow_element;
	}

}
