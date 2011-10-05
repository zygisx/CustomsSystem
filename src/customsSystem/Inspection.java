package customsSystem;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Inspection {
	
	
	/* For now I consider that in one inspection there is only one officer, 
	 * in forward task I'll change it to list of officers  */
	private CustomsOfficer officer = null;	 /* the inspector */
	private Vehicle vehicle	= null;			/* vehicle */
	private String extraDescription = null; /* Only if needed to mention something */
	private boolean isSuccessful;		/* Is inspection successful. False if Vehicle failed to pass border. */
	
	private Calendar date = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	public Inspection (CustomsOfficer officer, Vehicle vehicle) {
		if (officer != null)
			this.officer = officer;
		if (vehicle != null)
			this.vehicle = vehicle;
	}


	public CustomsOfficer getOfficer() {
		return officer;
	}

	public Vehicle getVehicle() {
		return vehicle;
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
		date = GregorianCalendar.getInstance();
	}
	
	/**
	 * Set date to optional date
	 */
	public void setDate (int year, int month, int day) { /* Overload */
		date = GregorianCalendar.getInstance();
		date.set(year, month, day);
	}
	
	/* return Date object */
	public Date getDate() {
		return date.getTime();
	}
	
	/* return date in String */
	public String getDateAsString() {
		return dateFormat.format(date.getTime());
	}
	
	public void setDescription(String description) {
		if (description != null)
			this.extraDescription = description;
	}	
	
	public String getDescription() {
		return extraDescription;
	}
	
	@Override
	public String toString() {
		return "Inspector: " + officer.getName() + " " + officer.getSurname() 
			+ "\nVehicle: " + vehicle.getVehicleNumber()
			+ "\nVehicle succesfuly pass border: "  + ( (isSuccessful) ? "YES\n" : "NO\n")
			+ ( (extraDescription != null) ? "Description: " + getDescription() + "\n" : "" )
			+ ( (date != null) ? "Inspection date: " + dateFormat.format(date.getTime()) + "\n" : "\n" );
	}
	
}
