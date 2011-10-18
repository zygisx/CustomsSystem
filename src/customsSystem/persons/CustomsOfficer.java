package customsSystem.persons;

import customsSystem.Utilities;


public class CustomsOfficer extends Person {
	
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