package customsSystem.persons;

import customsSystem.exceptions.*;
import customsSystem.util.*;


public class CustomsOfficer extends Person implements Validable, Cloneable {
	
	public enum  Experience {
		UNKNOWN, 
		JUNIOR,
		HEAD,
		TRAINEE
	}
	

	private String employeeNumber; /* valid employee number consist only from numbers */
	private Experience experience;		
	

	public CustomsOfficer(String name, String surname, String personalID,  String employeeNumber, Experience experience) 
			throws CustomsIllegalArgumentException {
		super(name, surname, personalID);
		this.setEmployeeNumber(employeeNumber);
		this.experience = experience;
		
	}

	public CustomsOfficer(String name, String surname, String personalID,  String employeeNumber) 
			throws CustomsIllegalArgumentException {
		this(name, surname, personalID, employeeNumber, Experience.UNKNOWN);
	}
	
	public CustomsOfficer(String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException {
		this(name, surname, personalID, "");
	}
	
	public final void setEmployeeNumber(String employeeNumber) 
			throws CustomsIllegalArgumentException {
		if (employeeNumber == null) 
			throw new CustomsNullArgumentException("Null argument.");
		if (! Utilities.isWordFromDigits(employeeNumber) )
			throw new CustomsIllegalArgumentException("Illegal argument.");
		this.employeeNumber = employeeNumber;
	}
	
	public final String getEmployeeNumber() {
		return this.employeeNumber;
	}

	public final Experience getExperience() {
		return this.experience;
	}

	public final void setExperience(Experience experience) 
			throws CustomsNullArgumentException{
		if (experience == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.experience = experience;
	}
	
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
	@Override
	public boolean isAllValuesSet() {				
		return (super.isAllValuesSet() && 
				this.employeeNumber != null && 
				this.experience != null);
	}
	
	@Override		/* Return information about officer */
	public String toString() {
		return super.toString() 
			+ "Employee no.:" + this.employeeNumber + " "
			+ "Experience: " + this.experience + " ";
	}

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
