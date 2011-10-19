package customsSystem.persons;

import customsSystem.util.*;

public class Passenger extends Person implements Validable {

	
	private String nationality = null;
	
	
	public Passenger (String name, String surname, String personalID) {
		this(name, surname, personalID, "");
	}
	
	public Passenger(String name, String surname, String personalID, String nationality) {
		super(name, surname, personalID);
		this.setNationality(nationality);
	}
	
	public void setNationality(String nationality) {
		if (nationality != null && Utilities.isWordFromLetters(nationality))
			this.nationality = nationality;
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	// implements validable
	public void validate(ValidationResults results) {
		super.validate(results);
		if (this.nationality == null || ! Utilities.isWordFromLetters(this.nationality))
			results.getErrors().add("Wrong nationality");
	}
	
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && nationality != null);
	}	
	
	@Override
	public String toString() {
		return super.toString()
			+ "Nationality:" + this.nationality;
	}

}
