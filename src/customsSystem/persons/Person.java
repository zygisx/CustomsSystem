package customsSystem.persons;


import customsSystem.exceptions.*;
import customsSystem.util.*;


public abstract class Person implements Cloneable {
	
	protected final String name;
	protected final String surname;
	protected final String personalID;
	
	
	public Person(String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException {
		if (name == null || surname == null || personalID == null)
			throw new CustomsNullArgumentException("Null argument.");
		if (! Utilities.isWordFromLetters(name) || 
				! Utilities.isWordFromLetters(surname) || 
				! Utilities.isWordFromDigits(personalID) )
			throw new CustomsIllegalArgumentException("Illegal argument.");
		this.name = name;
		this.surname = surname;
		this.personalID = personalID;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final String getSurname() {
		return this.surname;
	}
	
	public final String getPersonalID() {
		return this.personalID;
	}

	/* supratnu kad atsiradus exception sitas metodas beprasmis bet dar kolkas jo netryniau */
	public boolean isAllValuesSet() {
		return (this.name != null && 
				this.surname != null && 
				this.personalID != null);
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + " "
			+ "Surname: " + this.surname + " "
			+ "Personal ID: " + this.personalID + " " ;
	}

	@Override
	public Person clone() {
		try {
			return (Person) super.clone();
		}
		catch (Exception ex) {
			throw new RuntimeException("Clone failure.", ex);
		}
	}


	

}
