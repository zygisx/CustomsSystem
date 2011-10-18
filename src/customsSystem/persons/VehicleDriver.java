package customsSystem.persons;

import customsSystem.Utilities;

public class VehicleDriver extends Passenger {

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
