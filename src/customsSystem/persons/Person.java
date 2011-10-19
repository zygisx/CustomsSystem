package customsSystem.persons;


import customsSystem.util.*;


public abstract class Person implements Validable{
	
	/* in forward this class will be extended */
	protected String name = null;
	protected String surname = null;
	protected String personalID = null;
	
	
	/*
	 * in future exceptions will be included
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

	public boolean isAllValuesSet() {
		return (name != null && surname != null && personalID != null);
	}
	
	// imlements Validable
	public void validate(ValidationResults results) {
		if (name == null ||  ! Utilities.isWordFromLetters(name))
			results.getErrors().add("Wrong name");
		if (surname == null || ! Utilities.isWordFromLetters(surname)) 
			results.getErrors().add("Wrong surname");
		if (personalID == null ||  ! Utilities.isWordFromDigits(personalID))
			results.getErrors().add("Wrong personal identification code");
	}
	
	@Override
	public String toString() {
		return "Name: " + name
			+ "Surname: " + surname
			+ "Personal ID: " + personalID ;
	}
	

}
