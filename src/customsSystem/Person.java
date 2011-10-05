package customsSystem;

public class Person {
	
	/* in forward this class will be extended */
	protected String name;
	protected String surname;
	protected String personalID;
	
	
	/*
	 * in future exception will be included
	 */
	public Person(String name, String surname, String personalID) {
		if (name != null && Utilities.isWordFromLetters(name))
			this.name = name;
		if (surname != null && Utilities.isWordFromLetters(surname)) 
			this.surname = surname;
		if (personalID != null && Utilities.isWordFromDigits(personalID))
			this.personalID = personalID;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getPersonalID() {
		return personalID;
	}

	@Override
	public String toString() {
		return "Name: " + name
			+ "Surname: " + surname
			+ "Personal ID: " + personalID ;
	}
	

}
