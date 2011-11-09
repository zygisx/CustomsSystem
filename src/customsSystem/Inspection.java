package customsSystem;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import customsSystem.exceptions.*;
import customsSystem.persons.CustomsOfficer;
import customsSystem.util.Validable;
import customsSystem.util.ValidationResults;

public final class Inspection implements Validable, Cloneable {
	
	
	private CustomsOfficer officer = null;	 /* the inspector */
	private Vehicle vehicle	= null;			/* vehicle */
	private String extraDescription = null; /* Only if needed to mention something */
	private boolean isSuccessful;		/* Is inspection successful. False if Vehicle failed to pass border. */
	
	private Calendar date = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public Inspection (CustomsOfficer officer, Vehicle vehicle)
			throws CustomsNullArgumentException {
		this.setOfficer(officer);
		this.setVehicle(vehicle);
	}


	public CustomsOfficer getOfficer() {
		return this.officer;
	}
	
	public void setOfficer(CustomsOfficer officer) 
			throws CustomsNullArgumentException {
		if (officer == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.officer = officer;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) 
			throws CustomsNullArgumentException {
		if (vehicle == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.vehicle = vehicle;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}


	public boolean isSuccessful() {
		return isSuccessful;
	}
	
	/**
	 * Set date to todays date
	 */
	public void setDate () {
		this.date = GregorianCalendar.getInstance();
	}
	
	/**
	 * Set date to optional date
	 */
	public void setDate (int year, int month, int day) { 
		this.date = GregorianCalendar.getInstance();
		this.date.set(year, month, day);
	}
	
	/* return Date object */
	public Date getDate() {
		return this.date.getTime();
	}
	
	/* return date as String */
	public String getDateAsString() {
		return dateFormat.format(date.getTime());
	}
	
	/* gali but ir null vartotojo reikalas ka cia nustatinet */
	public void setDescription(String description) {
		this.extraDescription = description;
	}	
	
	public String getDescription() {
		return this.extraDescription;
	}
	
	@Override
	public void validate(ValidationResults results) {
		Calendar today = GregorianCalendar.getInstance();
		Calendar monthBefore = GregorianCalendar.getInstance();
		monthBefore.add(Calendar.MONTH, -1);
		
		if ( date.after(today) ) 
			results.getWarnings().add("Setted date is after today");
		else if  ( date.before( monthBefore ) ) 
			results.getWarnings().add("Setted date is more then month before today.");	// perspeju kad data senesne nei menesis nuo dabar
	}
	
	@Override
	public String toString() {
		return "Inspector: " + this.officer.getName() + " " + officer.getSurname() 
			+ "\nVehicle: " + this.vehicle.getVehicleNumber()
			+ "\nVehicle succesfuly pass border: "  + ( (this.isSuccessful) ? "YES\n" : "NO\n")
			+ ( (this.extraDescription != null) ? "Description: " + this.getDescription() + "\n" : "" )
			+ ( (this.date != null) ? "Inspection date: " + dateFormat.format(date.getTime()) + "\n" : "\n" );
	}


	@Override
	public Inspection clone() {
		Inspection result;
		try {
			result= (Inspection) super.clone();
	
			result.officer = officer.clone();	
			result.vehicle = vehicle.clone();
			if (date != null)
				result.date = (GregorianCalendar) this.date.clone();
			result.dateFormat = (SimpleDateFormat) this.dateFormat.clone();
		}
		catch (Exception ex) {
			throw new RuntimeException("Clone failure.", ex);
		}
		return result;
	}
	
	
}
