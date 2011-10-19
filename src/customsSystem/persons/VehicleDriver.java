package customsSystem.persons;

import customsSystem.util.*;

public class VehicleDriver extends Passenger implements Validable{

	/*
	 * Galbut atrodo kad sis paveldejimas neatitinka IS-A reikalavimo.
	 * Taciau pamasciau ir nusprendziau kad driveris kazkuria prasme irgi yra
	 * passengeris tik kazkuria prasme daugiau atsakomybes turintis zmogus - vairuojatis transporto priemone
	 */

	private String driverLicenseNumber = null;
	
	
	public VehicleDriver (String name, String surname, String personalID) {
		this(name, surname, personalID, "");
	}
	
	public VehicleDriver (String name, String surname, String personalID, String driverLicenseNumber) {
		super(name, surname, personalID);
		this.setDriverLicenseNumber(driverLicenseNumber);
	}
	
	//ToDo exception
	public void setDriverLicenseNumber (String driverLicenseNumber) {
		if (driverLicenseNumber != null && Utilities.isWordFromDigits(driverLicenseNumber) ) 
			this.driverLicenseNumber = driverLicenseNumber;
	}
	
	public String getDriverLicenseNumber() {
		return this.driverLicenseNumber;
	}
	
	public void validate(ValidationResults results) {
		super.validate(results);
		if (this.driverLicenseNumber == null || Utilities.isWordFromDigits(this.driverLicenseNumber))
			results.getErrors().add("Wrong driver license number");
	}
	
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && personalID != null);
	}

	@Override
	public String toString() {
		return super.toString() 
			+ "Drver license no.:" + this.driverLicenseNumber;
	}
	
	
}
