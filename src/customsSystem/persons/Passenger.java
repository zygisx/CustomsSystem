package customsSystem.persons;

public class Passenger extends Person {

	
	private String nationality = null;
	
	
	public Passenger (String name, String surname, String personalID) {
		this(name, surname, personalID, "");
	}
	
	public Passenger(String name, String surname, String personalID, String nationality) {
		super(name, surname, personalID);
		this.setNationality(nationality);
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && nationality != null);
	}	
	
	@Override
	public String toString() {
		return super.toString()
			+ "Nationality:" + this.nationality;
	}

}
