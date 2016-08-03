package GeoC_QuestionHierarchy;

import java.util.List;

public interface AnswerInterface {
	
	int count();
	
	Object getValue(int index);
	
	Object getValue();
	
	List<Object> getValues();
	
	String getID();

}
