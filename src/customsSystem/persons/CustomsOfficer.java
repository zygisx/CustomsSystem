package customsSystem.persons;

import customsSystem.util.*;


public class CustomsOfficer extends Person implements Validable{
	
	public enum  Experience {
		UNKNOWN, 
		JUNIOR,
		HEAD,
		TRAINEE
	}
	

	private String employeeNumber; /* valid employee number consist only from numbers */
	private Experience experience;		
	
	// ToDo throw exception
	public CustomsOfficer(String name, String surname, String personalID,  String employeeNumber, Experience experience) {
		super(name, surname, personalID);
		this.setEmployeeNumber(employeeNumber);
		this.experience = experience;
		
	}

	public CustomsOfficer(String name, String surname, String personalID,  String employeeNumber) {
		this(name, surname, personalID, employeeNumber, Experience.UNKNOWN);
	}
	
	public CustomsOfficer(String name, String surname, String personalID) {
		this(name, surname, personalID, "");
	}
	
	public void setEmployeeNumber(String employeeNumber) {
		if (employeeNumber != null && Utilities.isWordFromDigits(employeeNumber))
			this.employeeNumber = employeeNumber;
	}
	
	public String getEmployeeNumber() {
		return this.employeeNumber;
	}

	public Experience getExperience() {
		return this.experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
	@Override
	public void validate(ValidationResults results) {
		super.validate(results);
		if (this.employeeNumber == null || 
				! Utilities.isWordFromDigits(this.employeeNumber) ||
				employeeNumber.length() != Utilities.EMPLOYEE_NUMBER_LENGTH)
			results.getErrors().add("Wrong employee number");
		if (this.experience == null)
			results.getErrors().add("Wrong experiece");
	}
	
	/* return true if officer name and surname set to smth */
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
}
