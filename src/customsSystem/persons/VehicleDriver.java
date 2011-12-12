package customsSystem.persons;

import customsSystem.exceptions.*;
import customsSystem.util.*;
/**
 * Abstract class, that holds person information.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class VehicleDriver extends Passenger implements Cloneable{

	/*
	 * Galbut atrodo kad sis paveldejimas neatitinka IS-A reikalavimo.
	 * Taciau pamasciau ir nusprendziau kad driveris kazkuria prasme irgi yra
	 * passengeris tik turintis daugiau atsakomybes- vairuojatis transporto priemone
	 */


	private String driverLicenseNumber = null;
	
	/**
	 * Constructs VehicleDriver object.
	 * @param name driver name
	 * @param surname driver surname
	 * @param personalID driver personal identification code
	 * @throws CustomsIllegalArgumentException if one or few arguments is <code>null</code>
	 * 	or name or surname contains any non letter symbol, or personalID 
	 * 	contains any non digit symbol.
	 */
	public VehicleDriver (String name, String surname, String personalID) 
			throws CustomsIllegalArgumentException{
		this(name, surname, personalID, "");
	}
	
	/**
	 * Constructs VehicleDriver object.
	 * @param name driver name
	 * @param surname driver surname
	 * @param personalID driver personal identification code
	 * @param driverLicenseNumber driver license number
	 * @throws CustomsIllegalArgumentException if one or few arguments are <code>null</code>
	 * 	or name or surname contains any non letter symbol, or personalID or driverLicenseNumber
	 * 	contains any non digit symbol.
	 */
	public VehicleDriver (String name, String surname, String personalID, String driverLicenseNumber) 
			throws CustomsIllegalArgumentException {
		super(name, surname, personalID);
		this.setDriverLicenseNumber(driverLicenseNumber);
	}
	
	/**
	 * Set driver license number.
	 * @param driverLicenseNumber driver license number.
	 * @throws CustomsIllegalArgumentException if argument is <code>null</code>
	 * 	driverLicenseNumber contains any non digit symbol.
	 */
	public void setDriverLicenseNumber (String driverLicenseNumber) 
			throws CustomsIllegalArgumentException {
		if (driverLicenseNumber == null )
			throw new CustomsNullArgumentException("Null argument.");
		if (! Utilities.isWordFromDigits(driverLicenseNumber) ) 
			throw new CustomsIllegalArgumentException("Illegal argument. \nDriver license number contains of numbers.");
		this.driverLicenseNumber = driverLicenseNumber;
	}
	
	/**
	 * Returns driver license number.
	 * @return driver license number.
	 */
	public String getDriverLicenseNumber() {
		return this.driverLicenseNumber;
	}
	
	/**
	 * Returns <code>true</code> if all values not equal <code>null</code>
	 */
	@Override
	public boolean isAllValuesSet() {
		return (super.isAllValuesSet() && this.driverLicenseNumber != null);
	}

	/**
	 * Returns vehicle driver information in String
	 * @return vehicle driver information in String
	 */
	@Override
	public String toString() {
		return super.toString() 
			+ "Driver license no.: " + this.driverLicenseNumber + " ";
	}
	
	/**
	 * Returns vehicle driver clone.
	 * @return vehicle driver clone.
	 */
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
