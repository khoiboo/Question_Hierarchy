package GeoC_QuestionHierarchy;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.WrapFactory;

public class DateWrapFactory extends WrapFactory {

	       public Object wrap(Context cx, Scriptable scope, Object obj, Class<?>
	               staticType) {


	           if (obj instanceof DateTime) {
	               // Construct a JS date object
	               long time = ((DateTime) obj).getMillis();
	               System.out.println("Milisec is "+ time);
	               return cx.newObject(scope, "Date", new Object[] {time});
	           }


	           return super.wrap(cx, scope, obj, staticType);
	       }

	    }
	