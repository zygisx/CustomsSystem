package customsSystem.persons;

import java.io.Serializable;

import customsSystem.exceptions.*;
import customsSystem.util.*;
/**
 * Class that holds passenger information.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class Passenger extends Person implements Cloneable, Serializable {

	
	protected String nationality = null;
	
	
	/**
	 * Constructs Passenger object.
	 * @param name passenger name
	 * @param surname passenger surname
	 * @param personalID passenger personal identification code
	 * @throws CustomsIllegalArgumentException if one or few arguments are <code>null</code>
	 * 	or name or surname contains any non letter symbol, or personalID 
	 * 	contains any non digit symbol.
	 */
	public Passenger (String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException {
		super(name, surname, personalID);
	}
	
	/**
	 * Set passenger nationality
	 * @param nationality person nationality
	 * @throws CustomsIllegalArgumentException if argument is <code>null</code>
	 */
	public final void setNationality(String nationality) 
			throws CustomsIllegalArgumentException {
		if (nationality == null)
			throw new CustomsNullArgumentException("Null argument.");
		if (! Utilities.isWordFromLetters(nationality))
			throw new CustomsIllegalArgumentException("Illegal argument.");
		this.nationality = nationality;
	}
	
	/**
	 * Returns passenger nationality.
	 * @return passenger nationality.
	 */
	public final String getNationality() {
		return this.nationality;
	}
	
	/* supratnu kad atsiradus exception sitas metodas beprasmis bet dar kolkas jo netryniau */
	/**
	 * Returns <code>true</code> if all values not equal <code>null</code>
	 */
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && this.nationality != null);
	}	
	/**
	 * Returns passenger information in String
	 * @return passenger information in String
	 */
	@Override
	public String toString() {
		return super.toString()
			+ "Nationality: " + this.nationality + " ";
	}

	/**
	 * Returns passenger clone.
	 * @return passenger clone.
	 */
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
