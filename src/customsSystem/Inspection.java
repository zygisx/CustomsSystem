package customsSystem;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import customsSystem.exceptions.*;
import customsSystem.persons.CustomsOfficer;
import customsSystem.util.Validable;
import customsSystem.util.ValidationResults;

/**
 * Class contains information about inspection.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public final class Inspection implements Validable, Cloneable, Serializable {
	
	
	private CustomsOfficer officer = null;	 /* the inspector */
	private Vehicle vehicle	= null;			/* vehicle */
	private String extraDescription = null; /* Only if needed to mention something */
	private boolean isSuccessful;		/* Is inspection successful. False if Vehicle failed to pass border. */
	
	private Calendar date = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Constructs Inspection object with {@link CustomsOfficer} and {@link Vehicle} in it
	 * @param officer officer of inspection
	 * @param vehicle vehicle which was checked in inspection
	 * @throws CustomsNullArgumentException if one or both argument is <code>null</code>
	 */
	public Inspection (CustomsOfficer officer, Vehicle vehicle)
			throws CustomsNullArgumentException {
		this.setOfficer(officer);
		this.setVehicle(vehicle);
	}

	/**
	 * Returns officer which is involved in inspection
	 * @return officer which is involved in inspection
	 */
	public CustomsOfficer getOfficer() {
		return this.officer;
	}
	
	/**
	 * Set officer in this inspection
	 * @param officer suitable officer
	 * @throws CustomsNullArgumentException if one or both argument is <code>null</code>
	 */
	public void setOfficer(CustomsOfficer officer) 
			throws CustomsNullArgumentException {
		if (officer == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.officer = officer;
	}
	/**
	 * Returns vehicle which is involved in inspection
	 * @return vehicle which is involved in inspection
	 */
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	/**
	 * Set vehicle in this inspection
	 * @param vehicle suitable vehicle
	 * @throws CustomsNullArgumentException if one or both argument is <code>null</code>
	 */
	public void setVehicle(Vehicle vehicle) 
			throws CustomsNullArgumentException {
		if (vehicle == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.vehicle = vehicle;
	}
	
	/**
	 * Set inspection result. <code>True</code> if inspection is successful, <code>false
	 * </code> otherwise  
	 * @param isSuccessful boolean value of inspection result.
	 */
	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	/**
	 * Returns inspection result.
	 * @return True</code> if inspection is successful, <code>false
	 * </code> otherwise  
	 */
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
	 * @param year value of years
	 * @param month value of month, 0 - February, 1 - January, 2 - March ...
	 * @param day
	 */
	public void setDate (int year, int month, int day) { 
		this.date = GregorianCalendar.getInstance();
		this.date.set(year, month-1, day);
	}
	
	/**
	 * Returns <code>java.util.Date</code> of inspections date.
	 * @return inspections date
	 * @see java.util.Date
	 */
	public Date getDate() {
		if (date != null)
			return this.date.getTime();
		else
			return null;
	}
	
	/**
	 * Return date of inspection as String 
	 * @return date of inspection as String 
	 */
	public String getDateAsString() {
		return dateFormat.format(date.getTime());
	}
	
	/* gali but ir null vartotojo reikalas ka cia nustatinet */
	/**
	 * Set extra info about inspection.
	 * @param description description of inspection
	 */
	public void setDescription(String description) {
		this.extraDescription = description;
	}	
	
	/**
	 * Returns description of inspection
	 * @return description of inspection
	 */
	public String getDescription() {
		return this.extraDescription;
	}
	
	/** 
	 * Method help to control data correctness. It set warnings of 
	 * inspections data in Validation result object.
	 * @param results in this object is set all warnings.
	 * @see customsSystem.util.Validable#validate(customsSystem.util.ValidationResults)
	 */
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
	
	/**
	 * Returns inspection information in String
	 * @return inspection information in String
	 */
	@Override
	public String toString() {
		return "Inspector: " + this.officer.getName() + " " + officer.getSurname() 
			+ "\nVehicle: " + this.vehicle.getVehicleNumber()
			+ "\nVehicle succesfuly pass border: "  + ( (this.isSuccessful) ? "YES\n" : "NO\n")
			+ ( (this.extraDescription != null) ? "Description: " + this.getDescription() + "\n" : "" )
			+ ( (this.date != null) ? "Inspection date: " + dateFormat.format(date.getTime()) + "\n" : "\n" );
	}

	/**
	 * Returns inspection clone.
	 * @return inspection clone.
	 */
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
