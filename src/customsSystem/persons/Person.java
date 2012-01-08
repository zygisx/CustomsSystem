package customsSystem.persons;


import java.io.Serializable;

import customsSystem.exceptions.*;
import customsSystem.util.*;

/**
 * Abstract class, that holds person information.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public abstract class Person implements Cloneable, Serializable {
	
	protected final String name;
	protected final String surname;
	protected final String personalID;
	
	
	/**
	 * Constructs persons object
	 * @param name person name.
	 * @param surname person surname.
	 * @param personalID person personal identification code.
	 * @throws CustomsIllegalArgumentException if one or few arguments are <code>null</code>
	 * 	or name or surname contains any non letter symbol, or personalID 
	 * 	contains any non digit symbol.
	 */
	public Person(String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException {
		if (name == null || surname == null || personalID == null)
			throw new CustomsNullArgumentException("Null argument.");
		if (name.equals("") || surname.equals("") || personalID.equals(""))
			throw new CustomsIllegalArgumentException("Empty argument.");
		if (! Utilities.isWordFromLetters(name) || 
				! Utilities.isWordFromLetters(surname) || 
				! Utilities.isWordFromDigits(personalID) )
			throw new CustomsIllegalArgumentException("Illegal argument.");
		this.name = name;
		this.surname = surname;
		this.personalID = personalID;
	}
	
	/**
	 * Returns person name
	 * @return person name
	 */
	public final String getName() {
		return this.name;
	}
	
	/**
	 * Returns this person surname.
	 * @return person surname.
	 */
	public final String getSurname() {
		return this.surname;
	}
	
	/**
	 * Returns this person ID.
	 * @return person ID.
	 */
	public final String getPersonalID() {
		return this.personalID;
	}

	/* supratnu kad atsiradus exception sitas metodas beprasmis bet dar kolkas jo netryniau */
	/**
	 * Returns <code>true</code> if all values not equal <code>null</code>
	 */
	public boolean isAllValuesSet() {
		return (this.name != null && 
				this.surname != null && 
				this.personalID != null);
	}
	/**
	 * Returns person information in String
	 * @return person information in String
	 */
	@Override
	public String toString() {
		return "Name: " + this.name + " "
			+ "Surname: " + this.surname + " "
			+ "Personal ID: " + this.personalID + " " ;
	}
	/**
	 * Returns person clone.
	 * @return person clone.
	 */
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
