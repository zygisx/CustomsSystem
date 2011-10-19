package customsSystem.persons;


import customsSystem.util.*;


public abstract class Person implements Validable{
	
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
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getPersonalID() {
		return this.personalID;
	}

	public boolean isAllValuesSet() {
		return (this.name != null && 
				this.surname != null && 
				this.personalID != null);
	}
	
	@Override
	public void validate(ValidationResults results) {
		if (this.name == null ||  ! Utilities.isWordFromLetters(this.name))
			results.getErrors().add("Wrong person name");
		if (this.surname == null || ! Utilities.isWordFromLetters(this.surname)) 
			results.getErrors().add("Wrong person surname");
		if (this.personalID == null ||  ! Utilities.isWordFromDigits(this.personalID))
			results.getErrors().add("Wrong personal identification code");
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + " "
			+ "Surname: " + this.surname + " "
			+ "Personal ID: " + this.personalID + " " ;
	}
	

}
