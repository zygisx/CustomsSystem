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
		if (employeeNumber != null && Utilities.isWordFromDigits(employeeNumber))
			this.employeeNumber = employeeNumber;
		this.experience = experience;
		
	}

	public CustomsOfficer(String name, String surname, String personalID,  String employeeNumber) {
		this(name, surname, employeeNumber, personalID, Experience.UNKNOWN);
	}
	
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
	// implements Validable
	public void validate(ValidationResults results) {
		super.validate(results);
		if (this.employeeNumber == null || ! Utilities.isWordFromDigits(this.employeeNumber))
			results.getErrors().add("Wrong employee number");
		if (this.experience == null)
			results.getErrors().add("Wrong experiece");
	}
	
	/* return true if officer name and surname set to smth */
	@Override
	public boolean isAllValuesSet() {				
		return (super.isAllValuesSet() && employeeNumber != null && experience != null);
	}
	
	@Override		/* Return information about officer */
	public String toString() {
		return super.toString() 
			+ "Employee no.:" + employeeNumber + "\n"
			+ "Experience: " + experience + "\n";
	}
}