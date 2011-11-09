package customsSystem.persons;

import customsSystem.exceptions.*;
import customsSystem.util.*;

public class VehicleDriver extends Passenger implements Cloneable{

	/*
	 * Galbut atrodo kad sis paveldejimas neatitinka IS-A reikalavimo.
	 * Taciau pamasciau ir nusprendziau kad driveris kazkuria prasme irgi yra
	 * passengeris tik turintis daugiau atsakomybes- vairuojatis transporto priemone
	 */


	private String driverLicenseNumber = null;
	
	
	public VehicleDriver (String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException{
		this(name, surname, personalID, "");
	}
	
	public VehicleDriver (String name, String surname, String personalID, String driverLicenseNumber) 
			throws CustomsIllegalArgumentException {
		super(name, surname, personalID);
		this.setDriverLicenseNumber(driverLicenseNumber);
	}
	
	//ToDo exception
	public void setDriverLicenseNumber (String driverLicenseNumber) 
			throws CustomsIllegalArgumentException {
		if (driverLicenseNumber == null)
			throw new CustomsNullArgumentException("Null argument.");
		if (! Utilities.isWordFromDigits(driverLicenseNumber) ) 
			throw new CustomsIllegalArgumentException("Illegal argument.");
		this.driverLicenseNumber = driverLicenseNumber;
	}
	
	public String getDriverLicenseNumber() {
		return this.driverLicenseNumber;
	}
	
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && this.driverLicenseNumber != null);
	}

	@Override
	public String toString() {
		return super.toString() 
			+ "Driver license no.: " + this.driverLicenseNumber + " ";
	}
	
	@Override
	public VehicleDriver clone() {
		try {
			return (VehicleDriver) super.clone();
		}
		catch (Exception ex) {
			throw new RuntimeException("Clone failure.", ex);
		}
		
	}
	
}
