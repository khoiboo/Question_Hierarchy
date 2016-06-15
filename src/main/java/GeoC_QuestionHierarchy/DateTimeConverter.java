package GeoC_QuestionHierarchy;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateTimeConverter implements JsonSerializer<DateTime>, JsonDeserializer<DateTime> {

    private DateTimeFormatter fmt;

    public DateTimeConverter() {
    	// will save the dates in json as yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    	 fmt = ISODateTimeFormat.dateTime();
    }

    public DateTimeConverter(DateTimeFormatter fmt) {
        this.fmt = fmt;
    }

    public JsonElement serialize(DateTime src, Type srcType, JsonSerializationContext context) {
        try {
            return new JsonPrimitive(src.toString(fmt));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new JsonPrimitive("");
    }

    public DateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            return fmt.parseDateTime(json.getAsString());
        } catch (IllegalArgumentException e) {
            // May be it came in formatted as a java.util.Date, so try that
            Date date = context.deserialize(json, Date.class);
            return new DateTime(date);
        }
    }
}