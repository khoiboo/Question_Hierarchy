package GeoC_QuestionHierarchy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.Class;

public class App 
{
    public static void main( String[] args )
    {					
    } 
    
    
    
}

abstract class Holder<T> {
    private final T object;

    protected Holder(T object) { this.object = object; }
    public T get() { return object; }    
}
