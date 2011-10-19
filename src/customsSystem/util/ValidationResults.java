package customsSystem.util;

import java.util.ArrayList;
import java.util.List;

/*
 * Siuo metu gal ir neatrodo kad klase labai naudinga,
 * taciau sukurus grafine sasaja butu laba patogu begti per text fields
 * ir spausdinti vartotojui pranesimus kuriuose laukuose ivesta bloga informacija
 * ir t.t.
 */

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
