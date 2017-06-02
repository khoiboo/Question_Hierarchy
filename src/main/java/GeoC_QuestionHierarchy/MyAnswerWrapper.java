package GeoC_QuestionHierarchy;

import java.util.List;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSFunction;
import org.mozilla.javascript.annotations.JSGetter;

public class MyAnswerWrapper extends ScriptableObject implements AnswerInterface {
	private Answer ans;
	
	public MyAnswerWrapper(){
		this.ans = null;
	}
	
	public MyAnswerWrapper(Object answer){
		this.ans = (Answer) answer;		
	}

	@JSGetter
	public int count() {
		return ans.count();
	}

	@JSFunction
	public Object getValue(int index){
		return ans.getValue(index);
	}

	@JSGetter
	public Object getValue() {
		return ans.getValue();
	}

	@JSGetter
	public List<Object> getValues() {
		return ans.getValues();
	}

	//@Override
	public String getID() {
		return ans.getID();
	}

	@Override
	public String getClassName(){
		return "MyWrapperAnswer";
	}

	@JSGetter
	public int getNumber() {
		// TODO Auto-generated method stub
		return ans.getNumber();
	}
	
	

}
