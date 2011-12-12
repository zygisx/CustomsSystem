package customsSystem.persons;

import customsSystem.exceptions.*;
import customsSystem.util.*;

/**
 * Class holds information about customs officer.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class CustomsOfficer extends Person implements Validable, Cloneable {
	
	/**
	 * Enumeration contains officers types.
	 * @author Žygimantas Gatelis
	 * @version 1.0 
	 */
	public enum  Experience {
		UNKNOWN, 
		JUNIOR,
		HEAD,
		TRAINEE
	}
	

	private String employeeNumber; /* valid employee number consist only from numbers */
	private Experience experience;		
	

	/**
	 * Constructs CustomsOfficer object.
	 * @param name officer name
	 * @param surname officer surname
	 * @param personalID officer personal identification code
	 * @param employeeNumber officer employee number
	 * @param experience officer type a.k.a. experience
	 * @throws CustomsIllegalArgumentException if one or both arguments are <code>null</code>
	 * 	or name or surname contains any non letter symbol, or employee number or personalID 
	 * 	contains any non digit symbol.
	 */
	public CustomsOfficer(String name, String surname, String personalID,  String employeeNumber, Experience experience) 
			throws CustomsIllegalArgumentException {
		super(name, surname, personalID);
		this.setEmployeeNumber(employeeNumber);
		this.experience = experience;
		
	}

	/**
	 * Constructs CustomsOfficer object.
	 * @param name officer name
	 * @param surname officer surname
	 * @param personalID officer personal identification code
	 * @param employeeNumber officer employee number
	 * @throws CustomsIllegalArgumentException if one or few arguments is <code>null</code>
	 * 	or name or surname contains any non letter symbol, or employee number or personalID 
	 * 	contains any non digit symbol.
	 */
	public CustomsOfficer(String name, String surname, String personalID,  String employeeNumber) 
			throws CustomsIllegalArgumentException {
		this(name, surname, personalID, employeeNumber, Experience.UNKNOWN);
	}
	
	/**
	 Constructs CustomsOfficer object.
	 * @param name officer name
	 * @param surname officer surname
	 * @param personalID officer personal identification code
	 * @throws CustomsIllegalArgumentException if one or both arguments is <code>null</code>
	 * 	or name or surname contains any non letter symbol, or employee number or personalID 
	 * 	contains any non digit symbol.
	 */
	public CustomsOfficer(String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException {
		this(name, surname, personalID, "");
	}
	
	/**
	 * Set employee number.
	 * @param employeeNumber employee number of this customs officer.
	 * @throws CustomsIllegalArgumentException if argument is <code>null</code>
	 * or employee number contains any non digit symbol.
	 */
	public final void setEmployeeNumber(String employeeNumber) 
			throws CustomsIllegalArgumentException {
		if (employeeNumber == null) 
			throw new CustomsNullArgumentException("Null argument.");
		if (! Utilities.isWordFromDigits(employeeNumber) )
			throw new CustomsIllegalArgumentException("Illegal argument.");
		this.employeeNumber = employeeNumber;
	}
	
	/**
	 * Returns employee number.
	 * @return employee number.
	 */
	public final String getEmployeeNumber() {
		return this.employeeNumber;
	}

	/**
	 * Returns enumeration of officer experience.
	 * @return officer experience.
	 */
	public final Experience getExperience() {
		return this.experience;
	}

	/**
	 * Set officer experience.
	 * @param experience officer experience
	 * @throws CustomsNullArgumentException if argument is <code>null</code>.
	 */
	public final void setExperience(Experience experience) 
			throws CustomsNullArgumentException{
		if (experience == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.experience = experience;
	}
	
	/** 
	 * Method help to control data correctness. It set warnings of 
	 * inspections data in Validation result object.
	 * @param results in this object is set all warnings.
	 * @see customsSystem.util.Validable#validate(customsSystem.util.ValidationResults)
	 */
	@Override
	public void validate(ValidationResults results) {
		/*
		 * darbuotojo numeris turi susidet is konstanta nurodyto skaiciaus skaitmenu,
		 * taciau nevienareiksmiskai, galimi isskirtinai atvejai todel vartotojas tik perspejamas bus.
		 */
		if (this.employeeNumber.length() != Utilities.EMPLOYEE_NUMBER_LENGTH) {
			results.getWarnings().add("Possibly wrong employee number");
		}
	}
	
	/* supratnu kad atsiradus exception sitas metodas beprasmis bet dar kolkas jo netryniau */
	
	/**
	 * Returns <code>true</code> if all values not equal <code>null</code>
	 */
	@Override
	public boolean isAllValuesSet() {				
		return (super.isAllValuesSet() && 
				this.employeeNumber != null && 
				this.experience != null);
	}
	
	/**
	 * Returns customs officer information in String
	 * @return customs officer information in String
	 */
	@Override		/* Return information about officer */
	public String toString() {
		return super.toString() 
			+ "Employee no.:" + this.employeeNumber + " "
			+ "Experience: " + this.experience + " ";
	}
	
	/**
	 * Returns customs officer clone.
	 * @return customs officer clone.
	 */
	@Override
	public CustomsOfficer clone() {
		CustomsOfficer result;
		try {
			result = (CustomsOfficer) super.clone();
		}
		catch (Exception ex) {
			throw new RuntimeException("Clone failure.", ex);
		}
	 	return result;
		
	}
	
	
}
