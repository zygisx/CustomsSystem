package customsSystem.persons;

import customsSystem.exceptions.*;
import customsSystem.util.*;

public class Passenger extends Person implements Cloneable {

	
	protected String nationality = null;
	
	
	public Passenger (String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException {
		super(name, surname, personalID);
	}
	
	public final void setNationality(String nationality) 
			throws CustomsIllegalArgumentException {
		if (nationality == null)
			throw new CustomsNullArgumentException("Null argument.");
		if (! Utilities.isWordFromLetters(nationality))
			throw new CustomsIllegalArgumentException("Illegal argument.");
		this.nationality = nationality;
	}
	
	public final String getNationality() {
		return this.nationality;
	}
	
	/* supratnu kad atsiradus exception sitas metodas beprasmis bet dar kolkas jo netryniau */
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && this.nationality != null);
	}	
	
	@Override
	public String toString() {
		return super.toString()
			+ "Nationality: " + this.nationality + " ";
	}

	@Override
	public Passenger clone() {
		try {
			return (Passenger) super.clone();
		}
		catch (Exception ex) {
			throw new RuntimeException("Clone failure.", ex);
		}
	}
	

}
