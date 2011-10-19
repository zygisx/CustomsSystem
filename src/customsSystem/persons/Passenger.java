package customsSystem.persons;

import customsSystem.util.*;

public class Passenger extends Person implements Validable {

	
	protected String nationality = null;
	
	
	public Passenger (String name, String surname, String personalID) {
		super(name, surname, personalID);
	}
	
	public void setNationality(String nationality) {
		if (nationality != null && Utilities.isWordFromLetters(nationality))
			this.nationality = nationality;
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	@Override	
	public void validate(ValidationResults results) {
		super.validate(results);
		if (this.nationality == null || 
				! Utilities.isWordFromLetters(this.nationality) ||
				nationality.length() < 1)  //String must contain at least 1 character. 
			results.getErrors().add("Wrong nationality");
	}
	
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && this.nationality != null);
	}	
	
	@Override
	public String toString() {
		return super.toString()
			+ "Nationality: " + this.nationality + " ";
	}

}
