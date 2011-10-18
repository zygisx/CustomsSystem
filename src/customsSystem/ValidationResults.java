package customsSystem;

import java.util.ArrayList;
import java.util.List;


public class ValidationResults {
	
	private final List<String> errors = new ArrayList<String>();
	
	public ValidationResults() {
	}
	
	public boolean hasErrors() {
		return errors.size() > 0;
	}
	public List<String> getErrors() {
		return errors;
	}
	
	public void clearErrors() {
		errors.clear();
	}
	
	@Override
	public String toString() {
		return "Errors: " + errors;
	}
}
