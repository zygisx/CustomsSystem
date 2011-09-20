package customsSystem;

public class CustomsOfficer {
	
	public enum  Experience {
		UNKNOWN, 
		JUNIOR,
		HEAD,
		TRAINEE
	}
	
	private String name;
	private String surname;
	private String employeeNumber; /* valid employee number consist only from numbers */
	private Experience experience;		
	
	
	public CustomsOfficer(String name, String surname, String employeeNumber, Experience experience) {
		this.name = name;
		this.surname = surname;
		if ( isWordFromDigits(employeeNumber) )		/* set employee number only if it consist from numbers */
			this.employeeNumber = employeeNumber;
		this.experience = experience;
		
	}

	public CustomsOfficer(String name, String surname, String employeeNumber) {
		this(name, surname, employeeNumber, Experience.UNKNOWN);
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
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
	public boolean isOfficerSet() {				
		return (name != null && surname != null && employeeNumber != null);
	}
	
	@Override		/* Return information about officer */
	public String toString() {
		return "Name: " + name + "\n"
			+ "Surname: " + surname + "\n"
			+ "Employee no.:" + employeeNumber + "\n"
			+ "Experience: " + experience + "\n";
	}
	
	private boolean isWordFromDigits (String word) {
		for ( char c : word.toCharArray() ) {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}

}